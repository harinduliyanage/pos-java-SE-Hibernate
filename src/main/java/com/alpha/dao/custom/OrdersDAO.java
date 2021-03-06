/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.Orders;
import java.util.HashMap;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author Harindu.sul
 */
public interface OrdersDAO extends SuperDAO<Orders>{
    public int addOrder(Orders o)throws Exception;
    public List<Orders> getTodayTransaction(LocalDate date) throws Exception;
    public List<Orders> getBetweenTwodayTransaction(LocalDate date,LocalDate day2) throws Exception;
    public HashMap<String,Double> getPassMoveItems()throws Exception;
    public List<Orders> getLast500_OrderDetails()throws Exception;

}
