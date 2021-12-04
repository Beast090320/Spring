package com.study.spring.case04.mvc.dao;

import org.springframework.stereotype.Repository;

// 資料交換儲存庫
@Repository
public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {
		System.out.println("UserDaoImpl");
	}
}
