package org.g4studio.test.junit;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.g4studio.core.metatype.Dto;
import org.g4studio.core.metatype.impl.BaseDto;
import org.g4studio.core.util.G4Constants;

/**
 * 数据结构DTO单元测试用例
 * 
 * @author XiongChun
 * @since 2011-03-29
 */
public class DtoTest extends TestCase {
	
	public void main(String args[]){
		TestRunner.run(DtoTest.class);
	}
	
	/**
	 * 测试DTO到XML的转换
	 */
	public void testToXml(){
		Dto dto = new BaseDto();
		dto.put("name", "XiongChun");
		dto.put("age", "28");
		String xml = dto.toXml();
		assertEquals("<root><age>28</age><name>XiongChun</name></root>", xml);
		String xml2 = dto.toXml(G4Constants.XML_Attribute);
		assertEquals("<root><row age=\"28\" name=\"XiongChun\"/></root>", xml2);
	}
	
	/**
	 * 测试DTO到JSON资料格式的转换
	 */
	public void testToJson(){
		Dto dto = new BaseDto();
		dto.put("name", "XiongChun");
		dto.put("age", "28");
		String json = dto.toJson();
		assertEquals("{\"age\":\"28\",\"name\":\"XiongChun\"}", json);
	}
}
