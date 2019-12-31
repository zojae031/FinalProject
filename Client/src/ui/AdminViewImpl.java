package ui;

import javax.swing.*;
import java.awt.*;

public class AdminViewImpl extends JFrame implements AdminView {

    protected CardLayout cardLayout;
    protected Container tab;
    protected JPanel btnAdminWhatToDo;

    public AdminViewImpl() {
        setBtnAdminWhatToDo();
        tab = new JPanel();
        cardLayout = new CardLayout();
        tab.setLayout(cardLayout);


    }

    public void setBtnAdminWhatToDo() { // 판매총액, 재고현황, 재고구매, 제품추가
        btnAdminWhatToDo = new JPanel();
        btnAdminWhatToDo.setLayout(new GridLayout(2, 2));
        btnAdminWhatToDo.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        JButton btnTotalMoney = new JButton("Item Total Money");
        JButton btnCurrentItems = new JButton("Current Items");
        JButton btnBuyItem = new JButton("Buy Items");
        JButton btnAddItem = new JButton("Add Items");

        btnAdminWhatToDo.add(btnTotalMoney);
        btnAdminWhatToDo.add(btnCurrentItems);
        btnAdminWhatToDo.add(btnBuyItem);
        btnAdminWhatToDo.add(btnAddItem);


    }

}
