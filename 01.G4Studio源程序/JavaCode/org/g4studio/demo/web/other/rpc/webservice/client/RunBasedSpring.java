package org.g4studio.demo.web.other.rpc.webservice.client;

import org.g4studio.core.model.SpringBeanLoader;
import org.g4studio.demo.web.other.rpc.webservice.HelloWorldService;

public class RunBasedSpring {
	
	public static void main(String[] args) {
		sayHello();
		queryBalanceInfo();
	}
	
	private static void sayHello(){
		HelloWorldService helloWorldService = (HelloWorldService)SpringBeanLoader.getSpringBean("helloWorldService");
		String outString = helloWorldService.sayHello("Afghan!");
		System.out.println(outString);
	}
	
	private static void queryBalanceInfo(){
		HelloWorldService helloWorldService = (HelloWorldService)SpringBeanLoader.getSpringBean("helloWorldService");
		String outString = helloWorldService.queryBalanceInfo("BJLK1000000003900");
		System.out.println(outString);
	}
}
