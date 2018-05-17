package di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import di.tire.Tire;

public class Car {
	@Autowired 
	@Qualifier("gTire")
	private Tire tire;

	public String getInfo() {
		return tire.getProduct() + " 장착함!!";
	}
}













