package com.init.base.mp.extension;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author wujiaxing
 * @date 2018年8月24日
 */
// public interface IServiceCustom<T extends DataEntity<T>> {
public interface IServiceCustom<T> {

	/**
	 * <p>
	 * 插入一条记录（选择字段，策略插入）
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	boolean insert(T entity);

	/**
	 * <p>
	 * 插入（批量），该方法不适合 Oracle
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	boolean insertBatch(Collection<T> entityList);

	/**
	 * <p>
	 * 插入（批量）
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize 插入批次数量
	 */
	boolean insertBatch(Collection<T> entityList, int batchSize);

	/**
	 * <p>
	 * 批量修改插入
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	boolean insertOrUpdateBatch(Collection<T> entityList);

	/**
	 * <p>
	 * 批量修改插入
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize 每次的数量
	 */
	boolean insertOrUpdateBatch(Collection<T> entityList, int batchSize);

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 */
	boolean deleteById(Serializable id);

	/**
	 * <p>
	 * 根据 columnMap 条件，删除记录
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 */
	boolean deleteByMap(Map<String, Object> columnMap);

	/**
	 * <p>
	 * 根据 entity 条件，删除记录
	 * </p>
	 *
	 * @param queryWrapper 实体包装类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	boolean delete(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	boolean deleteByIds(Collection<? extends Serializable> idList);

	/**
	 * <p>
	 * 根据 ID 选择修改
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	boolean updateById(T entity);

	/**
	 * <p>
	 * 根据 whereEntity 条件，更新记录
	 * </p>
	 *
	 * @param entity 实体对象
	 * @param updateWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper}
	 */
	boolean update(T entity, Wrapper<T> updateWrapper);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	boolean updateBatchById(Collection<T> entityList);

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize 更新批次数量
	 */
	boolean updateBatchById(Collection<T> entityList, int batchSize);

	/**
	 * <p>
	 * TableId 注解存在更新记录，否插入一条记录
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	boolean insertOrUpdate(T entity);

	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 *
	 * @param id 主键ID
	 */
	T selectById(Serializable id);

	/**
	 * <p>
	 * 查询（根据ID 批量查询）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	Collection<T> selectListByIds(Collection<? extends Serializable> idList);

	/**
	 * <p>
	 * 查询（根据 columnMap 条件）
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 */
	Collection<T> selectListByMap(Map<String, Object> columnMap);

	/**
	 * <p>
	 * 根据 Wrapper，查询一条记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	T selectOne(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 根据 Wrapper，查询一条记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	Map<String, Object> selectMap(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 根据 Wrapper，查询一条记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	Object selectObj(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 根据 Wrapper 条件，查询总记录数
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	int selectCount(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 查询列表
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	List<T> selectList(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 翻页查询
	 * </p>
	 *
	 * @param page 翻页对象
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 查询列表
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	List<Map<String, Object>> selectListMaps(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 根据 Wrapper 条件，查询全部记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	List<Object> selectListObjs(Wrapper<T> queryWrapper);

	/**
	 * <p>
	 * 翻页查询
	 * </p>
	 *
	 * @param page 翻页对象
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	IPage<Map<String, Object>> selectPageMaps(IPage<T> page, Wrapper<T> queryWrapper);
}
