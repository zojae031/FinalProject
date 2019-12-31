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

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Manage System");

        startPnl = new JPanel();
        startPnl.setLayout(new BorderLayout());
        add(startPnl);


        //updateSelectedLists();
        //updateTotalMoney(new String("money"));
        //updateInsertMoney(new String("money"));
        //updateChangesMoney(new String("money"));


        showAdminDialog();
        setVisible(true);




    }


    @Override
    public void updateItemLists(Vector<ItemDao> selectedItems) {
        itemListPnl = new JPanel();
        JPanel leftPnl = new JPanel();
        leftPnl.setLayout(new BorderLayout());
        startPnl.add(leftPnl, BorderLayout.CENTER);

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
        leftPnl.add(itemListPnl, BorderLayout.CENTER);

    }

    @Override
    public void updateSelectedLists(Vector<ItemDao> selectedItems) { // 선택된 상품 목록
        selectedListPnl = new JPanel();

        JLabel lblSelectedItem = new JLabel();
        selectedListPnl.add(lblSelectedItem);
        add(selectedListPnl);
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
