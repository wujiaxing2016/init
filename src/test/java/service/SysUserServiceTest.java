package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.init.modular.sys.entity.SysUser;
import com.init.modular.sys.service.ISysUserService;

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
	public void testInsert() {
		SysUser entity = new SysUser();
		entity.setName("wjx");
		sysUserService.insert(entity );
	}
	@Test
	public void testUpdate() {
		SysUser entity = new SysUser();
		entity.setId(1072748149062434818l);
		entity.setName("大神");
		boolean result = sysUserService.updateById(entity);
		System.out.println(result);
	}
}
