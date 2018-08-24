package com.init.sys.service.impl;

import org.springframework.stereotype.Service;

import com.init.base.mp.extension.ServiceCustomImpl;
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
public class SysUserServiceImpl extends ServiceCustomImpl<SysUserMapper, SysUser> implements ISysUserService {
}
