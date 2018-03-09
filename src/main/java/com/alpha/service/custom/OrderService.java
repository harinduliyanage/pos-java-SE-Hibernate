/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom;

import com.alpha.dto.OrderDTO;
import com.alpha.model.Orders;
import com.alpha.service.SuperService;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author Harindu.sul
 */
public interface OrderService extends SuperService<Orders>{
    public int addOrder(OrderDTO orderDTO)throws Exception;
    public List<Orders> getTodayTransaction(LocalDate localDate)throws Exception;
}
