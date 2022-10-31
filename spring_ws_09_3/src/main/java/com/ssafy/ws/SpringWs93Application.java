package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.SessionInterceptor;

@SpringBootApplication
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.ws.model.dao"/>를 대체한다.
@MapperScan(value = {"com.ssafy.ws.model.dao"})
public class SpringWs93Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringWs93Application.class, args);
	}

}

// 이미지 경로 찾기
// 인터셉터 적용하기
// 환경설정 어디서 하는지 하나씩 따져보기
// 교수님 수업에서 mapperscan은 어디서 한거지?