package TCPServer;
 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DB.Car;
import DB.DBClass;
/**
* 멀티 채팅을 위한 서버 구성
*/
public class Server {
	/**
   *  필요한 Field 선언  
   */
  ServerSocket server;
  Socket sk;
  ArrayList<ServerThread> list = new ArrayList<ServerThread>();
  /*
   * ServerSocket을 생성하여 client 접속 대할 생성자
   */
  public Server(){ //생성자
      try {
          server = new ServerSocket(7000);
          while(true){
              System.out.println("\nClient접속이 대기중입니다.");
              sk = server.accept(); // 클라이언트 접속 대기중
              System.out.println(sk.getInetAddress()+"의 주소가 연결되었습니다. "); 
              //접속된 클라이언트를 스레드로 만들어 ArrayList에 추가
              ServerThread st = new ServerThread(this);
              addThread(st); //ArrayList 에 추가하기
              System.out.println(st);
              st.start(); //쓰레드 시작하기                    
          } //while문 끝
      } catch (IOException e) {
          System.out.println(e + " -> ServerSocket fil");
      }
  }//생성자 끝
  /**
   * 접속된 클라이언트를 저장하기
   */
  public void addThread(ServerThread st){
          list.add(st);  //추가
  }
  /**
   * 접속이 끊긴 클라이언트를 ArrayList에 제거하기
   **/
  public void removeThread(ServerThread st){
          list.remove(st); //제거
  }
  /**
   * 접속된 각각의 클라이언트에게 데이터 전송하기.
   */
  public void broadCast(String message){
     
      for(ServerThread st : list){
			st.pw.println(message);	
      }              
  }
  public static void main(String[] args) {
      new Server();
     
  }
 
} //클래스 끝
 
//////////////////////////////////////////////////////////////////////
 
//각각의 클라이언트를 Trhrea로 구현
class ServerThread extends Thread{
  Server server;
  PrintWriter pw;
  ObjectInputStream ois;
  
  DBClass db;
  Car car;
  
  ArrayList list;
  int rup = 0;
  
  public ServerThread(Server server){
      this.server = server;
  }
  @Override
  public void run() {
      try {
    	  ois = new ObjectInputStream(server.sk.getInputStream());
    	  pw = new PrintWriter(server.sk.getOutputStream(),true);
    	  String data= null;
	      while((data = String.valueOf(ois.readObject())) != null){
	    	  db = new DBClass();
	    	  car = new Car();
	    	  System.out.println(data);
	    	  if(data.equals("1")){	   
	    		  rup = 1;
	    	  }else if(data.equals("2")){
	    		  rup = 2;
	    	  }else if(data.equals("3")){
	    		  rup = 3;
	    	  }else if(data.equals("4")){
	    		  list = new ArrayList();
	    		  list = db.selectFloorNum(1);
	    		  String re = listReturn(list);
	    		  server.broadCast(re);
	    	  }else if(data.equals("5")){
	    		  list = new ArrayList();
	    		  list = db.selectFloorNum(2);
	    		  String re = listReturn(list);
	    		  server.broadCast(re);
	    	  }else if(data.equals("6")){
	    		  list = new ArrayList();
	    		  list = db.selectFloorNum(3);
	    		  String re = listReturn(list);
	    		  server.broadCast(re);
	    	  }
	    	  if(rup == 1){
	    		  car  = (Car)ois.readObject();
	    		  int re = db.insert(car);
	    		  server.broadCast(String.valueOf(re));
	    		  int re2 = 0;
	    		  re2 = db.selectvipCarNum(car.getCarNum());
	    		  int re3 = 0;
	    		  if(re2 == 1){
	    			  re3 = db.uptateVip(car.getCarNum());
	    		  }else{
	    			  re3 = db.insertVip(car.getCarNum());
	    		  }
	    		  server.broadCast(String.valueOf(re3));
	    	  }else if(rup == 2){
	    		  System.out.println("시작함~");
	    		  car = (Car)ois.readObject();
	    		  Car car2 = new Car();
	    		  car2 = db.selectCarNum(car.getCarNum());
	    		  server.broadCast(car2.getMoney());
	    		  int re = db.delete(car);
	    		  server.broadCast(String.valueOf(re));
	    	  }else if(rup == 3){
	    		  car = (Car)ois.readObject();
	    		  Car car2 = new Car();
	    		  car2 = db.selectCarNum(car.getCarNum());
	    		  server.broadCast(car2.getMoney());
	    		  System.out.println("완료~~");
	    	  }
	    	  rup = 0;
	      }
      } catch (Exception e) {
          //현재 쓰레드를 ArrayList에 제거한다.
          server.removeThread(this);
          System.out.println(e + "----> ");
      }
  }
  public String listReturn(ArrayList list){
	  String re = "";
	  for(int i = 0; i<list.size(); i++){
		  re +=list.get(i);
		  if(i<list.size()-1){
			  re +=",";
		  }
	  }
	  return re;
  }
}