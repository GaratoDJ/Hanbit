package Paking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DriveOut implements constructor{
	HashMap<Object, ArrayList> floorSet;
	ArrayList keySet;
	public void OutCar(int n){
		int floorNum = 0; 
		int carNum, carBox;
		boolean roop = true;
		System.out.println("주차하신 차량의 층수를 입력하세요");
		while(roop){
			floorNum = scnner.nextInt();
			if(floorNum >3 || floorNum<1){
				System.out.println("해당층은 존재하지 않습니다 1~3층 사이의 층을 입력해 주세요");
			}else{
				roop = false;	
			}
		}
		System.out.println("주차하신 차량의 번호를 입력하세요");
		carNum = scnner.nextInt();
		System.out.println("주차하신 박스 번호를 입력하세요");
		carBox = scnner.nextInt();
		
		floorSet = new HashMap<Object, ArrayList>();
		keySet = new ArrayList();
		switch(floorNum){
		case 1 : 
			floorSet = (HashMap)floor.oneFloor.get(0);
//			System.out.println(floorSet.toString());
			break;
		case 2: 
			floorSet = (HashMap)floor.twoFloor.get(0);
//			System.out.println(floorSet.toString());
			break;
		case 3: 
			floorSet = (HashMap)floor.threeFloor.get(0);
//			System.out.println(floorSet.toString());
			break;
		}
		Iterator<Object> iterator  = floorSet.keySet().iterator();
		while(iterator.hasNext()){
			int key = (int)iterator.next();
			keySet.add(key);
		}
		
//		charge.printTime(floorNum, carBox);
		
		if(n == 2){
			for(int i = 0; i<keySet.size(); i++){	
				if((int)floorSet.get(keySet.get(i)).get(0) == carNum){
					floorSet.remove(keySet.get(i));
					fileMody.fileModyfy(floorNum);
					break;
				}
			}
		}
		switch(floorNum){
		case 1: 
			floor.oneFloor.set(0, floorSet);
			break;
		case 2:
			floor.twoFloor.set(0, floorSet);
			break;
		case 3:
			floor.threeFloor.set(0, floorSet);
			break;
		}
	}
}
