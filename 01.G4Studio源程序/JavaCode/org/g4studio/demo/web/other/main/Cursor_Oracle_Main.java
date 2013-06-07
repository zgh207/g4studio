package org.g4studio.demo.web.other.main;

import java.util.List;

import org.g4studio.core.metatype.Dto;
import org.g4studio.core.metatype.impl.BaseDto;
import org.g4studio.core.model.SpringBeanLoader;
import org.g4studio.core.model.dao.Dao;

/**
 * 演示调用Oracle存储过程返回游标，并将游标映射为Java List集合对象的标准范例
 * 
 * @author XiongChun
 * @since 2012-10-30
 */
public class Cursor_Oracle_Main {
	
	public static void main(String[] args) {
		Dao g4Dao = (Dao)SpringBeanLoader.getSpringBean("g4Dao");
		Dto prcDto = new BaseDto();
		prcDto.put("prm_Xm", "李");
		g4Dao.callPrc("Demo.g4_prc_cursor_demo", prcDto);
		List list = prcDto.getAsList("cur_list");
		for (int i = 0; i < list.size(); i++) {
			Dto dto = (BaseDto)list.get(i);
			System.out.println(dto.getAsString("xm") + "：" + dto.getAsBigDecimal("fyze"));
		}
	}

}
