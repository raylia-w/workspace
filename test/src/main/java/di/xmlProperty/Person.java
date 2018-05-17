package di.xmlProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xmlProperty/di.xml");
		
		Car car = (Car) context.getBean("sCar");
		
		Car car2 = (Car) context.getBean("gCar");
		
		System.out.println(car.getInfo());
		
		System.out.println(car2.getInfo());
	
	}
}
