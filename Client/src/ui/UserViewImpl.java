package ui;


import data.dao.ItemDao;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UserViewImpl extends JFrame implements UserView {
    JPanel startPnl, itemListPnl, selectedListPnl;
    JButton btnItem;
    JTextField tfInsertMoney, tfChange, tfTotalMoney;

    public UserViewImpl() {
        setResizable(false);
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Manage System");

        startPnl = new JPanel();
        startPnl.setLayout(null);
        add(startPnl);
        updateItemLists();


        selectedListPnl = new JPanel();
        selectedListPnl.setLayout(null);
        selectedListPnl.setPreferredSize(new Dimension(300,500));
        selectedListPnl.setBounds(650,50,300,500);

        startPnl.add(selectedListPnl);
        updateSelectedLists();

        // TODO: 2019-12-31 인자 값 바꾸기 
        updateTotalMoney("money");
        updateInsertMoney("money");
        updateChangesMoney("money");


        showAdminDialog();
        setVisible(true);


    }


    @Override
    public void updateItemLists() {
        itemListPnl = new JPanel();
        itemListPnl.setLayout(new GridLayout(4, 4, 15, 15));

        JScrollPane scroll = new JScrollPane(itemListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        for (int i = 0; i < 17; i++) {
            btnItem = new JButton(Integer.toString(i));
            //btnItem.setText(); // TODO
            //btnItem.setPreferredSize(new Dimension(10, 10));

            itemListPnl.add(btnItem);
        }
        itemListPnl.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        itemListPnl.setBounds(0,50,600,500);
        startPnl.add(itemListPnl);

    }

    @Override
    public void updateSelectedLists() { // 선택된 상품 목록
        JLabel lblSelectedItem = new JLabel();
        lblSelectedItem.setText("김치찌개");
        //for(int i=0; i<selectedItem.size();i++)
        lblSelectedItem.setBounds(10,40,100,50);
        selectedListPnl.add(lblSelectedItem);
    }

    @Override
    public void updateInsertMoney(String money) { // 투입 금액
        tfInsertMoney = new JTextField();
        tfInsertMoney.setText(money); // TODO 라벨 붙이기

        selectedListPnl.add(tfInsertMoney);
    }

    @Override
    public void updateChangesMoney(String money) { // 거스름돈
        tfChange = new JTextField();
        tfChange.setText(money);
        selectedListPnl.add(tfChange);
    }

    @Override
    public void updateTotalMoney(String money) { // TODO 총 금액
        tfTotalMoney = new JTextField();
        tfTotalMoney.setText(money);
        selectedListPnl.add(tfTotalMoney);
    }

    @Override
    public void showAdminDialog() { // 관리자 사용자 스위치버튼, 메뉴선택, 재고관리 등 제목라벨 패널
        JPanel setBtnAdminPnl = new JPanel();
        setBtnAdminPnl.setLayout(new BorderLayout());
        JButton btnAdminClient = new JButton();
        btnAdminClient.setText("Manager");
        JLabel lblWhatToDo = new JLabel("Select Item");
        setBtnAdminPnl.add(btnAdminClient, BorderLayout.LINE_START);
        setBtnAdminPnl.add(lblWhatToDo, BorderLayout.CENTER);
    }

    @Override
    public void showUserInterface() {

    }


}
