package com.ssafy.ws.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before(value = "execution(* com.ssafy.ws.model..*.*(..))")
	public void logging(JoinPoint joinPoint) {
		System.out.println("메서드선언부 : " + joinPoint.getSignature()); 
		System.out.println("전달인자 : " + joinPoint.getArgs());
	}
	
}
