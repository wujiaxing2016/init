package com.init.modular.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.modular.sys.entity.SysUser;
import com.init.modular.sys.service.ISysUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {
	
	@Autowired
	private ISysUserService sysUserService;

	@GetMapping("test")
	public void insert() {
		SysUser entity = new SysUser();
		entity.setName("wjx");
		sysUserService.insert(entity );
	}
}
