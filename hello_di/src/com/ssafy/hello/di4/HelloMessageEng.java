package com.ssafy.hello.di4;

public class HelloMessageEng implements HelloMessage{
	
	public HelloMessageEng() {
		System.out.println("HelloMessageEng 객체 만들어요!!");
//		init(); // 생성되기 전에 초기화
	}
	
	public void init() {
		System.out.println("Eng 객체를 초기화!!!");
	}
	
	public String hello(String name) {
		return "hello " + name;
	}
}
