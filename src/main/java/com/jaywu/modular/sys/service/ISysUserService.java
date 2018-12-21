package com.jaywu.modular.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jaywu.modular.sys.entity.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-14
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * @param params
	 */
	void list(Map<String, Object> params);

}
