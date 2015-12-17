package com.best.btr.wanma.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinhe.tss.framework.persistence.ICommonDao;
import com.jinhe.tss.framework.persistence.IEntity;

@Service("TOService")
public class TOServiceImpl implements TOService {
	
	@Autowired private ICommonDao commonDao;

	public void create(IEntity entity) {
		commonDao.createObject(entity);
	}

	public void update(IEntity entity) {
		commonDao.update(entity);
	}

	public void delete(Class<?> entityClass, Long id) {
		commonDao.delete(entityClass, id);
	}

	public List<?> getList(String hql, Object...params) {
		return commonDao.getEntities(hql, params);
	}
 
}
