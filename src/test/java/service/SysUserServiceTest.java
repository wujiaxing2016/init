package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaywu.modular.sys.entity.SysUser;
import com.jaywu.modular.sys.service.ISysUserService;

import base.BaseJunit4Test;

/**<p>
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-12
 */
public class SysUserServiceTest extends BaseJunit4Test {
	
	@Autowired
	private ISysUserService sysUserService;

	@Test
	public void hello() {
		System.out.println(111);
	}
	@Test
	public void testInsert() {
		SysUser entity = new SysUser();
		entity.setName("wjx");
		sysUserService.save(entity );
	}
	@Test
	public void testUpdate() {
		SysUser entity = new SysUser();
		entity.setId(1072748149062434818l);
		entity.setName("大神");
		boolean result = sysUserService.updateById(entity);
		System.out.println(result);
	}
	@Test
	public void testDelete() {
		boolean result = sysUserService.removeById(1072748149062434818l);
		System.out.println(result);
	}
	
	@Test
	public IPage<?> testPage() {
		SysUser entity = new SysUser();
		entity.setName("刘雪凤");
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>(entity );
		Page<SysUser> page = new Page<>();
		IPage<SysUser> selectPage = sysUserService.page(page, queryWrapper);
		System.out.println(selectPage);
		return selectPage;
	}
}
