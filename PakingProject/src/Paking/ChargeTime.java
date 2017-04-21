package Paking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import DB.DBClass;

public class ChargeTime extends DBClass implements constructor{
    public String printTime(String date) {
//    	System.out.println(date);
        String re = "";
		try{
  	  //시간 설정
       String start = date;//유저로부터 해당 번호를 입력받음 (차량번호나 키값)
       Calendar tempcal=Calendar.getInstance();
       SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       Date startday= sf.parse(start);
       long startTime=startday.getTime();
       //현재의 시간 설정
       Calendar cal=Calendar.getInstance();
       Date endDate=cal.getTime();
       long endTime=endDate.getTime();
       long mills=endTime-startTime;

     //분으로 변환
       long min=mills/60000;
       long price = 0;
       if(min<=60){
    	   price = 5000;
       }
       else if(60<min && min<=1440){
    	   price = (5000) + (int)(min/60)*2000;
       }
       else if(1440<min){
    	   price = 28000 + ((int)(min/60)-24)*4000;
       }
       
       StringBuffer diffTime=new StringBuffer();
       diffTime.append("이용시간은 ").append( ((int)min/60) + 1).append("시간 입니다.").append("이용 요금은 " + price + "원 입니다.");
       re = diffTime.toString();
        }catch(NullPointerException e){
        	re = "해당 차량은 존재하지 않습니다.";
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return re;
    }
	//파일 부분
//	public Object getkey(int k, int l){ //수정
//		HashMap<Object, ArrayList> test = new HashMap<Object, ArrayList>();
//		String parkingDay = null;
//		try{
//			if(k==1){
//				test = (HashMap)floor.oneFloor.get(0);
//			}
//			else if(k==2){
//				test = (HashMap)floor.twoFloor.get(0);
//			}
//			else if(k==3){
//				test = (HashMap)floor.threeFloor.get(0);
//			}
//			
//			parkingDay = (String)test.get(l).get(2);
//		}catch(NullPointerException e){
//			System.out.println("존재하지 않는 차량 번호 입니다.");
//		}
//		System.out.println("주차 하신 날짜 : " + parkingDay);
//		return parkingDay;
//	}
}
