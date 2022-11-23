import java.io.*;
public class SmartNoticeBoard	{
	//Declaring a File object to store the Notices in one folder
	static final File Notices = new File("/home/AbhisekPandey/Project/Notices");
	//Getting the list of all the Media file present in Notices folder and storring them ib ab Array
	static File[] NoticesContent = null;
	public static void main(String[] args) throws Exception	{
			while(true)	{
				System.out.println("Updation and Arrangement");
				SmartNoticeBoardUpdation.Updation();
				System.out.println("Updated");
				FileArrangement.Arrange();
				System.out.println("Arranged");
				Thread.sleep(5000);
				int i = 1;
				while(true)	{
					System.out.println("Displaying");
					NoticeDisplaying.Display();
					if (i == 3 )break;
					i++;
					}
				}
			}
		}
