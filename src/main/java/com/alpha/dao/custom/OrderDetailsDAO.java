/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.OrderDetails;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */
public interface OrderDetailsDAO extends SuperDAO<OrderDetails>{
    public List<OrderDetails> getOrderDetailsByOrderID(int id)throws Exception;
}
