import java.io.*;
public class SmartNoticeBoardUpdation	{
	/*declaring String array of command that is 
	 to be executed by the terminal*/
	final private static String command = "python3 media_downloader.py"; 
	/*Declaring a variable to get Output of the Scripts running*/
	private static String line;
	/*Declaring StringBuilder Object to store all the String of the Output*/
	private static StringBuilder output = new StringBuilder();
	/*Declaring BufferedReader Object to read the InputStreamReader 
	  for the getting the InputStream from the Process running*/
	private static BufferedReader reader;
	/*Declaring variable to store the exitvalue of the 
	  waitFor() that determines the successful execution of the program*/
	private static int exitVal;
	/*Start of Main()*/
	public static void updation() throws IOException	{
	/*try keyword for the execution of the IOexception*/
	try {
		/*Execution of the command using exec() of Runtime class by
		  by creating Runtime Object of the Runtime class using getRuntime()
		  storing it into processBuilder Object*/
		Process process = Runtime.getRuntime().exec(command);
		/*Reading Outputs of the Scripts through InputStreamReader
		  using BufferedReader*/
		reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		/*Creating a while loop for reading lines of the BufferedReader 
		  and appending it to the StringBuilder*/
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			/*Storing the value of the waitFor()*/
			exitVal = process.waitFor();
				assert exitVal == 0 : ("Command Executed Successfully!!! \n\n"+output);
				assert exitVal != 0 : ("Error while Executing command\n\n Python execution");
	}
	catch (IOException e) {
		e.printStackTrace();
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}

