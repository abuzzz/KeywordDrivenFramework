package org.verify;

import java.util.ArrayList;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.Utils;

/**
 * adapted from http://seleniumexamples.com/blog/guide/using-soft-assertions-in-testng/
 * @author <a href='mailto:gadigeppa.code@gmail.com'>Gadigeppa Jattennavar</a>
 */
public class TestMethodListener implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		if(method.isTestMethod()){	
			
			if(TestMethodErrorBuffer.get()!=null){
				throw new RuntimeException("Stale error buffer detected!");
			}
			
			TestMethodErrorBuffer.set(new ArrayList<Throwable>()); // each test method will have its own error buffer
		}

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		if(method.isTestMethod()){

			List<Throwable> lThrowable = TestMethodErrorBuffer.get();

			/* if there are verification failures */
			if(lThrowable.size() > 0){

				/* set test result to failure */
				testResult.setStatus(ITestResult.FAILURE);

				/* if there is assertion error/exception then add it to throwable list */
				if(testResult.getThrowable() != null){
					lThrowable.add(testResult.getThrowable());
				}

				int size = lThrowable.size();

				/* if there is only one throwable then set it directly to test result */
				if(size == 1){
					testResult.setThrowable(lThrowable.get(0));
				}else{

					StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append(")\n");
					StringBuffer fullStack = new StringBuffer();

					for(int i =0 ; i < size-1; i++){	
						failureMessage.append("(").append(i+1).append(")").append(lThrowable.get(i).getClass().getName()).append(":").append(lThrowable.get(i).getMessage()).append("\n");						
						fullStack.append("Failure ").append(i+1).append(" of ").append(size).append("\n");	
						fullStack.append(Utils.stackTrace(lThrowable.get(i),false)[1]).append("\n");
					}

					fullStack.append("Failure ").append(size).append(" of ").append(size).append("\n");
					Throwable last = lThrowable.get(size-1);					
					failureMessage.append("(").append(size).append(")").append(last.getClass().getName()).append(":").append(last.getMessage()).append("\n\n");
					
					fullStack.append(last.toString());

					testResult.setThrowable(new Throwable(failureMessage.toString() + fullStack.toString()));
					testResult.getThrowable().setStackTrace(last.getStackTrace());
				}

			}
			
			TestMethodErrorBuffer.remove(); // remove stale
			
		}
	}

}
