package client.ui.userview;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ItemInfoPnl extends JPanel {
    ProductModel productModel;
    public JButton btnItem = new JButton();
    JLabel lblItemPrice = new JLabel();
    JLabel lblItemName = new JLabel();
    public int itemIndex;


    public ItemInfoPnl(ProductModel productModel, int index) {
        setPreferredSize(new Dimension(100, 70));
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        btnItem.setText(Integer.toString(index));
        //btnItem.setPreferredSize(new Dimension(100,50));
        lblItemPrice.setText(String.valueOf(productModel.PrPrice));
        lblItemName.setText(productModel.PrName);
        itemIndex = index;

        add(btnItem);
        add(lblItemName);
        add(lblItemPrice);

    }

    public void addListener(ActionListener listener) {
        btnItem.addActionListener(listener);
    }

}