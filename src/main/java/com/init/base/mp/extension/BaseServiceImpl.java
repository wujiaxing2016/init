package com.init.base.mp.extension;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.TableInfoHelper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

/**
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-12
 */
@SuppressWarnings("unchecked")
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements IBaseService<T> {

	@Autowired
	protected M baseMapper;

	/**
	 * <p>
	 * 判断数据库操作是否成功
	 * </p>
	 * <p>
	 * 注意！！ 该方法为 Integer 判断，不可传入 int 基本类型
	 * </p>
	 *
	 * @param result 数据库操作返回影响条数
	 * @return boolean
	 */
	protected static boolean retBool(Integer result) {
		return SqlHelper.retBool(result);
	}

	protected Class<T> currentModelClass() {
		return ReflectionKit.getSuperClassGenericType(getClass(), 1);
	}

	/**
	 * <p>
	 * 批量操作 SqlSession
	 * </p>
	 */
	protected SqlSession sqlSessionBatch() {
		return SqlHelper.sqlSessionBatch(currentModelClass());
	}

	/**
	 * 获取SqlStatement
	 *
	 * @param sqlMethod
	 * @return
	 */
	protected String sqlStatement(SqlMethod sqlMethod) {
		return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
	}

	@Override
	public boolean insert(T entity) {
		return BaseServiceImpl.retBool(baseMapper.insert(entity));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertBatch(Collection<T> entityList) {
		return insertBatch(entityList, 30);
	}

	/**
	 * 批量插入
	 *
	 * @param entityList
	 * @param batchSize
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertBatch(Collection<T> entityList, int batchSize) {
		if (CollectionUtils.isEmpty(entityList)) {
			throw new IllegalArgumentException("Error: entityList must not be empty");
		}
		try (SqlSession batchSqlSession = sqlSessionBatch()) {
			int i = 0;
			String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
			for (T anEntityList : entityList) {
				batchSqlSession.insert(sqlStatement, anEntityList);
				if (i >= 1 && i % batchSize == 0) {
					batchSqlSession.flushStatements();
				}
				i++;
			}
			batchSqlSession.flushStatements();
		} catch (Throwable e) {
			throw ExceptionUtils.mpe("Error: Cannot execute saveBatch Method. Cause", e);
		}
		return true;
	}

	/**
	 * <p>
	 * TableId 注解存在更新记录，否插入一条记录
	 * </p>
	 *
	 * @param entity 实体对象
	 * @return boolean
	 */
	@Override
	public boolean insertOrUpdate(T entity) {
		if (null != entity) {
			Class<?> cls = entity.getClass();
			TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
			if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
				Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
				if (StringUtils.checkValNull(idVal)) {
					return insert(entity);
				} else {
					/*
					 * 更新成功直接返回，失败执行插入逻辑
					 */
					return updateById(entity) || insert(entity);
				}
			} else {
				throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId.");
			}
		}
		return false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertOrUpdateBatch(Collection<T> entityList) {
		return insertOrUpdateBatch(entityList, 30);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertOrUpdateBatch(Collection<T> entityList, int batchSize) {
		if (CollectionUtils.isEmpty(entityList)) {
			throw new IllegalArgumentException("Error: entityList must not be empty");
		}
		try (SqlSession batchSqlSession = sqlSessionBatch()) {
			for (T anEntityList : entityList) {
				insertOrUpdate(anEntityList);
			}
			batchSqlSession.flushStatements();
		} catch (Throwable e) {
			throw ExceptionUtils.mpe("Error: Cannot execute saveOrUpdateBatch Method. Cause", e);
		}
		return true;
	}

	@Override
	public boolean deleteById(Serializable id) {
		return SqlHelper.delBool(baseMapper.deleteById(id));
	}

	@Override
	public boolean deleteByMap(Map<String, Object> columnMap) {
		if (ObjectUtils.isEmpty(columnMap)) {
			throw ExceptionUtils.mpe("removeByMap columnMap is empty.");
		}
		return SqlHelper.delBool(baseMapper.deleteByMap(columnMap));
	}

	@Override
	public boolean delete(Wrapper<T> wrapper) {
		return SqlHelper.delBool(baseMapper.delete(wrapper));
	}

	@Override
	public boolean deleteByIds(Collection<? extends Serializable> idList) {
		return SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
	}

	@Override
	public boolean updateById(T entity) {
		return BaseServiceImpl.retBool(baseMapper.updateById(entity));
	}

	@Override
	public boolean update(T entity, Wrapper<T> updateWrapper) {
		return BaseServiceImpl.retBool(baseMapper.update(entity, updateWrapper));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateBatchById(Collection<T> entityList) {
		return updateBatchById(entityList, 30);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateBatchById(Collection<T> entityList, int batchSize) {
		if (CollectionUtils.isEmpty(entityList)) {
			throw new IllegalArgumentException("Error: entityList must not be empty");
		}
		try (SqlSession batchSqlSession = sqlSessionBatch()) {
			int i = 0;
			String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
			for (T anEntityList : entityList) {
				MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
				param.put(Constants.ENTITY, anEntityList);
				batchSqlSession.update(sqlStatement, param);
				if (i >= 1 && i % batchSize == 0) {
					batchSqlSession.flushStatements();
				}
				i++;
			}
			batchSqlSession.flushStatements();
		} catch (Throwable e) {
			throw ExceptionUtils.mpe("Error: Cannot execute updateBatchById Method. Cause", e);
		}
		return true;
	}

	@Override
	public T selectById(Serializable id) {
		return baseMapper.selectById(id);
	}

	@Override
	public Collection<T> selectListByIds(Collection<? extends Serializable> idList) {
		return baseMapper.selectBatchIds(idList);
	}

	@Override
	public Collection<T> selectListByMap(Map<String, Object> columnMap) {
		return baseMapper.selectByMap(columnMap);
	}

	@Override
	public T selectOne(Wrapper<T> queryWrapper) {
		return SqlHelper.getObject(baseMapper.selectList(queryWrapper));
	}

	@Override
	public Map<String, Object> selectMap(Wrapper<T> queryWrapper) {
		return SqlHelper.getObject(baseMapper.selectMaps(queryWrapper));
	}

	@Override
	public Object selectObj(Wrapper<T> queryWrapper) {
		return SqlHelper.getObject(baseMapper.selectObjs(queryWrapper));
	}

	@Override
	public int selectCount(Wrapper<T> queryWrapper) {
		return SqlHelper.retCount(baseMapper.selectCount(queryWrapper));
	}

	@Override
	public List<T> selectList(Wrapper<T> queryWrapper) {
		return baseMapper.selectList(queryWrapper);
	}

	@Override
	public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
		return baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<Map<String, Object>> selectListMaps(Wrapper<T> queryWrapper) {
		return baseMapper.selectMaps(queryWrapper);
	}

	@Override
	public List<Object> selectListObjs(Wrapper<T> queryWrapper) {
		return baseMapper.selectObjs(queryWrapper).stream().filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public IPage<Map<String, Object>> selectPageMaps(IPage<T> page, Wrapper<T> queryWrapper) {
		return baseMapper.selectMapsPage(page, queryWrapper);
	}

}
