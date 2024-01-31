package ro.emanuel.POJO;

public class Shipment {
	private int shipmentid;
	private int distance;
	private int weight;
	private String destination;
	public Shipment(int shipmentid, int distance, int weight, String destination) {
		
		this.shipmentid = shipmentid;
		this.distance = distance;
		this.weight = weight;
		this.destination = destination;
	}
	public Shipment() {}
	public int getShipmentid() {
		return shipmentid;
	}
	public void setShipmentid(int shipmentid) {
		this.shipmentid = shipmentid;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
