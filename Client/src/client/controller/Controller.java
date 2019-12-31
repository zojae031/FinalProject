package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.AdminView;
import client.ui.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Controller implements ActionListener {
    UserView userView;
    AdminView adminView;
    Repository repository;

    public Controller(UserView userView, AdminView adminView, Repository repository) {
        this.userView = userView;
        this.adminView = adminView;
        this.repository = repository;
        userView.addListener(this);

    }

    public void connectServer() {
        repository.connectServer(new ServerConnectionCallback() {

            @Override
            public void accept(Vector<ProductModel> lists) {
                userView.updateItemLists(lists);
            }

            @Override
            public void error(String error) {
                System.out.println("에러 발생 : " + error);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
