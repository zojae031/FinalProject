package client;

import client.controller.Controller;
import client.data.RepositoryImpl;
import client.data.datasource.ServerConnection;
import client.ui.CardLayoutMain;
import client.ui.adminview.AdminViewImpl;
import client.ui.userview.UserViewImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new CardLayoutMain(new UserViewImpl(), new AdminViewImpl()), RepositoryImpl.getInstance(new ServerConnection()));
        controller.connectServer();

    }
}