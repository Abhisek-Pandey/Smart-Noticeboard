import java.io.*;
import java.net.InetAddress;
import java.util.Date;

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
	public static void main(String[] args) throws Exception	{
		System.out.println("Main -  time  "+currentTime);
		SmartNoticeBoardUpdation.updation();
		FileArrangement.arrange();
		System.out.println("Updated and Arrange");
		while(true)	{
			System.out.println("Check  "+time());
			if((currentTime+8_64_00_000l) <= time())	{
				SmartNoticeBoardUpdation.updation();
				FileArrangement.arrange();
				currentTime = time();
				System.out.println("Updated and Arrange");
			}
			//NoticeDisplaying.Display();
			System.out.println("Displaying");
			Thread.sleep(25000);
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
}
	
	