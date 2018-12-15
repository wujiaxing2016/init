package com.jaywu.modular.sys.service.impl;

import com.jaywu.modular.sys.entity.SysUser;
import com.jaywu.modular.sys.mapper.SysUserMapper;
import com.jaywu.modular.sys.service.ISysUserService;
import com.jaywu.base.mp.extension.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-14
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
