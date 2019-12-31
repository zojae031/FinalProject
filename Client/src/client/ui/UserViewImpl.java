package client.ui;


import client.data.dao.ProductModel;

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

        startPnl = new JPanel(); // client View 전체를 담는 패널
        startPnl.setLayout(null);
        add(startPnl);
        updateItemLists();

        // selectedListPnl w 315, h 500
        selectedListPnl = new JPanel();
        selectedListPnl.setLayout(null);
        selectedListPnl.setBounds(650, 50, 315, 500);
        selectedListPnl.setBackground(Color.green);
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
    public void updateItemLists(Vector<ProductModel> lists) {
        itemListPnl = new JPanel();
        itemListPnl.setLayout(new GridLayout(4, 5, 15, 15));
        itemListPnl.setBackground(Color.orange);
        JScrollPane scroll = new JScrollPane(itemListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        for (int i = 0; i < lists.size(); i++) {
            setItemInfoPnl item = new setItemInfoPnl("Menu", "3,500원", i); // TODO: 2019-12-31 인자로 받아오기
            item.addItemInfoPnl();

        }

        // ItemListPnl w 650(+15), h 600(+50)
        scroll.setBounds(15, 50, 650, 600);
        startPnl.add(scroll);

    }

    @Override
    public void updateSelectedLists() { // 선택된 상품 목록
        // TODO: 2019-12-31 list3개, controller에 인덱스 넘겨주기

        JLabel lblSelectedItem = new JLabel();
        lblSelectedItem.setText("menu");
        lblSelectedItem.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        //for(int i=0; i<selectedItem.size();i++)
        lblSelectedItem.setBounds(50, 40, 100, 50);
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

        JButton btnAdminClient = new JButton();
        btnAdminClient.setText("Manager");
        btnAdminClient.setBounds(0, 0, 100, 30);
        startPnl.add(btnAdminClient);
        JLabel lblWhatToDo = new JLabel("Select Item");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.BOLD, 20));
        lblWhatToDo.setBounds(400, 10, 200, 20);
        startPnl.add(lblWhatToDo);
    }

    @Override
    public void showUserInterface() {

    }

    // 1개의 아이템 이름, 가격, 이미지 담고 있는 패널
    public class setItemInfoPnl { // TODO: 2019-12-31 parameter Vector ItemDao
        JPanel itemInfoPnl = new JPanel();
        JButton btnItem = new JButton();
        JLabel lblItemPrice = new JLabel();
        JLabel lblItemName = new JLabel();
        int itemIndex;


        public setItemInfoPnl(String itemName, String itemPrice, int index) {
            itemInfoPnl.setPreferredSize(new Dimension(100, 70));
            itemInfoPnl.setBackground(Color.CYAN);
            itemInfoPnl.setLayout(new BoxLayout(itemInfoPnl, BoxLayout.Y_AXIS));

            btnItem.setText(Integer.toString(index));
            //btnItem.setPreferredSize(new Dimension(100,50));
            lblItemPrice.setText(itemPrice);
            lblItemName.setText(itemName);
            itemIndex = index;

            itemInfoPnl.add(btnItem);
            itemInfoPnl.add(lblItemName);
            itemInfoPnl.add(lblItemPrice);

        }

        public void addItemInfoPnl() {
            itemListPnl.add(itemInfoPnl);
        }
    }


}
