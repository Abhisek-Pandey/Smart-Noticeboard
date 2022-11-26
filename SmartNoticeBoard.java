import java.io.*;
import java.net.InetAddress;
import org.apache.commons.net.ntp.NTPUDPClient; 
import org.apache.commons.net.ntp.TimeInfo;

public class SmartNoticeBoard	{
	//Declaring a File object to store the Notices in one folder
	static final File Notices = new File("./Notices");
	//Getting the list of all the Media file present in Notices folder and storring them ib ab Array
	static File[] NoticesContent = null;   
    static NTPUDPClient timeClient;
	static InetAddress inetAddress;
	static TimeInfo timeInfo;
	static long currentTime = time();
	static Logo logo = new Logo();
	public static void main(String[] args) throws Exception	{
		logo.start();
		SmartNoticeBoardUpdation.updation();
		FileArrangement.arrange();
		while(true)	{
			if((currentTime+/*8_64_00_000l*/300000) <= time())	{
				SmartNoticeBoardUpdation.updation();
				FileArrangement.arrange();
				currentTime = time();
			}
			NoticeDisplaying.Display();
		}
	}
	public static long time()	{
		try {
			timeClient = new NTPUDPClient();
			inetAddress = InetAddress.getByName("time-a.nist.gov");
			timeInfo = timeClient.getTime(inetAddress);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return timeInfo.getReturnTime();
	} 
	static class Logo extends Thread{
		String command;
		Process process;
		public void run()	{
			command = "python3 Logo.py";
			try {
				process = Runtime.getRuntime().exec(command);
			} catch (IOException e) {	e.printStackTrace();}
		}
	}
}
	
	