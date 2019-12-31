package client;

import client.controller.Controller;
import client.data.RepositoryImpl;
import client.data.datasource.ServerConnection;
import client.ui.AdminViewImpl;
import client.ui.UserViewImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new UserViewImpl(), new AdminViewImpl(), RepositoryImpl.getInstance(new ServerConnection()));
        controller.connectServer();

    }
}