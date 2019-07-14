package javaPrograms;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages {

	public static void main(String[] args) throws TesseractException {
		
		ITesseract image = new Tesseract();
		// JPG image reading
		String strJPG = image
				.doOCR(new File("C:\\Users\\deepa\\Downloads\\Brian-Tracy-Leadership-is-The-e1523982582769.jpg"));
		System.out.println("Data from JPG Image is--> " + "\n" + strJPG);
		
		// PNG image Reading
		String strPNG = image
				.doOCR(new File("C:\\Users\\deepa\\workspace\\JavaAndSeleniumConcepts\\Captcha.png"));
		System.out.println("Data from PNG Image is--> " + "\n" + strPNG);	
	}
}