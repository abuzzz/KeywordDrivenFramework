package org.verify;

import java.util.List;

/**
 * Buffer to hold test method verification errors till the completion of test method execution.
 * @author <a href='mailto:gadigeppa.code@gmail.com'>Gadigeppa Jattennavar</a>
 */

/* package access only */
class TestMethodErrorBuffer {

	// thread safe while running tests in parallel
	private static ThreadLocal<List<Throwable>> testErrorBuffer = new ThreadLocal<>();
	
	static List<Throwable> get(){
		return testErrorBuffer.get();
	}
	
	static void set(List<Throwable> errorBuffer){
		testErrorBuffer.set(errorBuffer);
	}
	
	static void remove(){
		testErrorBuffer.remove();
	}
	
}
