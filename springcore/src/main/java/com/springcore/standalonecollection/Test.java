package com.springcore.standalonecollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/standalonecollection/configcollection.xml");
		Person p=(Person)context.getBean("person1",Person.class);
		System.out.println(p);
	}

}
