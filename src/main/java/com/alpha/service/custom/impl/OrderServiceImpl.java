/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom.impl;

import com.alpha.dao.custom.BatchDAO;
import com.alpha.dao.custom.OrderDetailsDAO;
import com.alpha.dao.custom.OrdersDAO;
import com.alpha.dto.OrderDTO;
import com.alpha.model.Batch;
import com.alpha.model.OrderDetails;
import com.alpha.model.Orders;
import com.alpha.service.custom.OrderService;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harindu.sul
 */
@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersDAO orderDAO;

    @Autowired
    OrderDetailsDAO orderDetailsDAO;

    @Autowired
    BatchDAO batchDAO;

    @Override
    public boolean add(Orders t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public boolean delete(int id) throws Exception {
        List<OrderDetails> all = orderDetailsDAO.getOrderDetailsByOrderID(id);
        if(all!=null){
            for (OrderDetails o : all) {
                Batch batch = o.getBatch();
                double qtyOnHand = batch.getQtyOnHand();
                double orderOTY = o.getOrderOTY();
                qtyOnHand=qtyOnHand+orderOTY;
                batch.setQtyOnHand(qtyOnHand);
                batchDAO.update(batch);
                orderDetailsDAO.delete(o.getId());
            }
        }
        return orderDAO.delete(id);
    }

    @Override
    public boolean update(Orders t) throws Exception {
        return orderDAO.update(t);
    }

    @Override
    public Orders search(int id) throws Exception {
        return orderDAO.search(id);
    }

    @Override
    public List<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public int addOrder(OrderDTO orderDTO) throws Exception {
        int count = 0;
        Orders orders = new Orders();
        Set<OrderDetails> all = orderDTO.getOrderDetails();
        orders.setDate(orderDTO.getDate());
        orders.setTime(orderDTO.getTime());
        orders.setSubTot(orderDTO.getSubTot());
        orders.setTotal(orderDTO.getTotal());
        orders.setDiscounts(orderDTO.getDiscounts());
        int addOrder = orderDAO.addOrder(orders);
        Orders searchedOrder = orderDAO.search(addOrder);
        for (OrderDetails o : all) {
            double orderOTY = o.getOrderOTY();
            Batch b = o.getBatch();
            double qtyOnHand = b.getQtyOnHand();
            double updateQty = qtyOnHand - orderOTY;
            b.setQtyOnHand(updateQty);
            batchDAO.update(b);
            o.setBatch(b);
            o.setOrders(searchedOrder);
            orderDetailsDAO.add(o);
            count++;

        }
        if (all.size() == count) {
            return addOrder;
        } else {
            return -1;
        }
    }

    @Override
    public List<Orders> getTodayTransaction(LocalDate date) throws Exception {
        return orderDAO.getTodayTransaction(date);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(int id) throws Exception {
        return orderDetailsDAO.getOrderDetailsByOrderID(id);
    }

    @Override
    @Transactional
    public boolean deleteOrderDetail(int id,Orders s,int batchId,double oQty) throws Exception {
        Batch search = batchDAO.search(batchId);
        double qtyOnHand = search.getQtyOnHand();
        qtyOnHand=qtyOnHand+oQty;
        search.setQtyOnHand(qtyOnHand);
        batchDAO.update(search);
        orderDAO.update(s);
        return orderDetailsDAO.delete(id);
    }

}
