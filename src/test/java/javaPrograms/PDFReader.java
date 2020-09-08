package javaPrograms;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

	/*
	 * PDF box
	 */
	public static void main(String[] args) throws IOException {

		URL url = new URL("file:///C:/Users/deepa/Downloads/form13.pdf");
		InputStream getInputStream = url.openStream();
		BufferedInputStream bufferInputStream = new BufferedInputStream(getInputStream);

		// Code to fetch text from PDF
		PDDocument doc = PDDocument.load(bufferInputStream);
		PDFTextStripper textStrpper = new PDFTextStripper();
		String textInPDF = textStrpper.getText(doc);
		bufferInputStream.close();
		
		// Printing the text in PDF Document
		System.out.println(textInPDF);
	}
}
