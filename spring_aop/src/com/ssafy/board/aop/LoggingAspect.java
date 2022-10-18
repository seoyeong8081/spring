package com.ssafy.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
	
	// 실행되기 전과 후에 -> 감싼 것처럼
	@Around(value = "execution(* com.ssafy.board..*Dao.list*(..))")
	public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("executeTime : " + joinPoint.getSignature()); // method의 간단정보
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceed = joinPoint.proceed();
		
		stopWatch.stop();
		System.out.println("summary : " + stopWatch.shortSummary());
		System.out.println("totalTime : " + stopWatch.getTotalTimeMillis());
		System.out.println("pretty : " + stopWatch.prettyPrint());
		
		return proceed;
	}
	
	// 실행되기 전에 ex) 보안처리(보안프로그램 안 깔려있으면 깔아라)
	@Before(value = "execution(* com.ssafy.board..*Dao.write*(..))")
	public void logging(JoinPoint joinPoint) {
		System.out.println("before logging : " + joinPoint.getSignature()); 
		System.out.println("전달인자 : " + joinPoint.getArgs());
	}
	
	// 정상적으로 실행됐을 때
	@AfterReturning(value = "execution(* com.ssafy.board..*Dao.write*(..))", returning = "obj")
	public void afterReturningMethod(JoinPoint joinPoint, Object obj) {
		System.out.println("afterReturningMethod : " + joinPoint.getSignature()); 
		System.out.println("리턴값 : " + obj);
	}
	
	// 예외가 발생했을 때
	@AfterThrowing(value = "execution(* com.ssafy.board..*Dao.write*(..))", throwing = "exception")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {
		System.out.println("afterThrowingMethod : " + joinPoint.getSignature()); 
		System.out.println("Exception : " + exception);
	}
	
	// 예외처리의 finally에 해당함 afterReturning 이후에 실행됨. 예외가 나든 안나든 무조건 실행됨.
	@After(value = "execution(* com.ssafy.board..*Dao.write*(..))")
	public void afterThrowingMethod(JoinPoint joinPoint) {
		System.out.println("afterMethod >> 무조건 실행!!! : " + joinPoint.getSignature()); 
	}
	
}
