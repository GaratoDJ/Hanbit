package Paking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PakingClass implements constructor{
	HashMap<Object, ArrayList> hsOne, hsTwo, hsTree, hsKey;
	HashMap<Object, ArrayList>test;
	public void setList(){
		int floorKey = 0;
		int num = 0;
		int carNum;
		String name;
		String nowdate= time.nowdate;	
		
		boolean f = true;
		while(f){
			System.out.println("주차하실 층수를 입력해주세요 ex)1~3");
			floorKey = scnner.nextInt();
			if(floorKey==1){
				emptySpace.getOneKeyNum();
				print.Vacancy(floorKey);
				break;
			}
			else if(floorKey==2){
				emptySpace.getTwoKeyNum();
				print.Vacancy(floorKey);
				break;
			}
			else if(floorKey==3){
				emptySpace.getTreeKeyNum();
				print.Vacancy(floorKey);
				break;
			}
			else{
				System.out.println("층수 입력이 잘못되었습니다.");
			}
		}	
		while(f){	
			System.out.println("주차하실 자리의 번호를 입력하세요 ex)1~15");
			num = scnner.nextInt();
			
			if(floorKey==1){
				for(int i=0; i<emptySpace.oneKey.size(); i++){
					if(num <= 0 || num > 15){
						System.out.println("주차공간은 1~15자리까지입니다");
						break;
					}
					
					else if(num == (int)emptySpace.oneKey.get(i)){
						System.out.println("입력하신 자리는 "+num+"입니다");
						f = false;
						break;
					}
				}
			}
			else if(floorKey==2){
				for(int i=0; i<emptySpace.twoKey.size(); i++){
					if(num <= 0 || num > 15){
						System.out.println("주차공간은 1~15자리까지입니다");
						break;
					}
					
					else if(num == (int)emptySpace.twoKey.get(i)){
						System.out.println("입력하신 자리는 "+num+"입니다");
						f = false;
						break;
					}
				}
			}
			else{
				for(int i=0; i<emptySpace.threeKey.size(); i++){
					if(num <= 0 || num > 15){
						System.out.println("주차공간은 1~15자리까지입니다");
						break;
					}
					
					else if(num == (int)emptySpace.threeKey.get(i)){
						System.out.println("입력하신 자리는 "+num+"입니다");
						f = false;
						break;
					}
				}
			}
		}
		
		System.out.println("차량번호를 입력하세요");
		carNum = scnner.nextInt();
		System.out.println("성함을 입력해주새요");
		name = scnner.next();
		
		switch(floorKey){
			case 1 :
				hsOne = new HashMap<Object, ArrayList>();
				hsOne = (HashMap)floor.oneFloor.get(0);
				hsOne.put(num, new ArrayList(Arrays.asList(carNum, name, nowdate)));
				floor.oneFloor.set(0, hsOne);
				fileMody.fileModyfy(floorKey);
//				test = new HashMap<Object, ArrayList>();
//				test = (HashMap)floor.oneFloor.get(0);
//				System.out.println(test);
			case 2 : 
				hsTwo = new HashMap<Object, ArrayList>();
				hsTwo = (HashMap)floor.twoFloor.get(0);
				hsTwo.put(num, new ArrayList(Arrays.asList(carNum, name, nowdate)));
				floor.twoFloor.set(0, hsTwo);
				fileMody.fileModyfy(floorKey);

			case 3 : 
				hsTree = new HashMap<Object, ArrayList>();
				hsTree = (HashMap)floor.threeFloor.get(0);
				hsTree.put(num, new ArrayList(Arrays.asList(carNum, name, nowdate)));
				floor.threeFloor.set(0, hsTree);
				fileMody.fileModyfy(floorKey);
		}
		vipCount.vipCountAdd(carNum);
	}
}

