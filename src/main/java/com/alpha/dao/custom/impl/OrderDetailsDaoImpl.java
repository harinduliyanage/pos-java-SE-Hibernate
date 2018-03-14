/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.BatchDAO;
import com.alpha.dao.custom.OrderDetailsDAO;
import com.alpha.model.Batch;
import com.alpha.model.OrderDetails;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harindu.sul
 */
@Repository("OrderDetailsDAO")
public class OrderDetailsDaoImpl implements OrderDetailsDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BatchDAO batchDAO;

    @Override
    public boolean add(OrderDetails t) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(t);
        return save != null;
    }

    @Override
    public boolean delete(int id) throws Exception {
        OrderDetails search = (OrderDetails) sessionFactory.getCurrentSession().get(OrderDetails.class, id);
        if (search != null) {
            SQLQuery sql = sessionFactory.getCurrentSession()
                    .createSQLQuery("delete from order_details where ORDER_DETAILS_ID='"+id+"'");
            int executeUpdate = sql.executeUpdate();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(OrderDetails t) throws Exception {
        sessionFactory.getCurrentSession().update(t);
        return true;
    }

    @Override
    public OrderDetails search(int id) throws Exception {
        return (OrderDetails) sessionFactory.getCurrentSession().get(OrderDetails.class, id);
    }

    @Override
    public List<OrderDetails> getAll() throws Exception {
        List<OrderDetails> list = sessionFactory.getCurrentSession().createCriteria(OrderDetails.class).list();
        return list;
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderID(int id) throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery("select*from order_details where order_id='"+id+"'");
        sql.addEntity(OrderDetails.class);
        List<OrderDetails> list = sql.list();
        Hibernate.isInitialized(list);
        for (OrderDetails o : list) {
            Batch search = batchDAO.search(o.getBatch().getId());
            o.setBatch(search);
        }
        return list;

    }

}
