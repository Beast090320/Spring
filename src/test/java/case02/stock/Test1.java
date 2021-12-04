package case02.stock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.stock.MyStock;


public class Test1 {
	// 載入配置檔會將所有的 <bean scope="singleton"> 標籤內實例化，無論程式碼是否有用到
	// <bean scope="prototype"> 則不會實例化
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext2.xml");
		MyStock myStock = (MyStock)ctx.getBean("mystock");
		System.out.println(myStock);
		((ClassPathXmlApplicationContext)ctx).close();

	}
	
}