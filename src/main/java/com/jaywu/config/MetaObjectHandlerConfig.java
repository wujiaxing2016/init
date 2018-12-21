package com.jaywu.config;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * <p>
 * Mybatis Plus自动填充功能
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		System.out.println("插入方法实体填充");
		setFieldValByName("createDate", LocalDateTime.now(), metaObject);
		setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
//		setFieldValByName("isDelete", 0, metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		System.out.println("更新方法实体填充");
		setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
	}
}
