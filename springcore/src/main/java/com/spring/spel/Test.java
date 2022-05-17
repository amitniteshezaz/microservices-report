package com.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/spel/configspwl.xml");
		Demo d=(Demo)context.getBean("demo",Demo.class);
		System.out.println(d);
	}

}
