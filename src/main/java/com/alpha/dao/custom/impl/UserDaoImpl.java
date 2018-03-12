package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.UserDAO;
import com.alpha.model.User;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Harindu.sul on 2/5/2018.
 */
@Repository("UserDAO")
public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(User user) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(user);
        return save != null;
    }

    @Override
    public boolean delete(int id) throws Exception {
        User search = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (search != null) {
            sessionFactory.getCurrentSession().delete(search);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User user) throws Exception {
        sessionFactory.getCurrentSession().update(user);
        return true;
    }

    @Override
    public User search(int id) throws Exception {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public List<User> getAll() throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery("select * from user");
        sql.addEntity(User.class);
        List<User> list = sql.list();
        return list;
    }

    @Override
    public User searchByUserName(String userName) throws Exception {
        Criteria c2 = sessionFactory.getCurrentSession().createCriteria(User.class);
        c2.add(Restrictions.eq("userName", userName));
        c2.setMaxResults(1);
        User user = (User) c2.uniqueResult();
        return user;
    }

    @Override
    public User authentication(String userType, String userName, String password) throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession().
                createSQLQuery("select * from user where password='" + password + "' AND userName='" + userName + "' AND type='" + userType + "'");
        sql.addEntity(User.class);
        return (User)sql.uniqueResult();

    }

    @Override
    public List<User> foundByLike(String value) throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery("select * from user where userName LIKE ''"+value+"'%';");
        sql.addEntity(User.class);
        List<User> list = sql.list();
        return list;
    }

    @Override
    public User getUserByTypeAndPassword(String type, String pass) throws Exception {
        Criteria c2 = sessionFactory.getCurrentSession().createCriteria(User.class);
        c2.add(Restrictions.eq("type", type));
        c2.add(Restrictions.eq("password", pass));
        c2.setMaxResults(1);
        User user = (User) c2.uniqueResult();
        return user;
        
    }
}
