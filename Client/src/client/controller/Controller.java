package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.CardLayoutMain;
import client.ui.adminview.AdminView;
import client.ui.userview.UserView;
import kotlin.jvm.Volatile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Controller implements ActionListener {

    private Repository repository;
    private CardLayoutMain cardLayoutMain;
    @Volatile
    private boolean changeDialogFlag = true;


    public Controller(CardLayoutMain cardLayoutMain, Repository repository) {
        this.cardLayoutMain = cardLayoutMain;
        this.repository = repository;
    }

    public void connectServer() {
        repository.connectServer(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                cardLayoutMain.userView.updateItemLists(lists);
                cardLayoutMain.userView.addItemListListener(Controller.this::actionPerformed);
                cardLayoutMain.userView.addListener(Controller.this::actionPerformed);
            }

            @Override
            public void error(String error) {
                System.out.println("에러 발생 : " + error);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();
        if (cardLayoutMain.userView.btnPay.equals(obj)) {

        } else if (cardLayoutMain.userView.btnAdminClient.equals(obj)) {
            if (changeDialogFlag) {
                cardLayoutMain.changeDialog("admin");
            } else {
                cardLayoutMain.changeDialog("start");
            }
            changeDialogFlag = !changeDialogFlag;
        } else {
            cardLayoutMain.userView.itemLists.forEach(item ->
            {
                if (obj.equals(item.btnItem)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {
                        cardLayoutMain.userView.updateSelectedLists(item.productModel);
                        cardLayoutMain.userView.updateItemLists(productModelVector);
                        cardLayoutMain.userView.addItemListListener(Controller.this::actionPerformed);
                        cardLayoutMain.userView.addSelectedItemListener(this::actionPerformed);
                    });

                }
            });
            cardLayoutMain.userView.selectedItemLists.forEach(item -> {
                if (obj.equals(item.btnMinus)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {

                    });
                } else if (obj.equals(item.btnPlus)) {

                } else if (obj.equals(item.btnX)) {

                }
            });
        }


    }
}
