package client.ui.adminview;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface AdminView {
    JPanel adminStartPanel = new JPanel(), btnAdminWhatToDo = new JPanel(), totalMoneyPnl = new JPanel(), totalSalesPnl = new JPanel(), currentIngredientsPnl = new JPanel(), buyIngredientsPnl = new JPanel(), AdminClientButtonPnl = new JPanel();
    JLabel lblWhatToDo = new JLabel(), lblTotalSales = new JLabel(), lblTotalSalesMoney = new JLabel();
    JButton btnTotalMoney = new JButton("Item Total Money"), btnCurrentItems = new JButton("Current Items"), btnBuyItem = new JButton("Buy Items"), btnAddItem = new JButton("Add Items"), btnAdminClient = new JButton(), btnBack = new JButton("Back");

    void addAdminListener(ActionListener listener);
}
