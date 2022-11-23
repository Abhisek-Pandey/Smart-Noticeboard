import java.io.*;
public class NoticeDisplaying	{
	static private String command;
	private static String line;
	private static StringBuilder output = new StringBuilder();
	private static BufferedReader reader;
	private static int exitVal;
	private static Process process;
	public static void Display()	{
		try {
			/*Displaying Photo files*/
				command = "python3 PhotoDis.py";
				process = Runtime.getRuntime().exec(command);
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = reader.readLine()) != null) {
					output.append(line + "\n");
				}
				/*Storing the value of the waitFor()*/
				exitVal = process.waitFor();
				assert exitVal == 0  : ("Command Executed Successfully!!! Photos are being Displayed \n\n"+output);
				assert exitVal != 0 : ("Error while Executing command  \n Photos are not being Displayed");	
			/*Displaying Document files*/
				command = "python3 DocDis.py";
				process = Runtime.getRuntime().exec(command);
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = reader.readLine()) != null) {
					output.append(line + "\n");
				}
				/*Storing the value of the waitFor()*/
				exitVal = process.waitFor();
				assert exitVal == 0  : ("Command Executed Successfully!!! Document are being Displayed\n\n"+output);
				assert exitVal != 0 : ("Error while Executing command  \n Document are not being Displayed");	
			/*Displaying video files*/
				command = "python3 VideoDis.py";
				process = Runtime.getRuntime().exec(command);
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = reader.readLine()) != null) {
					output.append(line + "\n");
				}
				/*Storing the value of the waitFor()*/
				exitVal = process.waitFor();
				assert exitVal == 0 : ("Command Executed Successfully!!! Video are being Displayed \n\n"+output);
				assert exitVal != 0 : ("Error while Executing command \n Video are not being Displayed");
	}
	catch (IOException e) {
		e.printStackTrace();
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
}
 }

