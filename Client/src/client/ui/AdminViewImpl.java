package client.ui;

import javax.swing.*;
import java.awt.*;

public class AdminViewImpl extends JFrame implements AdminView {

    protected CardLayout cardLayout;
    protected Container tab;
    protected JPanel btnAdminWhatToDo;

    protected JLabel lblWhatToDo = new JLabel();
    private JButton btnBack = new JButton("Back");

    JTable itemTable;
    // TODO: 제품 제고현황 example
    String columnNames[] =
            {"상품번호", "제품명", "제품가격", "판매 갯수", "총액"};

    Object rowData[][] =
            {
                    {1, "김밥", 1000, 3, 3000},
                    {2, "오믈렛", 3000, 4, 12000},
                    {3, "치킨마요", 4000, 1, 4000}};

    public AdminViewImpl() {
        setTitle("Manage");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);


        setTotalMoneyPnl();
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

    public void setTotalMoneyPnl() {
        JPanel totalMoneyPnl = new JPanel();
        totalMoneyPnl.setLayout(null);

        lblWhatToDo.setText("Total Money");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        lblWhatToDo.setBounds(480, 10, 200, 30);

        JPanel tablePnl = new JPanel();
        tablePnl.setLayout(new BorderLayout());

        itemTable = new JTable(rowData, columnNames);
        tablePnl.add(itemTable, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(itemTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.setBounds(40, 70, 1000, 400);


// total sale
        JPanel totalSalesPnl = new JPanel();
        totalSalesPnl.setBackground(Color.orange);
        totalSalesPnl.setBounds(40, 490, 1000, 70);
        totalSalesPnl.setLayout(null);

        JLabel lblTotalSales = new JLabel();
        lblTotalSales.setText("총 매출 "); // TODO: 2019-12-31 함수로 따로 빼기
        lblTotalSales.setBounds(10, 5, 100, 50);
        lblTotalSales.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        JLabel lblTotalSalesMoney = new JLabel();
        lblTotalSalesMoney.setText("1,000,000");
        lblTotalSalesMoney.setBounds(150, 5, 200, 50);
        lblTotalSalesMoney.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        totalSalesPnl.add(lblTotalSales);
        totalSalesPnl.add(lblTotalSalesMoney);

        btnBack.setBounds(940, 580, 100, 50);

        totalMoneyPnl.add(lblWhatToDo);
        totalMoneyPnl.add(scroll);
        totalMoneyPnl.add(btnBack);
        totalMoneyPnl.add(totalSalesPnl);
        add(totalMoneyPnl);
    }

}