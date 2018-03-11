/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.utils;

import com.alpha.config.Context;
import com.alpha.dto.OrderDTO;
import com.alpha.model.OrderDetails;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Harindu.sul
 */
public class BillPrintable implements Printable {

    private OrderDTO orderDTO;
    private AbstractApplicationContext context;

    public BillPrintable(OrderDTO o) {
        this.orderDTO = o;
        this.context = Context.getInstance();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;

            double width = pageFormat.getImageableWidth();

            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            ////////// code by alqama//////////////
            FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));
            //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength = metrics.stringWidth("000");
            int amtLength = metrics.stringWidth("000000");
            int qtyLength = metrics.stringWidth("00000");
            int priceLength = metrics.stringWidth("000000");
            int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;

            //    int idPosition=0;
            //    int productPosition=idPosition + idLength + 2;
            //    int pricePosition=productPosition + prodLength +10;
            //    int qtyPosition=pricePosition + priceLength + 2;
            //    int amtPosition=qtyPosition + qtyLength + 2;
            int productPosition = 0;
            int discountPosition = prodLength + 5;
            int pricePosition = discountPosition + idLength + 10;
            int qtyPosition = pricePosition + priceLength + 4;
            int amtPosition = qtyPosition + qtyLength;

            try {
                /*Draw Header*/
                int y = 20;
                int yShift = 10;
                int headerRectHeight = 15;
                int headerRectHeighta = 40;

                /**/
                Set<OrderDetails> all = orderDTO.getOrderDetails();

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 12, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 10));
                g2d.drawString("          PRIYANKARA STORES              ", 12, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 12, y);
                y += headerRectHeight;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("   Order ID : " + orderDTO.getId() + "  ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("  Description  Price  Qty  Dis  Amount  ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 10, y);
                y += headerRectHeight;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                for (OrderDetails o : all) {
                    double comDiscount = o.getComDiscount();
                    double discount = o.getDiscount();
                    double r = comDiscount + discount;
                    double u = o.getUnitPrice();
                    double q = o.getOrderOTY();
                    double a = (u * q) - r;
                    g2d.drawString("   " + o.getDescription() + " ", 10, y);
                    y += yShift;
                    g2d.drawString("      (" + u + "0 * " + q + "0) - " + r + "0 = " + a + "0 ", 10, y);
                    y += yShift;
                }
                double total = orderDTO.getTotal();
                String t = total + "";

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  -------------------------------------", 10, y);
                y += yShift;
                double total1 = orderDTO.getTotal();
                String tttVal=total1+"0";
                String totSpaces = getTotSpaces(tttVal.length());
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("   SUB TOTAL  :"+totSpaces+total1+"0 ", 10, y);
                y += yShift;
                double dd = orderDTO.getDiscounts();
                String ddVal=dd+"0";
                String totSpacesForDis = getTotSpaces(ddVal.length());
                g2d.drawString("   DISCOUNTS  :"+totSpacesForDis+dd+ "0 ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 10, y);
                y += yShift;
                double tt = orderDTO.getSubTot();
                String ttVal=tt+"0";
                String totSpacesForSub = getTotSpaces(ttVal.length()+3);
                g2d.setFont(new Font("Monospaced", Font.BOLD, 10));
                g2d.drawString("  GROSS TOTAL:"+totSpacesForSub+tt+ "0 ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("           "+orderDTO.getDate()+"  "+orderDTO.getTime().replace("-", ":") , 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ---------------------------------------", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("                Contact Us                 ", 10, y);
                y += yShift;
                g2d.drawString("         0713434180 / 0774205874          ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ***************************************", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.BOLD, 9));
                g2d.drawString("       THANKS TO VISIT OUR STORE.        ", 10, y);
                y += yShift;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("  ***************************************", 10, y);
                y += yShift;

//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
            } catch (Exception r) {
                r.printStackTrace();
            }

            result = PAGE_EXISTS;
        }
        return result;

    }

    private String getTotSpaces(int length) {
        switch(length){
                case 4:return "                   ";
                case 5:return "                  ";
                case 6:return "                 ";
                case 7:return "                ";
                case 8:return "               ";
                case 9:return "              ";
                case 10:return "            ";
                case 11:return "           ";
                case 12:return "          ";
                default:return "";
            }
    }
}
