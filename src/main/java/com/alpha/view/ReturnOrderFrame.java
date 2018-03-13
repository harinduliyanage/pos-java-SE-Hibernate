/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.view;

import com.alpha.config.Context;
import com.alpha.model.OrderDetails;
import com.alpha.model.Orders;
import com.alpha.model.User;
import com.alpha.service.custom.OrderService;
import com.alpha.service.custom.UserService;
import com.alpha.utils.Validation;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Harindu.sul
 */
public class ReturnOrderFrame extends javax.swing.JFrame {

    private AbstractApplicationContext context;

    public ReturnOrderFrame() {
        initComponents();
        orderIdTxt2.requestFocusInWindow();
        this.context = Context.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        orderIdTxt2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        updateOrderTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        AdminPassTxt22 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();
        timeLable = new javax.swing.JLabel();
        totalLable = new javax.swing.JLabel();
        discountLable = new javax.swing.JLabel();
        subTotLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Enter Order ID");

        orderIdTxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderIdTxt2KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Admin Password");

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        updateOrderTable.setAutoCreateRowSorter(true);
        updateOrderTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Details ID", "Order ID", "Batch ID", "Date", "Time", "Description", "Store Dis", "Com Dis", "Unit Price", "Order Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        updateOrderTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updateOrderTable.setGridColor(new java.awt.Color(255, 255, 255));
        updateOrderTable.setRowHeight(28);
        updateOrderTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        updateOrderTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateOrderTableKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(updateOrderTable);

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Order");
        btnDelete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnDeleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnDeleteFocusLost(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        AdminPassTxt22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminPassTxt22KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Ordered Date  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Ordered Time  :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Total               :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Discounts       :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Sub Total       :");

        dateLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLable.setForeground(new java.awt.Color(51, 51, 51));

        timeLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        timeLable.setForeground(new java.awt.Color(51, 51, 51));

        totalLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLable.setForeground(new java.awt.Color(51, 51, 51));

        discountLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        discountLable.setForeground(new java.awt.Color(51, 51, 51));

        subTotLable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subTotLable.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AdminPassTxt22, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(orderIdTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discountLable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subTotLable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderIdTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPassTxt22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(discountLable, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subTotLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void orderIdTxt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderIdTxt2KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            updateOrderTable.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_END) {
            btnDelete.requestFocusInWindow();
        }

    }//GEN-LAST:event_orderIdTxt2KeyPressed

    private void AdminPassTxt22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminPassTxt22KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            setOrder();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            updateOrderTable.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_END) {
            btnDelete.requestFocusInWindow();
        }
    }//GEN-LAST:event_AdminPassTxt22KeyPressed

