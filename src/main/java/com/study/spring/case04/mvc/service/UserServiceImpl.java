package com.study.spring.case04.mvc.service;

import org.springframework.stereotype.Service;

// 商業邏輯層
@Service
public class UserServiceImpl  implements UserService{
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}
