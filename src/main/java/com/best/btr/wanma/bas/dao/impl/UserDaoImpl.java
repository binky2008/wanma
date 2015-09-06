package com.best.btr.wanma.bas.dao.impl;

import com.best.btr.wanma.bas.dao.UserDao;
import com.best.btr.wanma.bas.entity.User;
import com.jinhe.tss.framework.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Repository("UserDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getEntityById(Long id) {
        return super.getEntity(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllEntities() {
        return (List<User>) super.getEntities("from User");
    }
}
