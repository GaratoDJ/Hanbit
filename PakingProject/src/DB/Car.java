package DB;

import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable{
	private int carNum;
	private String name;
	private String date;
	private int floor;
	private int floorNum;
	private int vipCount;
	private String money;
	public ArrayList carNumList;

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}
	public int getVipCount() {
		return vipCount;
	}
	public void setVipCount(int vipCount) {
		this.vipCount = vipCount;
	}
}
