package singletonEx;

import singleton.Singleton_01;
import singleton.Singleton_02;

public class singletonEx {
	public static void main(String[] args) {
		
		Singleton_01 s1 = Singleton_01.getInstance();
		Singleton_01 s2 = Singleton_01.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
//		Singleton_01 s3 = new Singleton_01();
		
//		System.out.println(s3);
		
		Singleton_02 s3 = Singleton_02.getInstance();
		Singleton_02 s4 = Singleton_02.getInstance();
		
		System.out.println(s3);
		System.out.println(s4);

	}
}
