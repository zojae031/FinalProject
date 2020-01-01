package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.adminview.AdminView;
import client.ui.userview.SelectedItemPnl;
import client.ui.userview.UserView;
import kotlin.jvm.Volatile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Controller implements ActionListener {
    private UserView userView;
    private AdminView adminView;
    private Repository repository;
    @Volatile
    private boolean changeDialogFlag = true;

    public Controller(UserView userView, AdminView adminView, Repository repository) {
        this.userView = userView;
        this.adminView = adminView;
        this.repository = repository;
    }

    public void connectServer() {
        repository.connectServer(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                userView.updateItemLists(lists);
                userView.addItemListListener(Controller.this::actionPerformed);
                userView.addListener(Controller.this::actionPerformed);
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
        if (userView.btnPay.equals(obj)) {

        } else if (userView.btnAdminClient.equals(obj)) {
            if (changeDialogFlag) {
                userView.changeDialog("adminStartPanel");
            } else {
                userView.changeDialog("startPanel");
            }
            changeDialogFlag = !changeDialogFlag;
        } else {
            userView.itemLists.forEach(item ->
            {
                if (obj.equals(item.btnItem)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {
                        userView.updateSelectedLists(item.productModel);
                        userView.updateItemLists(productModelVector);
                        userView.addItemListListener(Controller.this::actionPerformed);
                        userView.addSelectedItemListener(this::actionPerformed);
                    });

                }
            });
            userView.selectedItemLists.forEach(item -> {
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
        userView.updateSelectedLists(item.productModel);
        userView.updateItemLists(productModelVector);
        userView.addItemListListener(Controller.this::actionPerformed);
        userView.addSelectedItemListener(this::actionPerformed);
    }
}
