package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.CardLayoutMain;
import client.ui.userview.SelectedItemPnl;
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
                cardLayoutMain.adminView.addAdminListener(Controller.this::actionPerformed);

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

        } else if (cardLayoutMain.userView.btnAdminClient.equals(obj) || cardLayoutMain.adminView.btnAdminClient.equals(obj)) {
            if (changeDialogFlag) {
                System.out.println("admin");
                cardLayoutMain.changeDialog("admin");
            } else {
                System.out.println("start");
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
                    repository.minusItem(item.productModel, (productModelVector) -> {
                        updateUserView(item, productModelVector);
                    });
                } else if (obj.equals(item.btnPlus)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {
                        updateUserView(item, productModelVector);
                    });
                } else if (obj.equals(item.btnX)) {
                    repository.exitItem(item.productModel, item.itemCount, (productModelVector) -> {
                        updateUserView(item, productModelVector);
                    });
                }
            });
        }


    }

    private void updateUserView(SelectedItemPnl item, Vector<ProductModel> productModelVector) {
        cardLayoutMain.userView.updateSelectedLists(item.productModel);
        cardLayoutMain.userView.updateItemLists(productModelVector);
        cardLayoutMain.userView.addItemListListener(Controller.this::actionPerformed);
        cardLayoutMain.userView.addSelectedItemListener(this::actionPerformed);
    }
}
