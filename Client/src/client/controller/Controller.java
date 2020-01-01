package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.AdminView;
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
            if (changeDialogFlag) {
                userView.changeDialog("adminStartPanel");
            } else {
                userView.changeDialog("");
            }
            changeDialogFlag = !changeDialogFlag;
        } else if (userView.btnAdminClient.equals(obj)) {

        } else {
            userView.itemLists.forEach(item ->
            {
                if (obj.equals(item.btnItem)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {
                        userView.updateSelectedLists(item.productModel.PrName);//TODO 여기는 추가된 아이템 리스트!
                        userView.updateItemLists(productModelVector);
                        userView.addSelectedItemListener(this::actionPerformed);
                    });

                }
            });
        }


    }
}
