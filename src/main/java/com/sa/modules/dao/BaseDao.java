package com.sa.modules.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {

	//新增
	void add(T t);
	
	void add(Map<String, Object> map);
	
	void addBatch(List<T> list);

	//更新
	int update(T t);

	int update(Map<String, Object> map);

	//删除
	int delete(long id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	//分页
	T queryObject(Object id);

	List<T> queryList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
