package Paking;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SteatSetting implements time, constructor{
	HashMap<Object, ArrayList> hsOne, hsTwo, hsThree, hsKey,test;
	HashMap<Object, Integer> hsVip, testHash;
	public ArrayList<Object> oneKey = new ArrayList<Object>();
	public ArrayList<Object> twoKey = new ArrayList<Object>();
	public ArrayList<Object> TreeKey = new ArrayList<Object>();
	ArrayList<Object> testList = new ArrayList<Object>();
	public void setFloor(String name, int floorNum){
		try{
			File file = new File("Floor");
			if(file.exists() == false){
				file.mkdirs();
			}
			FileInputStream fls = new FileInputStream("Floor\\"+name+".txt");
			ObjectInputStream ois = new ObjectInputStream(fls);
			ArrayList readList = (ArrayList) ois.readObject();		
			switch(floorNum){
				case 1 :
					floor.oneFloor=readList;
				case 2 : 
					floor.twoFloor = readList;
				case 3 : 
					floor.threeFloor = readList;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}	
	}
	public void setvip(){
		try{
			FileInputStream fls = new FileInputStream("Floor\\vipList.txt");
			ObjectInputStream ois = new ObjectInputStream(fls);
			ArrayList readList = (ArrayList) ois.readObject();
			vip.parkingCount = readList;
		}catch(Exception e){
			System.out.println(e);
		}
	}

//	public void getKey(){
//		test = new HashMap<Object, ArrayList>();
//		test = (HashMap)floor.oneFloor.get(0);
//		System.out.println(test.get(8).get(2));
//	}
}
