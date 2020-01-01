package client.ui.adminview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminViewImpl implements AdminView {
    JPanel tablePnl;
    JTable itemTable;
    // TODO: 제품 제고현황 example
    String columnNames[] =
            {"상품번호", "제품명", "제품가격", "판매 갯수", "총액"};
    Object rowData[][] =
            {
                    {1, "김밥", 1000, 3, 3000},
                    {2, "오믈렛", 3000, 4, 12000},
                    {3, "치킨마요", 4000, 1, 4000}};
    // TODO: 제품 재고현황 example
    String columnItemNames[] =
            {"상품번호", "재료명", "남은 수량"};
    Object rowItemData[][] =
            {
                    {1, "양파", "300g"},
                    {2, "마늘", "300g"},
                    {3, "파", "300g"}};
    // TODO: 재고 구매 example
    String columnIngredientNames[] =
            {"상품번호", "재료명", "재료 가격", "남은 수량"};
    Object rowIngredientData[][] =
            {
                    {1, "양파", 1000, "300g"},
                    {2, "마늘", 2000, "300g"},
                    {3, "파", 3000, "300g"}};
    JTable t = new JTable(rowData, columnNames);


    public AdminViewImpl() {
        /*setTitle("Manage");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);*/


        //***************************
        setBtnAdminWhatToDoPnl();
        //setTotalMoneyPnl();
        //setCurrentIngredients();
        //setBuyIngredients();

        //tab.add(adminStartPanel, "adminStart");
        //tab.add(totalMoneyPnl, "totalMoney");
        //tab.add(currentIngredientsPnl, "currentIngredients");
        //tab.add(buyIngredientsPnl, "buyIngredients");
        //***************************


        //AdminCardLayout.show(AdminTab, "adminStart");
        //this.add(AdminTab, BorderLayout.NORTH);


        //setVisible(true);

    }

    // 판매총액, 재고현황, 재고구매, 제품추가
    public void setBtnAdminWhatToDoPnl() {
        //adminStartPanel = new JPanel();
        adminStartPanel.setLayout(new BorderLayout());
        btnAdminWhatToDo.setLayout(new GridLayout(2, 2, 50, 50));
        btnAdminWhatToDo.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // 버튼 4개 생성


        // 버튼 set
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
        AdminClientButtonPnl.setLayout(new BorderLayout());
        btnAdminClient.setText("User");
        btnAdminClient.setBounds(0, 0, 100, 30);
        AdminClientButtonPnl.add(btnAdminClient, BorderLayout.WEST);
        adminStartPanel.add(AdminClientButtonPnl, BorderLayout.NORTH);

        //add(adminStartPanel);
    }


    public void setTotalMoneyPnl() {
        totalMoneyPnl.setLayout(null);
        lblWhatToDo.setText("Total Money");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        lblWhatToDo.setBounds(480, 10, 200, 30);

        //totalMoneyTable = setTotalMoneyTable();
        /*JScrollPane scroll = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/

        //scroll.setBounds(40, 70, 1000, 400);

        // 총매출

        totalSalesPnl.setBackground(Color.orange);
        totalSalesPnl.setBounds(40, 490, 1000, 70);
        totalSalesPnl.setLayout(null);

        lblTotalSales.setText("총 매출 ");
        lblTotalSales.setBounds(10, 5, 100, 50);
        lblTotalSales.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        lblTotalSalesMoney.setBounds(150, 5, 200, 50);
        lblTotalSalesMoney.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        totalSalesPnl.add(lblTotalSales);
        totalSalesPnl.add(lblTotalSalesMoney);

        // btnBack
        btnBack.setBounds(940, 580, 100, 50);

        totalMoneyPnl.add(lblWhatToDo);
        //totalMoneyPnl.add(scroll);
        totalMoneyPnl.add(btnBack);
        totalMoneyPnl.add(totalSalesPnl);
        setTotalMoneyPnlTable(t, 100000);
        //todo add(totalMoneyPnl);
    }


    // TODO: 2020-01-01 Override
    public void setTotalMoneyPnlTable(JTable table, int totalMoney) { // 총 매출
        lblTotalSalesMoney.setText(Integer.toString(totalMoney));
        JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(40, 70, 1000, 400);
        totalMoneyPnl.add(scroll);
    }


    public void setCurrentIngredients() { // 제품 재고 현황
        currentIngredientsPnl.setLayout(null);

        lblWhatToDo.setText("Current Items");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        lblWhatToDo.setBounds(480, 10, 200, 30);

        // table
        JPanel tablePnl = new JPanel();
        tablePnl.setLayout(new BorderLayout());

        itemTable = new JTable(rowItemData, columnItemNames);
        tablePnl.add(itemTable, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(itemTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.setBounds(40, 70, 1000, 500);

        // btnBack
        btnBack.setBounds(940, 580, 100, 50);

        currentIngredientsPnl.add(lblWhatToDo);
        currentIngredientsPnl.add(scroll);
        currentIngredientsPnl.add(btnBack);
        // todo add(currentIngredientsPnl);

    }

    public void setBuyIngredients() { // 재고 구매
        buyIngredientsPnl.setLayout(null);
        lblWhatToDo.setText("Buy Items");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        lblWhatToDo.setBounds(480, 10, 200, 30);

        // combo box


        // 재고 수량 label


        // 등록, 수정, 삭제 btn


        // 총액감소 label


        // table
        JPanel tablePnl = new JPanel();
        tablePnl.setLayout(new BorderLayout());

        itemTable = new JTable(rowIngredientData, columnIngredientNames);
        tablePnl.add(itemTable, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(itemTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(600, 70, 450, 500);

        // btnBack
        btnBack.setBounds(940, 580, 100, 50);

        buyIngredientsPnl.add(lblWhatToDo);
        buyIngredientsPnl.add(scroll);
        buyIngredientsPnl.add(btnBack);
        // todo add(buyIngredientsPnl);
    }


    public void setTotalMoneyTable(JTable table) {

    }


    @Override
    public void addAdminListener(ActionListener listener) {
        btnAdminClient.addActionListener(listener);
        btnBack.addActionListener(listener);
        btnTotalMoney.addActionListener(listener);
        btnCurrentItems.addActionListener(listener);
        btnBuyItem.addActionListener(listener);
        btnAddItem.addActionListener(listener);
    }
}
