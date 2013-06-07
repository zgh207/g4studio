package org.g4studio.demo.web;

import org.g4studio.core.metatype.Dto;
import org.g4studio.core.model.SpringBeanLoader;
import org.g4studio.core.web.BizAction;
import org.g4studio.demo.service.DemoService;

public class DoTransactionClient {

	/**
	 * 演示事务控制
	 * 
	 * @author XiongChun
	 * @since 2011-2-30
	 * @see BizAction
	 */
	public static void main(String[] args) {
		DemoService demoService = (DemoService)SpringBeanLoader.getSpringBean("demoService");
		Dto outDto = demoService.doTransactionTest();
		System.out.println("返回值:\n" + outDto);
	}

}
