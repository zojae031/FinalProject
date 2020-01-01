package client.ui;

import client.ui.adminview.AdminView;
import client.ui.userview.UserView;

import javax.swing.*;
import java.awt.*;

public class CardLayoutMain extends JFrame {
    CardLayout cardLayout;
    Container tab;
    public UserView userView;
    public AdminView adminView;

    public CardLayoutMain(UserView userView, AdminView adminView) {
        cardLayout = new CardLayout();
        tab = new JPanel();
        tab.setSize(1100, 700);
        tab.setLayout(cardLayout);

        this.userView = userView;
        this.adminView = adminView;

        tab.add(UserView.startPnl, "start");
        tab.add(AdminView.adminStartPanel, "admin");

        cardLayout.show(tab, "start");

        add(tab, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);
    }

    public void changeDialog(String panelName) {
        cardLayout.show(tab, panelName);
    }

}
