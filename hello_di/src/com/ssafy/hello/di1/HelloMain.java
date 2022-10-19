package com.ssafy.hello.di1;

public class HelloMain {

	public static void main(String[] args) {
		// 객체가 바뀌면 모든게 바뀌어야 함
		// -> 결합성이 강함(tight coupling)
//		HelloMessageKor kor = new HelloMessageKor();
//		System.out.println(kor.helloKor("조서영"));
		HelloMessageEng eng = new HelloMessageEng();
		System.out.println(eng.helloEng("조서영"));
	}
	
}
