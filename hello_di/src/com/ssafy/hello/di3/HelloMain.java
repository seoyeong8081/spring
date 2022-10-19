package com.ssafy.hello.di3;

public class HelloMain {

	public static void main(String[] args) {
		// main 안에서 객체를 만드는 것이 문제
		// 여기서 안 만들면 됨
		HelloMessage helloMessage = HelloMessageFactory.getHelloMessage("kor");
		System.out.println(helloMessage.hello("조서영"));
	}
	
}
