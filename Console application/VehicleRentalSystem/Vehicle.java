public class Vehicle {
	String id;
	String name;
	String type;
	int count;
	double rentPrice;
	double deposit;
	double km;
	boolean isRented;
	boolean serviced;
	
	public Vehicle(String id,String name,String type,int count,double rentPrice,double deposit,double km) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.count=count;
		this.rentPrice=rentPrice;
		this.deposit=deposit;
		this.km=km;
		this.serviced=(type.equalsIgnoreCase("car") && km<=3000) || (type.equalsIgnoreCase("bike") && km<=1500);
	}
}