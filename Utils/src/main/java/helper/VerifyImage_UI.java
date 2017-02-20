package helper;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import selenium_utls.ReportLog;
import selenium_utls.ReportLog.log;

public class VerifyImage_UI {

	static ReportLog reportlog  = new ReportLog("VerifyImage_UI");
	
	public static boolean verify_image(String image1 , String image2)  {
		long start = System.currentTimeMillis();
		int q = 0 , p = 0;
		File file1 = new File("results.txt");
		
		/*
		 * if file doesnt exists, then create it if (!file.exists()) {
		 * file.createNewFile(); }
		 */
		FileWriter fw;
		try {
			fw = new FileWriter(file1.getAbsoluteFile());
		
		BufferedWriter bw = new BufferedWriter(fw);

		File file = new File(image1);
		BufferedImage image = ImageIO.read(file);
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		int[][] clr = new int[width][height];
		File files = new File(image2);
		BufferedImage images = ImageIO.read(files);
		int widthe = images.getWidth(null);
		int heighte = images.getHeight(null);
		int[][] clre = new int[widthe][heighte];
		int smw = 0;
		int smh = 0;
		
		// CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT
		if (width > widthe) {
			smw = widthe;
		} else {
			smw = width;
		}
		if (height > heighte) {
			smh = heighte;
		} else {
			smh = height;
		}
		// CHECKING NUMBER OF PIXELS SIMILARITY
		for (int a = 0; a < smw; a++) {
			for (int b = 0; b < smh; b++) {
				clre[a][b] = images.getRGB(a, b);
				clr[a][b] = image.getRGB(a, b);
				if (clr[a][b] == clre[a][b]) {
					p = p + 1;
					bw.write("\t");
					bw.write(Integer.toString(a));
					bw.write("\t");
					bw.write(Integer.toString(b));
					bw.write("\n");
				} else
					q = q + 1;
			}
		}

		/*float w, h = 0;
		if (width > widthe) {
			w = width;
		} else {
			w = widthe;
		}
		if (height > heighte) {
			h = height;
		} else {
			h = heighte;
		}*/
		float s = (smw * smh);
		// CALUCLATING PERCENTAGE
		float x = (100 * p) / s;
		
		reportlog.LOG(log.INFO,"THE PERCENTAGE SIMILARITY IS APPROXIMATELY =" + x + "%" , "verify_image");
		long stop = System.currentTimeMillis();
		reportlog.LOG(log.INFO,"TIME TAKEN IS =" + (stop - start) , "verify_image");
		reportlog.LOG(log.INFO,"NO OF PIXEL GETS VARIED:=" + q, "verify_image");
		reportlog.LOG(log.INFO , "NO OF PIXEL GETS MATCHED:=" + p , "verify_image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (q==0)
			return true;
		else
			return false;
	}
}
