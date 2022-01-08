package com.study.spring.case06.aop_dancer;

import java.util.Date;

import org.springframework.stereotype.Component;

//@Component // 若使用 Java 配置 則 @Component 可以不用加入
public class Dancer implements Performance{
	
	@Override
	public void perform() {
		System.out.println("舞者開表演:跳舞, 轉圈, 翻滾...");
		if(new Date().getTime() % 2 == 0) {
			throw new RuntimeException("舞者跌倒");
		}
	}
}
