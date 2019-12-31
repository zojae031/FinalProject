package controller;

import data.Repository;
import data.RepositoryImpl;
import ui.AdminView;
import ui.UserView;

public class Controller {
    UserView userView;
    AdminView adminView;
    Repository repository;

    public Controller(UserView userView, AdminView adminView, Repository repository) {
        this.userView = userView;
        this.adminView = adminView;
        this.repository = repository;
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
