package client.controller;

import client.data.Repository;
import client.data.RepositoryImpl;
import client.ui.AdminView;
import client.ui.UserView;

public class Controller {
    UserView userView;
    AdminView adminView;
    Repository repository;

    public Controller(UserView userView, AdminView adminView, Repository repository) {
        this.userView = userView;
        this.adminView = adminView;
        this.repository = repository;
    }

    public void startApp() {

    }

    void connectServer() {
        repository.connectServer(new RepositoryImpl.ServerConnectionCallback() {
            @Override
            public void accept(String data) {

            }

            @Override
            public void error() {

            }
        });
    }


}
