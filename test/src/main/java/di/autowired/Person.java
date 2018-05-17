package di.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/autowired/di.xml");
		
		Car car = (Car) context.getBean("car");

		System.out.println("car info : " + car.getInfo());
	}
}
