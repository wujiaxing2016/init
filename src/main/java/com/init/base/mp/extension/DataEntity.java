package com.init.base.mp.extension;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 数据Entity类
 * </p>
 * @author wujiaxing
 * @date 2018年8月24日
 * @param <T>
 */
public abstract class DataEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	protected Long id;

	/**
	 * 创建时间
	 */
	@TableField("create_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime createAt;

	/**
	 * 更新时间
	 */
	@TableField("update_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime updateAt;

	public DataEntity() {
		super();
	}

	public static <V extends DataEntity<?>> Map<Long, V> toMap(List<V> list) {
		Map<Long, V> map = new HashMap<Long, V>();
		if (list != null) {
			for (V v : list) {
				map.put(v.getId(), v);
			}
		}
		return map;
	}

	/**
	 * 使用{@link LinkedHashSet},有顺序
	 * @param list
	 * @return
	 */
	public static <V extends DataEntity<?>> Set<Long> toIdSet(List<V> list) {
		Set<Long> set = new LinkedHashSet<Long>();
		if (list != null) {
			for (V v : list) {
				set.add(v.getId());
			}
		}
		return set;
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert() {
		if (this.createAt == null) {
			this.createAt = LocalDateTime.now();
		}
		if (this.updateAt == null) {
			this.updateAt = this.createAt;
		}
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate() {
		this.updateAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

}
