package singleton;

public class Singleton_05 {
	private static class Singleton{
		private static final Singleton_05 instance = new Singleton_05();
	}
	
	//private 생성자
	private Singleton_05() {
		
	}
	
	//인스턴스 반환 메소드
	public static Singleton_05 getInstance() {
		return Singleton.instance;
	}
}
