package Paking;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileModify implements constructor{
	public void fileModyfy(int num){
	File file = new File("Floor");
	if(file.exists() == false){
		file.mkdirs();
	}
	try{
		String floorName = null;
		switch(num){
		case 1 : 
			floorName = "oneFloor";
			break;
		case 2 : 
			floorName = "twoFloor";
			break;
		case 3 : 
			floorName = "threeFloor";
			break;
		case 4 ://이부분은 vip 카운트 저장하는 곳 
			floorName = "vipList";
			break;
		}
		FileOutputStream fout = new FileOutputStream("Floor\\"+floorName+".txt");
		ObjectOutputStream oo = new ObjectOutputStream(fout);
		switch(num){
		case 1 : 
			oo.writeObject(floor.oneFloor);
			break;
		case 2 : 
			oo.writeObject(floor.twoFloor);
			break;
		case 3 : 
			oo.writeObject(floor.threeFloor);
			break;
		case 4 ://이부분은 vip 카운트 저장하는 곳 
			oo.writeObject(vip.parkingCount);
			break;
		}
		oo.close();
		fout.close();
	}catch(IOException e){
		System.out.println(e);
	}
}
}
