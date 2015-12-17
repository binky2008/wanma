package com.best.btr.wanma.to;

import java.util.List;

import com.jinhe.tss.framework.persistence.IEntity;

public interface TOService {

	void create(IEntity entity);

	void update(IEntity entity);

	void delete(Class<?> entityClass, Long id);

	List<?> getList(String hql, Object...params);

}
