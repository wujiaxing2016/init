package com.init.base.mp.extension;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * <p>
 * 数据Entity类
 * </p>
 * @author wujiaxing
 * @date 2018年8月24日
 * @param <T>
 */
@Data
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	protected Long id;

	/**
	 * 创建时间
	 */
    @TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime createDate;

	/**
	 * 更新时间
	 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime updateDate;

    /**
     * 删除标记
     */
    @TableField(fill = FieldFill.INSERT)
    protected Integer isDelete;

}
