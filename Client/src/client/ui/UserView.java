package client.ui;

import client.data.dao.ProductModel;

import java.awt.event.ActionListener;
import java.util.Vector;

public interface UserView {
    // TODO: 2019-12-31 파라미터
    void updateItemLists(Vector<ProductModel> lists);

    // TODO: 2019-12-31 파라미터, 여기 i 어떻게?
    void updateSelectedLists(Vector<ProductModel> selectedItem);

    void updateInsertMoney(String money);

    void updateChangesMoney(String money);

    void updateTotalMoney(String money);

    void showAdminDialog();

    void showUserInterface();

    void addListener(ActionListener listener);

}
