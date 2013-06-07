package org.g4studio.demo.web.other.rpc.httpinvoker.client;

import org.g4studio.core.metatype.Dto;
import org.g4studio.core.model.SpringBeanLoader;

/**
 * 测试调用HttpInvoker服务
 * 
 * @author XiongChun
 *
 */
public class RunClient {

	public static void main(String[] args) {
		sayHello();
		//queryBalanceInfo();
	}
	
	private static void sayHello(){
		HelloWorldClient client = (HelloWorldClient)SpringBeanLoader.getSpringBean("client_httpinvoker");
		String outString = client.sayHello("Lily!");
		System.out.println(outString);
	}
	
	private static void queryBalanceInfo(){
		HelloWorldClient client = (HelloWorldClient)SpringBeanLoader.getSpringBean("client_httpinvoker");
		Dto outDto = client.queryBalanceInfo("BJLK1000000003900");
		System.out.println(outDto);
	}
	
}
