package com.huilian.petitcredit.base.pushmsg.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huilian.hlej.base.mybatis.SqlSessionFactoryUtil;
import com.huilian.hlej.base.utils.StringUtil;
import com.huilian.petitcredit.base.pushmsg.dao.BaseDao;
import com.huilian.petitcredit.base.pushmsg.utils.MapUtil;
import com.huilian.petitcredit.base.pushmsg.utils.PageUtil;

public abstract class BaseServiceImpl<T> {
	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	private ThreadLocal<SqlSession> localSession = new ThreadLocal<SqlSession>();

	/**
	 * 获取哪个mapper接口
	 * 
	 * @return
	 */
	public abstract Class<? extends BaseDao<T>> getMapperClass();

	/**
	 * mybatis mapper的接口
	 */
	public BaseDao<T> getDao() {
		SqlSession session = localSession.get();
		if (session == null) {
			session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		}
		BaseDao<T> dao = session.getMapper(getMapperClass());
		localSession.set(session);
		return dao;
	}
	
	public abstract BaseDao<T> getDaoImpl(); 

	public void closeSession() {
		SqlSession session = localSession.get();
		if (session != null) {
			session.close();
		}
		localSession.remove();
	}

	public void commit() {
		SqlSession session = localSession.get();
		if (session != null) {
			session.commit();
		}
	}

	public void rollback() {
		SqlSession session = localSession.get();
		if (session != null) {
			session.rollback();
		}
	}

	public int getCountByCondition(Map<String, Object> conditionMap) {
		logger.info("getCountByCondition start");
		int count = 0;
		try {
			logger.info("getCountByCondition conditionMap" + MapUtil.toString(conditionMap));
			count = getDao().getCountByCondition(conditionMap);
			logger.info("getCountByCondition count :" + count);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			closeSession();
		}
		logger.info("getCountByCondition end");
		return count;
	}

	public List<T> findListByCondition(Map<String, Object> conditionMap) {
		logger.info("findListByCondition start");
		List<T> list = null;
		try {
			logger.info("findListByCondition conditionMap" + MapUtil.toString(conditionMap));
			PageUtil pageUtil = (PageUtil) conditionMap.get("pageUtil");
			int count = getCountByCondition(conditionMap);
			pageUtil.setRowCount(count);
			pageUtil.splitPageInstance();
			list = getDao().findByCondition(conditionMap);
			logger.info("findListByCondition list size :" + (null == list || list.isEmpty() ? 0 : list.size()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			closeSession();
		}
		logger.info("findListByCondition end");
		return list;
	}

	public T findByNum(String num) {
		logger.info("findByNum start");
		T model = null;
		try {
			if (StringUtil.isEmpty(num)) {
				logger.info("findByNum , num invalid");
				return null;
			}
			model = getDao().findByNum(num);
			logger.info("findByNum , num :" + num + " ,model :" + model.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			closeSession();
		}
		logger.info("findByNum end");
		return model;
	}

	public T update(T obj) {
		logger.info("update start");
		try {
			if (null == obj) {
				logger.info("update , obj is null ");
				return null;
			}
			int result = getDao().update(obj);
			commit();
			logger.info("update , obj :" + obj + " , result  :" + result);
			if (result > 0) {
				return obj;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			logger.info("update end");
			closeSession();
		}
	}

	public T insert(T obj) {
		logger.info("insert start");
		try {
			if (null == obj) {
				logger.info("insert , obj is null ");
				return null;
			}
			int result = getDao().insert(obj);
			commit();
			logger.info("insert , obj :" + obj + " , result  :" + result);
			if (result > 0) {
				return obj;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			logger.info("insert end");
			closeSession();
		}
	}
	public Integer insertBatch(List<T> list) {
		logger.info("insertBatch start");
		try {
			if (null == list) {
				logger.info("insertBatch , list is null ");
				return null;
			}
			if (list.isEmpty()) {
				logger.info("insertBatch , list is empty ");
				return null;
			}
			int result = getDao().insertBatch(list);  
			commit();
			logger.info("insert , obj :" + list + " , result  :" + result);
			if (result > 0) {
				return result;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			logger.info("insertBatch end");
			closeSession();
		}
	}
	public Integer updateBatch(List<T> list) {
		logger.info("updateBatch start");
		try {
			if (null == list) {
				logger.info("updateBatch , list is null ");
				return null;
			}
			if (list.isEmpty()) {
				logger.info("updateBatch , list is empty ");
				return null;
			}
			int result = getDao().updateBatch(list);  
			commit();
			logger.info("update , list :" + list + " , result  :" + result);
			if (result > 0) {
				return result;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			logger.info("updateBatch end");
			closeSession();
		}
	}

}
