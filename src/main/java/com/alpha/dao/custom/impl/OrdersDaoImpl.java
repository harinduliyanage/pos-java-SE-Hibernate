/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.OrdersDAO;
import com.alpha.model.Orders;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harindu.sul
 */
@Repository("OrdersDAO")
public class OrdersDaoImpl implements OrdersDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(Orders order) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Orders search = (Orders) sessionFactory.getCurrentSession().load(Orders.class, id);
        if (search != null) {
            sessionFactory.getCurrentSession().delete(search);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Orders order) throws Exception {
        sessionFactory.getCurrentSession().update(order);
        return true;
    }

    @Override
    public Orders search(int id) throws Exception {
        return (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);

    }

    @Override
    public List<Orders> getAll() throws Exception {
        List<Orders> list = sessionFactory.getCurrentSession().createCriteria(Orders.class).list();
        return list;
    }

    @Override
    public int addOrder(Orders orders) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(orders);
        if (save != null) {
            String val = save.toString();
            int id = Integer.parseInt(val);
            return id;
        } else {
            return -1;
        }
    }

    @Override
    public List<Orders> getTodayTransaction(LocalDate date) throws Exception {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Orders.class);
        crit.addOrder(Order.asc("time"));
        crit.add(Restrictions.eq("date", date));
        List list = crit.list();
        return list;
    }

    @Override
    public List<Orders> getBetweenTwodayTransaction(LocalDate date, LocalDate day2) throws Exception {
        SQLQuery sql = sessionFactory
                .getCurrentSession()
                .createSQLQuery("select * from orders where (dates BETWEEN '" + date + "' AND '" + day2 + "')");
        sql.addEntity(Orders.class);
        return (List<Orders>) sql.list();
    }

    @Override
    public HashMap<String, Double> getPassMoveItems() throws Exception {
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery("select description, SUM(orderOty) as MovedQty FROM order_details GROUP BY description ORDER BY MovedQty DESC");
        Iterator iterator = q.list().iterator();
        HashMap<String, Double> map = new HashMap<>();
        while (iterator.hasNext()) {
            Object[] result = (Object[]) iterator.next();
            String description = (String) result[0];
            double movedQty = (Double) result[1];
            map.put(description, movedQty);
        }
        return map;
    }
}