package com.init.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.base.utils.ApiResult;
import com.init.sys.entity.SysUser;
import com.init.sys.service.ISysUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author JayWu
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 新增方法
	 * @param user
	 * @return
	 */
	@PostMapping("save")
	public ApiResult save(SysUser user) {
		boolean result = sysUserService.save(user);
		if (result) {
			return ApiResult.success();
		}
		return ApiResult.fail("保存失败");
	}

	@PostMapping("update")
	public ApiResult update(SysUser user) {
		boolean result = sysUserService.updateById(user);
		if (result) {
			return ApiResult.success();
		}
		return ApiResult.fail("保存失败");
	}

	@GetMapping("get/{id}")
	public ApiResult get(@PathVariable String id) {
		SysUser user = sysUserService.getById(id);
		return ApiResult.success(null, user);
	}

}