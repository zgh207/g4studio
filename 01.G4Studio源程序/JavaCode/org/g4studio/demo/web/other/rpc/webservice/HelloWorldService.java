package org.g4studio.demo.web.other.rpc.webservice;

import javax.jws.WebService;

import org.g4studio.core.metatype.BaseDomain;

/**
 * WebService接口
 * 
 * @author XiongChun
 * @since 2010-10-13
 * @see BaseDomain
 */
@WebService
public interface HelloWorldService {
	/**
	 * 需要对外发布的方法
	 * @param text
	 * @return
	 */
	public String sayHello(String text);
	
	/**
	 * 查询一条结算明细测试数据
	 * @param jsbh
	 * @return XML字符串
	 */
	public String queryBalanceInfo(String jsbh);
	
}
