package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.TurnOn;

public class Test7 {
	// 載入配置檔會將所有的 <bean scope="singleton"> 標籤內實例化，無論程式碼是否有用到
	// <bean scope="prototype"> 則不會實例化
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		TurnOn turnOn = ctx.getBean(TurnOn.class);
		turnOn.play();
		
	 	((ClassPathXmlApplicationContext)ctx).close();
	}
	
}