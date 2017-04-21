package Paking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VipCount implements constructor{
	HashMap<Object, Integer> carMap;
	ArrayList<Integer> keySet;
	public void vipCountAdd(int carNum){
		keySet = new ArrayList<Integer>();
		int keyNum = 0;
		carMap = new HashMap<Object, Integer>();
		carMap = (HashMap)vip.parkingCount.get(0);
		Iterator<Object> iterator = carMap.keySet().iterator();
		while(iterator.hasNext()){
			int key = (int)iterator.next();
			keySet.add(key);
			System.out.println(key);
		}
		for(int i = 0; i<keySet.size(); i++){
			if(keySet.get(i) == carNum){
				keyNum = keySet.get(i);
				carMap.put(keyNum, carMap.get(keyNum)+1);
			}
			keyNum = 0;
		}
		if(keyNum == 0){
			carMap.put(carNum, 1);
		}
		vip.parkingCount.set(0, carMap);
		fileMody.fileModyfy(4);
	}
}
