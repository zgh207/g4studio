package org.g4studio.system.admin.service;

import org.g4studio.core.metatype.Dto;
import org.g4studio.core.model.service.BizService;

/*
 * 全局参数管理业务接口
 * @author XiongChun
 * @since 2010-05-13
 */
public interface ParamService extends BizService{

	/**
	 * 保存参数信息表
	 */
	public Dto saveParamItem(Dto pDto);

	/**
	 * 删除参数信息
	 * 
	 * @param pDto
	 */
	public Dto deleteParamItem(Dto pDto);

	/**
	 * 修改参数信息
	 * 
	 * @param pDto
	 */
	public Dto updateParamItem(Dto pDto);
}
