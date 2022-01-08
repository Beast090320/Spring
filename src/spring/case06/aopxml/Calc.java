package com.study.spring.case06.aopxml;

import org.springframework.stereotype.Component;

@Component

public interface Calc {
	Integer add(Integer x,Integer y);
	Integer div(Integer x,Integer y);
}
