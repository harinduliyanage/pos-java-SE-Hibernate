/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.ItemDAO;
import com.alpha.model.Batch;
import com.alpha.model.Item;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harindu.sul
 */
    
@Repository("ItemDAO")
public class ItemDaoImpl implements ItemDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Item item) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(item);
        return save != null;
    }
    
    @Override
    public boolean delete(int id) throws Exception {
        Item search = (Item) sessionFactory.getCurrentSession().load(Item.class, id);
        if (search != null) {
            sessionFactory.getCurrentSession().delete(search);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean update(Item item) throws Exception {
        sessionFactory.getCurrentSession().update(item);
        return true;
    }
    
    @Override
    public Item search(int id) throws Exception {
        return (Item) sessionFactory.getCurrentSession().load(Item.class, id);
    }
    
    @Override
    public List<Item> getAll() throws Exception {
        List<Item> list = sessionFactory.getCurrentSession().createCriteria(Item.class).list();
        return list;
    }

    @Override
    public Item getItemByDescription(String description) throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from item where description='"+description+"'");
        sql.addEntity(Item.class);
        sql.setMaxResults(1);
        Item item = (Item) sql.uniqueResult();
        return item;
    }

    @Override
    public Item getItemByBarcode(String barcode) throws Exception {
        Criteria c2 = sessionFactory.getCurrentSession().createCriteria(Item.class);
        c2.add(Restrictions.eq("barcode", barcode));
        c2.setMaxResults(1);
        Item item = (Item) c2.uniqueResult();
        return item;
    }

    @Override
    public List<Batch> getItemsBatchesById(int id) throws Exception {
        SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery("select * from batch where Item_id='"+id+"'");
        sql.addEntity(Batch.class);
        List <Batch> all= sql.list();
        return all;
    }

    @Override
    public List<Item> getItemsByDescriptionLike(String value) throws Exception {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Item.class);
        crit.addOrder(Order.asc("description"));
        crit.add(Restrictions.like("description",value+"%"));
        List list = crit.list();
        return list;
    }
    
}
