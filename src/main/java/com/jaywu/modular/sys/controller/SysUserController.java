package com.jaywu.modular.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaywu.base.utils.R;
import com.jaywu.modular.sys.entity.SysUser;
import com.jaywu.modular.sys.service.ISysUserService;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;

	@PostMapping("insert")
	public R<?> insert(@RequestBody(required = true) SysUser user) {
		boolean insert = sysUserService.insert(user);
		if (insert) {
			return R.success(user);
		}
		return R.fail();
	}

	@GetMapping("selectList")
	public R<?> selectList() {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("name", "w");
		List<SysUser> data = sysUserService.selectList(queryWrapper);
		log.info("武佳兴:{}", data);
		return R.success(data);
	}

	@GetMapping("selectPage")
	public R<?> selectPage(long current, long size) {
		SysUser entity = new SysUser();
		entity.setName("刘雪凤");
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>(entity);
		Page<SysUser> page = new Page<>();
		page.setCurrent(current); // 当前页
		page.setSize(size); // 每页几条
		page.setDesc("create_date");
		IPage<SysUser> selectPage = sysUserService.selectPage(page, queryWrapper);
		return R.success(selectPage);
	}

}
