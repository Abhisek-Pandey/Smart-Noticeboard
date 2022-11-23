import java.io.IOException;
import java.nio.file.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

public class FileArrangement{
	//Declaring String Object of all the media files location
	static private final String docPath = "./document/";
	static private final String photoPath = "./photo/";
	static private final String videoPath = "./video/";
	/* Declaring all File Object required to get the respect media files using listFiles()
	   to get an Array of all the media file present*/
	static private File documentFiles = new File(docPath);	 	
	static private File photoFiles = new File(photoPath);		
	static private File videoFiles = new File(videoPath);
	/*Declaring Object required to convert the pdf to image*/
	static private PDDocument document;
	static private PDFRenderer pdfRenderer;
	static private String fileName;
	static private final int DPI = 300;
	public static void main(String[] args)	{
		/*Getting list of all files*/
		File[] documentContent = documentFiles.listFiles();	
		File[] photoContent = photoFiles.listFiles();
		File[] videoContent = videoFiles.listFiles();
		try{
			SmartNoticeBoard.NoticesContent = SmartNoticeBoard.Notices.listFiles();
			/*Checking if the file are present or not and delete all the file present in the 
			 * Notice folder */
			if(SmartNoticeBoard.NoticesContent != null)	{
				for(File D : SmartNoticeBoard.NoticesContent)	{
					 if(D.isDirectory())	{
						 File[] Temp = D.listFiles();
						 for(File temp : Temp) Files.delete(Paths.get(temp.toString()));
						 }
					 Files.delete(Paths.get(D.toString()));
					 
				}
				SmartNoticeBoard.Notices.delete();
				Files.createDirectory(Paths.get(SmartNoticeBoard.Notices.toString()));
			}
			else 
				Files.createDirectory(Paths.get(SmartNoticeBoard.Notices.toString()));
			/*Arranging all files ina single folder known as Notices*/
			if(documentContent != null)
			for(File N : documentContent)	{
				if(N.getName().endsWith(".pdf"))	{
				PDDocument document = PDDocument.load(N);
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                fileName = N.getName().replace(".pdf","");
                int NoOfPages = document.getNumberOfPages();
                File Destination = new File("./Notices/"+fileName+"/");
                if(!Destination.exists())	{
					Destination.mkdir();
					}
                for(int i = 0;i < NoOfPages; i++)	{
					File outputFile = new File(Destination.toString()+"/"+fileName+"_"+(i+1)+"."+"png");
					BufferedImage bImage = pdfRenderer.renderImageWithDPI(i, DPI, ImageType.RGB);
					ImageIO.write(bImage, "png", outputFile);
					}
				document.close();
				}
			}
			if(photoContent != null)
			for(File N : photoContent)	{
				fileName = N.toString().substring(photoPath.length());
				Files.move(Paths.get(N.toString()),Paths.get("./Notices/"+fileName));
			}
			if(videoContent != null)
			for(File N : videoContent)	{
				fileName = N.toString().substring(videoPath.length());
				Files.move(Paths.get(N.toString()),Paths.get("./Notices/"+fileName));
			}
		}
		catch(IOException IO)	{System.out.println(IO);}
}
}
