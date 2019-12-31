package ui;

import data.dao.ItemDao;

import java.util.Vector;

public interface UserView {
    void updateItemLists();

    void updateSelectedLists();

    void updateInsertMoney(String money);

    void updateChangesMoney(String money);

    void updateTotalMoney(String money);

    void showAdminDialog();

    void showUserInterface();

}
