package Paking;
import java.util.HashMap;
public class implementMain implements constructor, time{
	HashMap<Object, Integer> hsVip, testHash;
	static boolean end = false;
	String name;
	int carNum;
	int hour;
	public void ret(){
		print.printMenu("reboot"); 
	    switch(scnner.nextInt()){
	    	case 1 : 
	    		break;
	    	case 2 : print.printMenu("end");
	    	end = true;
	       		break;
	    }
	}
	public void setUp(){
		st.setFloor("oneFloor", 1);
		st.setFloor("twoFloor", 2);
		st.setFloor("threeFloor", 3);
		st.setvip();
	}
	public void Start(){
		while(end == false){
			int inputNum = 0;
			print.printMenu("start");
			inputNum = scnner.nextInt();
			switch(inputNum){
				case 1:		
					paking.setList();
					break;
				case 2:
					dOut.OutCar(2);
					ret();
					break;
				case 3 :
					dOut.OutCar(3);
					ret();
					break;
				case 4 : 
					end = true;
					print.printMenu("end");
					break;
				case 5 :
					CapyFile capy = new CapyFile();
					capy.fileCopy("oneFloor.txt", "oneFloor.txt");
					capy.fileCopy("twoFloor.txt", "twoFloor.txt");
					capy.fileCopy("threeFloor.txt", "threeFloor.txt");
					capy.fileCopy("vipList.txt", "vipList.txt");
					break;		
			}
			if(inputNum>5 ||inputNum<1){
				System.out.println("1~4 사이의 값을 입력해 주세요");
			}
		}
	}
}
