package ro.emanuel.POJO;

public class Truck {
private int truckid;
private String brand;
private int capacity;
private int accidents;
public Truck(int truckid, String brand, int capacity, int accidents) {
	
	this.truckid = truckid;
	this.brand = brand;
	this.capacity = capacity;
	this.accidents = accidents;
}
public Truck () {}
public int getTruckid() {
	return truckid;
}
public void setTruckid(int truckid) {
	this.truckid = truckid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public int getAccidents() {
	return accidents;
}
public void setAccidents(int accidents) {
	this.accidents = accidents;
}

}
