package singleton;

public class Singleton_02 {
	private static Singleton_02 instance;
	
	//private 생성자
	private Singleton_02() {
		
	}
	
	//static 초기화 블록
	//최초 1회만 수행되는 코드
	static {
		try {
			instance = new Singleton_02();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//인스턴스 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}
}
