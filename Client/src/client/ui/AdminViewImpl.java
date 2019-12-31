package client.ui;

import javax.swing.*;
import java.awt.*;

public class AdminViewImpl extends JFrame implements AdminView {

    protected CardLayout cardLayout;
    protected Container tab;
    protected JPanel btnAdminWhatToDo;

    public AdminViewImpl() {
        setTitle("Manage");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);


        setBtnAdminWhatToDo();
        tab = new JPanel();
        cardLayout = new CardLayout();
        tab.setLayout(cardLayout);

        setVisible(true);
    }

    public void setBtnAdminWhatToDo() { // 판매총액, 재고현황, 재고구매, 제품추가
        JPanel adminStartPanel = new JPanel();
        adminStartPanel.setLayout(new BorderLayout());

        btnAdminWhatToDo = new JPanel();
        btnAdminWhatToDo.setLayout(new GridLayout(2, 2, 50, 50));
        btnAdminWhatToDo.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        JButton btnTotalMoney = new JButton("Item Total Money");
        JButton btnCurrentItems = new JButton("Current Items");
        JButton btnBuyItem = new JButton("Buy Items");
        JButton btnAddItem = new JButton("Add Items");

        btnTotalMoney.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnCurrentItems.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnBuyItem.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnAddItem.setFont(new Font("맑은고딕", Font.PLAIN, 30));

        btnAdminWhatToDo.add(btnTotalMoney);
        btnAdminWhatToDo.add(btnCurrentItems);
        btnAdminWhatToDo.add(btnBuyItem);
        btnAdminWhatToDo.add(btnAddItem);
        adminStartPanel.add(btnAdminWhatToDo, BorderLayout.CENTER);

        // Admin <-> User Btn
        JPanel AdminClientButtonPnl = new JPanel();
        AdminClientButtonPnl.setLayout(new BorderLayout());
        JButton btnAdminClient = new JButton();
        btnAdminClient.setText("User");
        btnAdminClient.setBounds(0, 0, 100, 30);
        AdminClientButtonPnl.add(btnAdminClient, BorderLayout.WEST);
        adminStartPanel.add(AdminClientButtonPnl, BorderLayout.NORTH);

        add(adminStartPanel);
    }

}