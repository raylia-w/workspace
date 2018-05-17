package dependency;

public class Person {
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xml/di.xml");
		
		Car car = (Car) context.getBean("car");
		car.setTire((Tire) context.getBean("gTire"));
		
		System.out.println(car.getInfo());
	}
}
