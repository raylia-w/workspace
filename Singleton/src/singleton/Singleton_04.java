package singleton;

public class Singleton_04 {
	private static Singleton_04 instance;
	
	//private 생성자
	private Singleton_04() {
		
	}
	
	//인스턴스 반환 메소드
	public static synchronized Singleton_04 getInstance() {
		if(instance == null) {

			try {
				//getInstance를 최초로 호출할 때까지 객체 생성을 미룸
				//두번째 호출부터는 이미 만들어진 객체 반환
					instance = new Singleton_04();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
