package singleton;

public class Singleton_03 {
	private static Singleton_03 instance;
	
	//private 생성자
	private Singleton_03() {
		
	}
	
	//static 초기화 블록
	//최초 1회만 수행되는 코드
	static {
		if(instance == null) {

			try {
				//getInstance를 최초로 호출할 때까지 객체 생성을 미룸
				//두번째 호출부터는 이미 만들어진 객체 반환
					instance = new Singleton_03();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//인스턴스 반환 메소드
	public static Singleton_03 getInstance() {
		return instance;
	}
}
