package DI2_setter;

public class Person {
	public static void main(String[] args) {
		Car car = new Car();
		
		car.setTire(new GoldTire());
		
		System.out.println(car.getTire());
	}
}
