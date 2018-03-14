/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.view;

import com.alpha.config.Context;
import com.alpha.service.custom.OrderService;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Harindu.sul
 */
public class FastMoveItemsFrame extends javax.swing.JFrame {

    private AbstractApplicationContext context;
    private DefaultTableCellRenderer centerRenderer;

    public FastMoveItemsFrame() {
        initComponents();

        this.context = Context.getInstance();
        this.centerRenderer = new DefaultTableCellRenderer();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        MovedItemTable = new javax.swing.JTable();
        allAtThisTimeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fast Moved Items");

        MovedItemTable.setAutoCreateRowSorter(true);
        MovedItemTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MovedItemTable.setForeground(new java.awt.Color(51, 51, 51));
        MovedItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Sold Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MovedItemTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        MovedItemTable.setRowHeight(28);
        MovedItemTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(MovedItemTable);

        allAtThisTimeBtn.setBackground(new java.awt.Color(51, 51, 51));
        allAtThisTimeBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        allAtThisTimeBtn.setForeground(new java.awt.Color(255, 255, 255));
        allAtThisTimeBtn.setText("All At This Time");
        allAtThisTimeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allAtThisTimeBtnActionPerformed(evt);
            }
        });
        allAtThisTimeBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                allAtThisTimeBtnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(allAtThisTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(allAtThisTimeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void allAtThisTimeBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_allAtThisTimeBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            allAtThisTimeBtn.doClick();
        }
    }//GEN-LAST:event_allAtThisTimeBtnKeyPressed

    private void allAtThisTimeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allAtThisTimeBtnActionPerformed
        setAllMovedQtyAtThisTime();
    }//GEN-LAST:event_allAtThisTimeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FastMoveItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FastMoveItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FastMoveItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FastMoveItemsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FastMoveItemsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MovedItemTable;
    private javax.swing.JButton allAtThisTimeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setAllMovedQtyAtThisTime() {
        OrderService orderService = (OrderService) context.getBean("OrderService");
        try {
            HashMap<String, Double> map = orderService.getPassMoveItems();
            if (map != null) {
                DefaultTableModel m = (DefaultTableModel) MovedItemTable.getModel();
                int rowCount = m.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    m.removeRow(i);
                }
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    m.addRow(new Object[]{
                        key,
                        map.get(key) + "0"
                    });
                }
                MovedItemTable.setModel(m);
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                MovedItemTable.setDefaultRenderer(String.class, centerRenderer);
            } else {
                JOptionPane.showMessageDialog(this, "No such a item moved found");
            }

        } catch (Exception ex) {
            Logger.getLogger(FastMoveItemsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setBetWeenTowDaysMovedItem() {
    }
}