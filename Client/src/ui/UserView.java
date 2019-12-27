package ui;

import data.dao.ItemDao;

import java.util.Vector;

public interface UserView {
    void updateItemLists(Vector<ItemDao> ItemLists);

    void updateSelectedLists(Vector<ItemDao> selectedItems);

    void updateInsertMoney(String money);

    void updateChangesMoney(String money);

    void updateTotalMoney(String money);

    void showAdminDialog();

    void showUserInterface();

}
