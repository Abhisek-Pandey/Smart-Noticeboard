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
	static String TIME_SERVER = "time-a.nist.gov";
	static NTPUDPClient timeClient = new NTPUDPClient();
           
	public static void main(String[] args) throws Exception	{
		
	}
	public static long time() throws Exception	{
		InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
    	TimeInfo timeInfo = timeClient.getTime(inetAddress);
    	long returnTime = timeInfo.getReturnTime();
        Date time = new Date(returnTime);
		return time.getTime();
	}
}