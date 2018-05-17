package singleton;

//단점
//1. 인스턴스를 사용하지 않더라도 생성한다.
//2. 인스턴스화하면서 발생하는 예외를 처리하지 못한다(추가작업을 할 수 없다)
public class Singleton_01 {
	
	private Singleton_01() {
	}
	
	private static Singleton_01 instance = new Singleton_01();
	
	public static Singleton_01 getInstance() {
		return instance;
	}
}
