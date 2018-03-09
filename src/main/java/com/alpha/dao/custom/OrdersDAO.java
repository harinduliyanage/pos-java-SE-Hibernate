/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.Orders;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author Harindu.sul
 */
public interface OrdersDAO extends SuperDAO<Orders>{
    public int addOrder(Orders o)throws Exception;
    public List<Orders> getTodayTransaction(LocalDate date) throws Exception;

}
