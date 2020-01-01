package client.ui.userview;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserViewImpl implements UserView {

    // TODO: 2019-12-31  Vector<ProductModel> productModels = ;


    public UserViewImpl() {
        setStartPnl();

    }

    public void setStartPnl() {
        // client View 전체를 담는 패널
        startPnl.setLayout(null);
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
        btnPay.setBounds(830, 600, 100, 50);
        startPnl.add(btnPay);

        // todo add(startPnl);
    }


    @Override
    public void updateItemLists(Vector<ProductModel> lists) {
        itemLists.clear();
        itemListPnl.removeAll();
        for (int i = 0; i < lists.size(); i++) {
            ItemInfoPnl item = new ItemInfoPnl(lists.get(i), i);
            if (!item.productModel.IsSell) {
                item.btnItem.setBackground(Color.magenta);
                item.btnItem.setEnabled(false);
            }
            itemLists.add(item);
            itemListPnl.add(item);
        }
        itemListPnl.updateUI();
    }


    @Override
    public void updateSelectedLists(ProductModel productModel) { // 선택된 상품 목록
        //TODO
        // 0. layout 배치 필요
        // 1. 없으면 추가 2. 기존에 있으면 update하는 로직 필요 (엎고 다시)
        // 3. SelectedItemPnl 안에 productModel에 isShell이 false면 증가 못하게 바꾸는 코드 필요
        // 4. lblItemQuantity 가 1보다 아래로 안내려가도록 - 버튼 disable 시키는 코드 필요

        SelectedItemPnl item = new SelectedItemPnl(productModel);
        selectedItemLists.add(item);
        selectedListPnl.add(item);
        selectedListPnl.updateUI();
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
    public void showUserInterface() {

    }

    @Override
    public synchronized void addListener(ActionListener listener) {
        btnAdminClient.addActionListener(listener); // Manager <-> User Switch Button
        btnPay.addActionListener(listener); // 구매 버튼
    }

    @Override
    public synchronized void addItemListListener(ActionListener listener) {
        itemLists.forEach(item -> {
            item.addListener(listener);
        });
    }

    @Override
    public synchronized void addSelectedItemListener(ActionListener listener) {
        selectedItemLists.forEach(selectedItem -> {
            selectedItem.addListener(listener);
        });
    }
}
