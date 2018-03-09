/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.BatchDAO;
import com.alpha.model.Batch;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harindu.sul
 */
@Repository("BatchDAO")
public class BatchDaoImpl implements BatchDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Batch getBatchByBatchName(String batch) throws Exception {
        Criteria c2 = sessionFactory.getCurrentSession().createCriteria(Batch.class);
        c2.add(Restrictions.eq("batch", batch));
        c2.setMaxResults(1);
        Batch batch1 = (Batch) c2.uniqueResult();
        return batch1;
    }

    @Override
    public boolean add(Batch batch) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(batch);
        return save != null;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Batch search = (Batch) sessionFactory.getCurrentSession().load(Batch.class, id);
        if (search != null) {
            sessionFactory.getCurrentSession().delete(search);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Batch batch) throws Exception {
        sessionFactory.getCurrentSession().update(batch);
        return true;
    }

    @Override
    public Batch search(int id) throws Exception {
        return (Batch) sessionFactory.getCurrentSession().load(Batch.class, id);
    }

    @Override
    public List<Batch> getAll() throws Exception {
        List<Batch> list = sessionFactory.getCurrentSession().createCriteria(Batch.class).list();
        return list;
    }

    @Override
    public Batch getBatchByBatchNameAndItemId(String batch, int itemId) throws Exception {
        SQLQuery query = sessionFactory.
                getCurrentSession().
                createSQLQuery("select * from batch where  Item_id='" + itemId + "' AND batch= '" + batch + "'");
        query.addEntity(Batch.class);
        return (Batch) query.uniqueResult();
    }

}
