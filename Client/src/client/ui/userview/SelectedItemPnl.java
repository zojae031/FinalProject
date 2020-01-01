package client.ui.userview;

import client.data.dao.ProductModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SelectedItemPnl extends JPanel {

    JPanel itemNameAndMoneyPnl = new JPanel();
    JLabel lblSelectedItemName = new JLabel();
    JLabel lblSelectedItemPrice = new JLabel();
    JPanel itemQuantityPnl = new JPanel();
    public JButton btnMinus = new JButton("-"), btnPlus = new JButton("+"), btnX = new JButton("x");
    public int itemCount = 1;
    JLabel lblItemQuantity = new JLabel(Integer.toString(itemCount));
    public ProductModel productModel;

    public SelectedItemPnl(ProductModel productModel) {
        setBounds(10, 10, 370, 50);
        this.productModel = productModel;

        itemNameAndMoneyPnl.setBounds(10, 10, 180, 50);
        itemNameAndMoneyPnl.setBackground(Color.pink);
        itemNameAndMoneyPnl.setLayout(new BorderLayout());

        lblSelectedItemName.setText(productModel.PrName);
        lblSelectedItemName.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        lblSelectedItemPrice.setText(Integer.toString(3));
        lblSelectedItemPrice.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        itemNameAndMoneyPnl.add(lblSelectedItemName, BorderLayout.CENTER);
        itemNameAndMoneyPnl.add(lblSelectedItemPrice, BorderLayout.LINE_END);


        itemQuantityPnl.setBounds(190, 10, 100, 50);
        itemQuantityPnl.setBackground(Color.magenta);
        itemQuantityPnl.setLayout(new GridLayout(1, 4));

        itemQuantityPnl.add(btnMinus);
        itemQuantityPnl.add(lblItemQuantity);
        itemQuantityPnl.add(btnPlus);
        itemQuantityPnl.add(btnX);

        add(itemNameAndMoneyPnl);
        add(itemQuantityPnl);

    }

    public void addListener(ActionListener listener) {
        btnMinus.addActionListener(listener);
        btnPlus.addActionListener(listener);
        btnX.addActionListener(listener);
    }

}
