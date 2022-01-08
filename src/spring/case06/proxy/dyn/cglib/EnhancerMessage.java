package com.study.spring.case06.proxy.dyn.cglib;
// 增強版 Message
public class EnhancerMessage extends Message{
	// 覆寫
	// Interceptor 攔截
	@Override
	public String send(String msg) {
		return super.send(msg) + "請出示實聯訊息";
	}
	
}
