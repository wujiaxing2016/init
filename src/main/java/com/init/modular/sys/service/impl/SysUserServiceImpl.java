package com.init.modular.sys.service.impl;

import com.init.modular.sys.entity.SysUser;
import com.init.modular.sys.mapper.SysUserMapper;
import com.init.modular.sys.service.ISysUserService;
import com.init.base.mp.extension.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-12
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
