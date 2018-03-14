/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom.impl;

import com.alpha.dao.custom.GrnDAO;
import com.alpha.model.Grn;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harindu.sul
 */
@Repository("GrnDAO")
public class GrnDaoImpl implements GrnDAO {

    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    public boolean add(Grn t) throws Exception {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Grn t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grn search(int id) throws Exception {
         return (Grn) sessionFactory.getCurrentSession().load(Grn.class, id);
    }

    @Override
    public List<Grn> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAddedGRNID() throws Exception {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Grn.class,"d");
        c.addOrder(Order.desc("d.id"));
        c.setMaxResults(1);
        List<Grn> list =(List<Grn>) c.list();
        return list.get(0).getId();
    }

    @Override
    public int addGrn(Grn t) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(t);
        if (save!=null) {
            String val = save.toString();
            int id = Integer.parseInt(val);
            return id;
        }else{
            return -1;
        }
    }

}
