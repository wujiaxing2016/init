package com.jaywu.modular.sys.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jaywu.modular.sys.entity.SysUser;
import com.jaywu.modular.sys.mapper.SysUserMapper;
import com.jaywu.modular.sys.service.ISysUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	/* (non-Javadoc)
	 * @see com.jaywu.modular.sys.service.ISysUserService#list(java.util.Map)
	 */
	@Override
	public void list(Map<String, Object> params) {
		
	}

}
