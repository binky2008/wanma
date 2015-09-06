package com.best.btr.wanma.bas.service.impl;

import com.best.btr.wanma.bas.dao.UserDao;
import com.best.btr.wanma.bas.entity.User;
import com.best.btr.wanma.bas.service.UserService;
import com.best.btr.wanma.bas.so.UserSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import com.jinhe.tss.framework.persistence.pagequery.PaginationQueryByHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Lu on 15/9/3.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User getEntityById(Long id) {
        return dao.getEntityById(id);
    }

    @Override
    public List<User> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    public User create(User entity) {
        return dao.create(entity);
    }

    @Override
    public User update(User entity) {
        return (User) dao.update(entity);
    }

    @Override
    public User delete(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public PageInfo search(UserSO so) {
        String hql = " from User o "
                + " where 1=1 " + so.toConditionString()
                + " order by o.id desc ";

        PaginationQueryByHQL pageQuery = new PaginationQueryByHQL(dao.em(), hql, so);
        return pageQuery.getResultList();
    }
}
