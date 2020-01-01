package client.data;

import client.data.dao.ProductModel;
import client.data.datasource.ServerConnection;
import client.data.datasource.callback.SelectItemCallback;
import client.data.datasource.callback.ServerConnectionCallback;

import java.util.Vector;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private ServerConnection serverConnection;

    private RepositoryImpl(ServerConnection serverConnection) {
        this.serverConnection = serverConnection;
    }

    public static Repository getInstance(ServerConnection serverConnection) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(serverConnection);
        return INSTANCE;
    }

    @Override
    public void connectServer(ServerConnectionCallback callback) {
        serverConnection.login(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                callback.accept(lists);
            }

            @Override
            public void error(String error) {
                callback.error(error);
            }
        });

    }

    @Override
    public void selectItem(ProductModel item, SelectItemCallback callback) {
        serverConnection.selectItem(item, callback);
    }

    @Override
    public void minusItem(ProductModel item, SelectItemCallback callback) {
        serverConnection.minusItem(item, callback);
    }

    @Override
    public void exitItem(ProductModel item, int itemCount, SelectItemCallback callback) {
        serverConnection.exitItem(item,itemCount,callback);
    }
}
