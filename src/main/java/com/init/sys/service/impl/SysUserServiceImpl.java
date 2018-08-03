package com.init.sys.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.init.sys.entity.SysUser;
import com.init.sys.mapper.SysUserMapper;
import com.init.sys.service.ISysUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author JayWu
 * @since 2018-08-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Override
	public boolean save(SysUser entity) {
		LocalDateTime now = LocalDateTime.now();
		entity.setCreateAt(now);
		entity.setUpdateAt(now);
		return ServiceImpl.retBool(baseMapper.insert(entity));
	}

	@Override
	public boolean updateById(SysUser entity) {
		entity.setUpdateAt(LocalDateTime.now());
		return ServiceImpl.retBool(baseMapper.updateById(entity));
	}

}
