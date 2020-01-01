package test;

import client.data.Repository;
import client.data.RepositoryImpl;
import client.data.dao.ProductModel;
import client.data.datasource.ServerConnection;
import client.data.datasource.callback.ServerConnectionCallback;

import java.util.Vector;

public class DriverView {
    public static void main(String[] args) {
        Repository repo = RepositoryImpl.getInstance(new ServerConnection());
        repo.connectServer(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                System.out.println(lists);
            }

            @Override
            public void error(String error) {

            }
        });

    }

}
