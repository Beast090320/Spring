package com.study.spring.case06.aopxml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyMaskAspect {

	// 前置通知
	// JoinPoint 連接點
	public void before(JoinPoint joinpoint) {

		System.out.println("BEFORE - 戴上口罩");
	}

	public void end(JoinPoint joinpoint) {

		System.out.println("END - 脫下口罩");
	}
}
