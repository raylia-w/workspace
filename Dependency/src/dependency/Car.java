package dependency;

public class Car {
	private Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public String getTire() {
		return tire.getProduct()+"장착";
	}

	public void setTire(Tire bean) {
		
	}
}
