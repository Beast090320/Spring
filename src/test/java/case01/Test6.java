package case01;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Animal;
import com.study.spring.case01.Dog;
import com.study.spring.case01.Cat;

public class Test6 {
	// 載入配置檔會將所有的 <bean scope="singleton"> 標籤內實例化，無論程式碼是否有用到
	// <bean scope="prototype"> 則不會實例化
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
			
		Animal[] animals = {
				ctx.getBean("dog", Dog.class),
				ctx.getBean("dog2", Dog.class),
				ctx.getBean(Cat.class),
		};
		
		Arrays.stream(animals).forEach(Animal::printName);
	}


	
}