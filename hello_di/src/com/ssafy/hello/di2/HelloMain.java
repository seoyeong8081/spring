package com.ssafy.hello.di2;

public class HelloMain {

	public static void main(String[] args) {
		// 인터페이스를 사용하여 loosing coupling
		// 객체를 만드는 공장을 따로 클래스로 만들어서 걔를 사용하면 더 loose해짐
		// -> factory를 스프링(factory+singleton)이 대신해줌
		HelloMessage helloMessage = new HelloMessageKor();
		System.out.println(helloMessage.hello("조서영"));
	}
	
}
