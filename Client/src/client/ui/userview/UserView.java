package client.ui.userview;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public interface UserView {
    JPanel startPnl = new JPanel(), itemListPnl = new JPanel(), selectedListPnl = new JPanel();
    JButton btnAdminClient = new JButton(), btnPay = new JButton("구매");
    JLabel lblInsertMoney = new JLabel("투입 금액 "), lblTotalMoney = new JLabel("총 금액 "), lblChangeMoney = new JLabel("거스름돈 ");
    List<ItemInfoPnl> itemLists = new LinkedList<>();
    List<SelectedItemPnl> selectedItemLists = new LinkedList<>();


    void updateItemLists(Vector<ProductModel> lists);


    // TODO: 2019-12-31 파라미터, 여기 i 어떻게?

    void updateSelectedLists(ProductModel productModel);

    void updateInsertMoney(String money);

    void updateChangesMoney(String money);

    void updateTotalMoney(String money);

    void showUserInterface();

    void addListener(ActionListener listener);

    void addItemListListener(ActionListener listener);

    void addSelectedItemListener(ActionListener listener);

}