    private void updateOrderTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateOrderTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            updateOrderTable.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_END) {
            btnDelete.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            orderIdTxt2.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            deleteSelectedItemOnOrder();
        }
    }//GEN-LAST:event_updateOrderTableKeyPressed

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            updateOrderTable.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_END) {
            btnDelete.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            orderIdTxt2.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void btnDeleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDeleteFocusGained
        btnDelete.setBackground(Color.white);
        btnDelete.setForeground(new Color(204, 0, 0));
    }//GEN-LAST:event_btnDeleteFocusGained

    private void btnDeleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDeleteFocusLost
        btnDelete.setBackground(new Color(204, 0, 0));
        btnDelete.setForeground(Color.white);
    }//GEN-LAST:event_btnDeleteFocusLost

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteOrder();
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AdminPassTxt22;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel dateLable;
    private javax.swing.JLabel discountLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField orderIdTxt2;
    private javax.swing.JLabel subTotLable;
    private javax.swing.JLabel timeLable;
    private javax.swing.JLabel totalLable;
    private javax.swing.JTable updateOrderTable;
    // End of variables declaration//GEN-END:variables

    private void deleteSelectedItemOnOrder() {
        DefaultTableModel m = (DefaultTableModel) updateOrderTable.getModel();
        int rowCount = m.getRowCount();
        if (rowCount != -1) {
            int selectedRow = updateOrderTable.getSelectedRow();
            if (selectedRow != -1) {
                Object valueAt0 = m.getValueAt(selectedRow, 0);
                Object valueAt1 = m.getValueAt(selectedRow, 1);
                Object valueAt2 = m.getValueAt(selectedRow, 2);
                Object valueAt6 = m.getValueAt(selectedRow, 6);
                Object valueAt7 = m.getValueAt(selectedRow, 7);
                Object valueAt8 = m.getValueAt(selectedRow, 8);
                Object valueAt9 = m.getValueAt(selectedRow, 9);
                int batchId = Integer.parseInt(valueAt2.toString());
                double storeDis = Double.parseDouble(valueAt6.toString());
                double comDis = Double.parseDouble(valueAt7.toString());
                double unitPrice = Double.parseDouble(valueAt8.toString());
                double qty = Double.parseDouble(valueAt9.toString());
                double res = comDis + storeDis;
                double price = unitPrice * qty;
                String orderDetails = valueAt0.toString();
                int oDID = Integer.parseInt(orderDetails);
                OrderService orderService = (OrderService) context.getBean("OrderService");
                try {
                    Orders s = orderService.search(Integer.parseInt(valueAt1.toString()));
                    double oldDis = s.getDiscounts();
                    double total = s.getTotal();
                    double subTot = s.getSubTot();
                    total = total - price;
                    oldDis = oldDis - res;
                    subTot = total - oldDis;
                    s.setTotal(total);
                    s.setDiscounts(oldDis);
                    s.setSubTot(subTot);
                    if (rowCount == 1) {
                        orderService.deleteOrderDetail(oDID, s, batchId, qty);
                        orderService.delete(Integer.parseInt(valueAt1.toString()));
                        setOrder();
                    } else {
                        orderService.deleteOrderDetail(oDID, s, batchId, qty);
                        setOrder();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ReturnOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Order Detail..");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Get Order First");
            dateLable.setText("");
            timeLable.setText("");
            totalLable.setText("");
            discountLable.setText("");
            subTotLable.setText("");
        }
    }

    private void setOrder() {
        String pass = AdminPassTxt22.getText();
        OrderService orderService = (OrderService) context.getBean("OrderService");
        UserService userService = (UserService) context.getBean("UserService");
        try {
            User u = userService.getUserByTypeAndPassword("Admin", pass);
            if (u != null) {
                String order = orderIdTxt2.getText();
                boolean v1 = Validation.validateEmptyTextFeald(order);
                if (!v1) {
                    int orderId = Integer.parseInt(order);
                    Orders search = orderService.search(orderId);
                    if (search != null) {
                        dateLable.setText(search.getDate() + "");
                        timeLable.setText(search.getTime() + "");
                        totalLable.setText(search.getTotal() + "0");
                        discountLable.setText(search.getDiscounts() + "0");
                        subTotLable.setText(search.getSubTot() + "0");
                        List<OrderDetails> all = orderService.getOrderDetailsByOrderId(orderId);
                        if (all != null) {
                            DefaultTableModel m = (DefaultTableModel) updateOrderTable.getModel();
                            int rowCount = m.getRowCount();
                            for (int i = rowCount - 1; i >= 0; i--) {
                                m.removeRow(i);
                            }

                            for (OrderDetails o : all) {
                                m.addRow(new Object[]{
                                    o.getId() + "",
                                    orderId + "",
                                    o.getBatch().getId() + "",
                                    search.getDate() + "",
                                    search.getTime() + "",
                                    o.getDescription(),
                                    o.getDiscount() + "0",
                                    o.getComDiscount() + "0",
                                    o.getUnitPrice() + "0",
                                    o.getOrderOTY() + "0"
                                });
                            }
                            updateOrderTable.setModel(m);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Can not Found Order");
                        dateLable.setText("");
                        timeLable.setText("");
                        totalLable.setText("");
                        discountLable.setText("");
                        subTotLable.setText("");
                        DefaultTableModel m = (DefaultTableModel) updateOrderTable.getModel();
                        int rowCount = m.getRowCount();
                        for (int i = rowCount - 1; i >= 0; i--) {
                            m.removeRow(i);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter Order ID..");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Admin Password Incorect..");
                DefaultTableModel m = (DefaultTableModel) updateOrderTable.getModel();
                int rowCount = m.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    m.removeRow(i);
                }
                dateLable.setText("");
                timeLable.setText("");
                totalLable.setText("");
                discountLable.setText("");
                subTotLable.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void deleteOrder() {
        OrderService orderService = (OrderService) context.getBean("OrderService");
        DefaultTableModel m = (DefaultTableModel) updateOrderTable.getModel();
        int rowCount = m.getRowCount();
        if(rowCount>-1){
            Object valueAt11 = m.getValueAt(0, 1);
            try {
            for (int i = rowCount - 1; i >= 0; i--) {
                Object valueAt0 = m.getValueAt(i, 0);
                Object valueAt1 = m.getValueAt(i, 1);
                Object valueAt2 = m.getValueAt(i, 2);
                Object valueAt6 = m.getValueAt(i, 6);
                Object valueAt7 = m.getValueAt(i, 7);
                Object valueAt8 = m.getValueAt(i, 8);
                Object valueAt9 = m.getValueAt(i, 9);
                int batchId = Integer.parseInt(valueAt2.toString());
                double storeDis = Double.parseDouble(valueAt6.toString());
                double comDis = Double.parseDouble(valueAt7.toString());
                double unitPrice = Double.parseDouble(valueAt8.toString());
                double qty = Double.parseDouble(valueAt9.toString());
                double res = comDis + storeDis;
                double price = unitPrice * qty;
                String orderDetails = valueAt0.toString();
                int oDID = Integer.parseInt(orderDetails);
                Orders s = orderService.search(Integer.parseInt(valueAt1.toString()));
                double oldDis = s.getDiscounts();
                double total = s.getTotal();
                double subTot = s.getSubTot();
                total = total - price;
                oldDis = oldDis - res;
                subTot = total - oldDis;
                s.setTotal(total);
                s.setDiscounts(oldDis);
                s.setSubTot(subTot);
                if (rowCount == 1) {
                    orderService.deleteOrderDetail(oDID, s, batchId, qty);
                } else {
                    orderService.deleteOrderDetail(oDID, s, batchId, qty);
                }
            }
            orderService.delete(Integer.parseInt(valueAt11.toString()));
            setOrder();
            dateLable.setText("");
            timeLable.setText("");
            totalLable.setText("");
            discountLable.setText("");
            subTotLable.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ReturnOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
        }
    }
}
