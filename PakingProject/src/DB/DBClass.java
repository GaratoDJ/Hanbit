package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import Paking.ChargeTime;

public class DBClass {
	private Connection con;
	private PreparedStatement ps;
	private Statement stmt = null;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	private final static String url = "jdbc:mysql://localhost/carproject2?useSSL=false";
	String pass = "1111";
	String id = "root";
	public int insert(Car c){
		System.out.println("일단 들어옴");
		int re = 0;
		String sql = "insert into basicinfo values(?,?,now(), ?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getCarNum());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getFloor());
			ps.setInt(4, c.getFloorNum());
			ps.executeUpdate();
			re = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			re = 2;
		}
		return re;
	}
	public int selectvipCarNum(int carNum){
		int re = 0;
		System.out.println("vip들어옴~");
		String sql = "select vipCarNum from vip where vipCarNum = "+carNum;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				re = 1;
			}else{
				re = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	public int insertVip(int carNum){
		int re = 0;
		String sql = "insert into vip values("+carNum+", 1)";
		try {
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
		re = 5;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	public int uptateVip(int carNum){
		int re = 0;
		String sql = "update vip set vipCount = vipCount+1 where vipCarNUm ="+carNum;
		try{
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
		re = 6;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	public int delete(Car c){
		int re = 0;
		String sql = "delete from basicinfo where carNum = ? and name = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getCarNum());
			ps.setString(2, c.getName());
			ps.executeUpdate();
			re = 3;
		} catch (SQLException e) {
			e.printStackTrace();
			re = 4;
		}
		return re;
	}
	public Car selectCarNum(int carNum){
		ChargeTime time = new ChargeTime();
		Car c = null;
		String sql="select * from Basicinfo where carNum =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, carNum);
			rs = ps.executeQuery();
			
			while(rs.next()){
				c = new Car();
				c.setCarNum(rs.getInt(1));
				c.setDate(rs.getString(3));
				c.setName(rs.getString("name"));
				c.setMoney(time.printTime(c.getDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public ArrayList selectFloorNum(int floor){
		System.out.println("자리비움~~~~~~~~~~~~");
		ArrayList carNum = new ArrayList();
		ArrayList list = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		String sql = "select floorNum from Basicinfo where floor = ?";
		try {
			System.out.println(floor);
			ps = con.prepareStatement(sql);
			ps.setInt(1, floor);
			rs = ps.executeQuery();
			while(rs.next()){
				carNum.add(rs.getInt(1));
			}
			for(int j = 0; j<carNum.size(); j++){
				for(int k = 0; k<list.size(); k++){
					if(carNum.get(j) == list.get(k)){
						list.remove(k);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Car> selectAll(){
		Car car = null;
		ArrayList<Car> list = new ArrayList<Car>();
		String sql="select * from insertstudenttest";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			while(rs.next()){
				//파일부분
//				car = new Car();
//				car.s
//				car.setName(rs.getString("name"));
//				car.setGreade(rs.getInt("greade"));
//				list.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public DBClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
