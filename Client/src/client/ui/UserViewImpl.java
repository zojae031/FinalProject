package client.ui;


import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UserViewImpl extends JFrame implements UserView {
    JPanel startPnl, itemListPnl, selectedListPnl;
    JButton btnItem;
    JTextField tfInsertMoney, tfChange, tfTotalMoney;
    JLabel lblInsertMoney, lblTotalMoney, lblChangeMoney;

    public UserViewImpl() {
        setResizable(false);
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Manage System");

        setStartPnl();



        showAdminDialog();
        setVisible(true);


    }

    public void setStartPnl() {
        startPnl = new JPanel(); // client View 전체를 담는 패널
        startPnl.setLayout(null);
        add(startPnl);

        itemListPnl = new JPanel();
        itemListPnl.setLayout(new GridLayout(4, 5, 15, 15));
        itemListPnl.setBackground(Color.orange);
        JScrollPane scroll = new JScrollPane(itemListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // ItemListPnl w 650(+15), h 600(+50)
        scroll.setBounds(15, 50, 650, 600);
        startPnl.add(scroll);

        // TODO: 2019-12-31 for test
        updateItemListss();



        // selectedListPnl w 315, h 500
        selectedListPnl = new JPanel();
        selectedListPnl.setLayout(null);
        selectedListPnl.setBackground(Color.green);
        JScrollPane selectedListPnlScroll = new JScrollPane(selectedListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        selectedListPnlScroll.setBounds(650, 50, 315, 300);
        startPnl.add(selectedListPnlScroll);

        // total money
        JPanel totalMoneyPnl = new JPanel();
        totalMoneyPnl.setLayout(new BorderLayout());
        totalMoneyPnl.setBounds(670, 350, 315, 70);
        lblTotalMoney = new JLabel("총 금액 ");
        totalMoneyPnl.add(lblTotalMoney, BorderLayout.CENTER);
        totalMoneyPnl.setBackground(Color.lightGray);
        
        // insert money
        JPanel insertMoneyPnl = new JPanel();
        insertMoneyPnl.setLayout(new BorderLayout());
        insertMoneyPnl.setBounds(670, 450, 315, 70);
        lblInsertMoney = new JLabel("투입 금액 ");
        insertMoneyPnl.add(lblInsertMoney, BorderLayout.CENTER);
        insertMoneyPnl.setBackground(Color.lightGray);
        
        // change money
        JPanel changeMoneyPnl = new JPanel();
        changeMoneyPnl.setLayout(new BorderLayout());
        changeMoneyPnl.setBounds(670, 530, 315, 100);
        lblChangeMoney = new JLabel("거스름돈 ");
        changeMoneyPnl.add(lblChangeMoney, BorderLayout.CENTER);
        changeMoneyPnl.setBackground(Color.lightGray);
        
        startPnl.add(totalMoneyPnl);
        startPnl.add(insertMoneyPnl);
        startPnl.add(changeMoneyPnl);

        // TODO: 2019-12-31 for test
        updateTotalMoney("10000");
        updateInsertMoney("3500");
        updateChangesMoney("6500");
        updateSelectedListss();
    }

    @Override
    public void updateItemLists(Vector<ProductModel> lists) {
        /*for (int i = 0; i < lists.size(); i++) {
            setItemInfoPnl item = new setItemInfoPnl(lists.get(i).PrName, Integer.toString(lists.get(i).PrPrice), i);
            item.addItemInfoPnl();
        }*/
    }
    public void updateItemListss(){
        // TODO: 2019-12-31
        for (int i = 0; i < 27; i++) {
            setItemInfoPnl item = new setItemInfoPnl("menu", "3,500",i);
            item.addItemInfoPnl();
        }


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

    // TODO: 2019-12-31 기능만 따로 빼기
    @Override
    public void updateSelectedLists(Vector<ProductModel> selectedItem, int i) { // 선택된 상품 목록
    }

    // TODO: for test
    public void updateSelectedListss(){
        JPanel insertMoneyPnl = new JPanel(); // 선택되는 순간 만들어짐
        // 선택된 아이템 각각 w:180 h:100 todo 버튼을 이 옆에
        insertMoneyPnl.setBounds(10,30,180, 100);
        insertMoneyPnl.setBackground(Color.pink);
        insertMoneyPnl.setLayout(new BorderLayout());

        JLabel lblSelectedItemName = new JLabel();
        JLabel lblSelectedItemPrice = new JLabel();
// todo       lblSelectedItemName.setText(selectedItem.get(i).PrName);
        lblSelectedItemName.setText("menu1");
 //todo       lblSelectedItemPrice.setText(Integer.toString(selectedItem.get(i).PrPrice));
        lblSelectedItemName.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        lblSelectedItemPrice.setText("3550");
        lblSelectedItemPrice.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        insertMoneyPnl.add(lblSelectedItemName, BorderLayout.CENTER);
        insertMoneyPnl.add(lblSelectedItemPrice, BorderLayout.LINE_END);

        selectedListPnl.add(insertMoneyPnl);
    }

    // todo 제거 - > view 쪽에서 list를 가지고 있어야 붙이고 지우고,,

    @Override
    public void updateInsertMoney(String money) { // 투입 금액
        lblInsertMoney.setText(lblInsertMoney.getText() + money);
    }

    @Override
    public void updateChangesMoney(String money) { // 거스름돈
        lblChangeMoney.setText(lblChangeMoney.getText() + money);
    }

    @Override
    public void updateTotalMoney(String money) { // TODO 총 금액
        lblTotalMoney.setText(lblTotalMoney.getText() + money);
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




}
