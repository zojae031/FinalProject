package client.ui.userview;


import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserViewImpl extends JFrame implements UserView {


    // TODO: 2019-12-31  Vector<ProductModel> productModels = ;

    public UserViewImpl() {
        setResizable(false);
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Manage System");

        setStartPnl();

        showAdminDialog();

        setVisible(true);

        updateTotalMoney("10000");
        updateInsertMoney("3500");
        updateChangesMoney("6500");
        updateSelectedListss();
    }

    public void setStartPnl() {
        // client View 전체를 담는 패널
        startPnl.setLayout(null);
        add(startPnl);

        // Manager <-> User Button
        btnAdminClient.setText("Manager");
        btnAdminClient.setBounds(0, 0, 100, 30);
        startPnl.add(btnAdminClient);
        JLabel lblWhatToDo = new JLabel("Select Item");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.BOLD, 20));
        lblWhatToDo.setBounds(400, 10, 200, 20);
        startPnl.add(lblWhatToDo);


        itemListPnl.setLayout(new GridLayout(4, 3, 15, 15));
        itemListPnl.setBackground(Color.orange);
        JScrollPane scroll = new JScrollPane(itemListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // ItemListPnl w 650(+15), h 600(+50)
        scroll.setBounds(15, 50, 650, 600);
        startPnl.add(scroll);


        // selectedListPnl w 315, h 500
        selectedListPnl.setLayout(null);
        selectedListPnl.setBackground(Color.green);
        JScrollPane selectedListPnlScroll = new JScrollPane(selectedListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        selectedListPnlScroll.setBounds(670, 50, 400, 300);
        startPnl.add(selectedListPnlScroll);

        // total money
        JPanel totalMoneyPnl = new JPanel();
        totalMoneyPnl.setLayout(new BorderLayout());
        totalMoneyPnl.setBounds(670, 360, 400, 70);
        totalMoneyPnl.add(lblTotalMoney, BorderLayout.CENTER);
        totalMoneyPnl.setBackground(Color.lightGray);

        // insert money
        JPanel insertMoneyPnl = new JPanel();
        insertMoneyPnl.setLayout(new BorderLayout());
        insertMoneyPnl.setBounds(670, 450, 400, 70);
        insertMoneyPnl.add(lblInsertMoney, BorderLayout.CENTER);
        insertMoneyPnl.setBackground(Color.lightGray);

        // change money
        JPanel changeMoneyPnl = new JPanel();
        changeMoneyPnl.setLayout(new BorderLayout());
        changeMoneyPnl.setBounds(670, 520, 400, 70);
        changeMoneyPnl.add(lblChangeMoney, BorderLayout.CENTER);
        changeMoneyPnl.setBackground(Color.lightGray);

        startPnl.add(totalMoneyPnl);
        startPnl.add(insertMoneyPnl);
        startPnl.add(changeMoneyPnl);


        // 구매 버튼
        btnPay.setBounds(780, 600, 100, 50);
        startPnl.add(btnPay);


    }


    @Override
    public void updateItemLists(Vector<ProductModel> lists) {
        lists.forEach(productModel -> System.out.println(productModel.PrCode + productModel.PrNumber + productModel.PrPrice + productModel.PrName + productModel.PrIngredient));
        for (int i = 0; i < lists.size(); i++) {
            ItemInfoPnl item = new ItemInfoPnl(lists.get(i), i);
            itemLists.add(item);
            itemListPnl.add(item);//
        }
        itemListPnl.updateUI();
    }


    @Override
    public void updateSelectedLists(Vector<String> selectedItemName) { // 선택된 상품 목록
    }

    // TODO: for test
    public void updateSelectedListss() {
        JPanel itemInsertPnl = new JPanel();
        itemInsertPnl.setBounds(10, 10, 370, 50);

        JPanel itemNameAndMoneyPnl = new JPanel(); // 선택되는 순간 만들어짐

        // TODO: itemNameAndMoneyPnl 이랑 itemQuantityPnl 위치 조정
        itemNameAndMoneyPnl.setBounds(10, 10, 180, 50);
        itemNameAndMoneyPnl.setBackground(Color.pink);
        itemNameAndMoneyPnl.setLayout(new BorderLayout());

        JLabel lblSelectedItemName = new JLabel();
        JLabel lblSelectedItemPrice = new JLabel();
        // todo      lblSelectedItemName.setText(selectedItem.get(i).PrName);
        lblSelectedItemName.setText("menu1");
        //todo       lblSelectedItemPrice.setText(Integer.toString(selectedItem.get(i).PrPrice));
        lblSelectedItemName.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        lblSelectedItemPrice.setText("3550");
        lblSelectedItemPrice.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        itemNameAndMoneyPnl.add(lblSelectedItemName, BorderLayout.CENTER);
        itemNameAndMoneyPnl.add(lblSelectedItemPrice, BorderLayout.LINE_END);


        JPanel itemQuantityPnl = new JPanel();
        itemQuantityPnl.setBounds(190, 10, 100, 50);
        itemQuantityPnl.setBackground(Color.magenta);
        itemQuantityPnl.setLayout(new GridLayout(1, 4));

        itemQuantityPnl.add(btnMinus);
        itemQuantityPnl.add(lblItemQuantity);
        itemQuantityPnl.add(btnPlus);
        itemQuantityPnl.add(btnX);

        itemInsertPnl.add(itemNameAndMoneyPnl);
        itemInsertPnl.add(itemQuantityPnl);
        selectedListPnl.add(itemInsertPnl);
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
    public void showAdminDialog() {


    }

    @Override
    public void showUserInterface() {

    }

    @Override
    public void addListener(ActionListener listener) {
        itemLists.forEach(item -> {
            item.addListener(listener);
        });
        btnAdminClient.addActionListener(listener); // Manager <-> User Switch Button
        btnPay.addActionListener(listener); // 구매 버튼
        btnMinus.addActionListener(listener); // selectedItem 수량 -
        btnPlus.addActionListener(listener); // selectedItem 수량 +
        btnX.addActionListener(listener); // selectedItem 삭제
    }


}
