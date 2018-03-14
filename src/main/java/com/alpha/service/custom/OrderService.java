/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom;

import com.alpha.dto.OrderDTO;
import com.alpha.model.OrderDetails;
import com.alpha.model.Orders;
import com.alpha.service.SuperService;
import java.util.HashMap;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author Harindu.sul
 */
public interface OrderService extends SuperService<Orders>{
    public int addOrder(OrderDTO orderDTO)throws Exception;
    public boolean deleteOrderDetail(int id,Orders s,int batchId,double orderQty)throws Exception;
    public List<Orders> getTodayTransaction(LocalDate localDate)throws Exception;
    public List<Orders> getBetweenTodaysTransaction(LocalDate day1,LocalDate day2)throws Exception;
    public List<OrderDetails> getOrderDetailsByOrderId(int id)throws Exception;
    public HashMap<String,Double> getPassMoveItems()throws Exception;
}
