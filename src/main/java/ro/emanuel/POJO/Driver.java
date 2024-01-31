package ro.emanuel.POJO;

public class Driver {
	private int driverid;
	private String name;
	private int age;
	private int hours;
	public Driver(int driverid, String name, int age, int hours) {
		this.driverid = driverid;
		this.name = name;
		this.age = age;
		this.hours = hours;
	}
	public Driver() {
		this.driverid = driverid;
		this.name = name;
		this.age = age;
		this.hours = hours;
	}
	
	
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
}
