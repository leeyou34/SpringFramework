package com.springbook.ioc.injection;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Map<String, String> addressList = bean.getAddressList();
		
//			System.out.println(addressList.get("고길동"));
//			System.out.println(addressList.get("이영호"));
			
		for(String key : addressList.keySet()) {
			System.out.println(addressList.get(key));
		}
		
		factory.close();
	}
}
