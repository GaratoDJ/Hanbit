package Paking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class EmptySpace implements constructor{
	HashMap<Object, ArrayList> hsOne, hsTwo, hsTree, hsKey;
	public ArrayList oneKey = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
	public ArrayList twoKey = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
	public ArrayList threeKey = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
	ArrayList keySet;
	
	//빈자리 가져오는곳
		public void getOneKeyNum(){
			hsKey = new HashMap<Object, ArrayList>();
			keySet = new ArrayList();
			hsKey = (HashMap)floor.oneFloor.get(0);
			Iterator<Object> iterator  = hsKey.keySet().iterator();
			while(iterator.hasNext()){	
				int key = (int)iterator.next();
				keySet.add(key);		
			}		
			for(int j = 0; j<keySet.size(); j++){
				for(int k = 0; k<oneKey.size(); k++){
					if(keySet.get(j) == oneKey.get(k)){
						oneKey.remove(k);
					}
				}
			}
		}
		public void getTwoKeyNum(){
			hsKey = new HashMap<Object, ArrayList>();
			keySet = new ArrayList();
			hsKey = (HashMap)floor.twoFloor.get(0);
			Iterator<Object> iterator  = hsKey.keySet().iterator();
			
			while(iterator.hasNext()){	
				int key = (int)iterator.next();
				keySet.add(key);
			}
			for(int j = 0; j<keySet.size(); j++){
				for(int k = 0; k<twoKey.size(); k++){
					if(keySet.get(j) == twoKey.get(k)){
						twoKey.remove(k);
					}
				}
			}
		}
		public void getTreeKeyNum(){
			hsKey = new HashMap<Object, ArrayList>();
			keySet = new ArrayList();
			hsKey = (HashMap)floor.threeFloor.get(0);
			Iterator<Object> iterator  = hsKey.keySet().iterator();
			
			while(iterator.hasNext()){	
				int key = (int)iterator.next();
				keySet.add(key);
			}
			for(int j = 0; j<keySet.size(); j++){
				for(int k = 0; k<threeKey.size(); k++){
					if(keySet.get(j) == threeKey.get(k)){
						threeKey.remove(k);
					}
				}
			}
		}
		protected void setupVacancy(){
			int level;
			boolean a;
			int size = 0;
			emptySpace.getOneKeyNum();
			emptySpace.getTwoKeyNum();
			emptySpace.getTreeKeyNum();
			for(int i = 1; i<=3; i++){
				switch(i){
					case 1: 
						size = emptySpace.oneKey.size();
						break;
					case 2: 
						size = emptySpace.twoKey.size();
						break;
					case 3:
						size = emptySpace.threeKey.size();
						break;
				}
				if(size >=15){
					a = true;
					level = i;
					print.setupVacancyPrint(level, a);
				}else{
					a = false;
					level = i;
					print.setupVacancyPrint(level, a);
				}
			}
		}
}
