package Paking;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

//시스템으로 부터 시간을 받아와 저장하는 인터페이스
public interface time {
	Calendar present = Calendar.getInstance();
	String nowdate = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss").format(Calendar.getInstance(TimeZone.getTimeZone("GMT+09:00")).getTime());
}