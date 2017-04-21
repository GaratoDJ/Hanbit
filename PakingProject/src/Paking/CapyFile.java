package Paking;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CapyFile {
	 //파일을 복사하는 메소드
	 public static void fileCopy(String inFileName, String outFileName) {
	  try {
	   FileInputStream fis = new FileInputStream("Floor_BakUp\\"+inFileName);
	   FileOutputStream fos = new FileOutputStream("Floor\\"+outFileName);
	   
	   int data = 0;
	   while((data=fis.read())!=-1) {
	    fos.write(data);
	   }
	   fis.close();
	   fos.close();
	   
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
}
