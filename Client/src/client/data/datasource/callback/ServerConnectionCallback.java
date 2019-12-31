package client.data.datasource.callback;

import client.data.dao.ProductModel;

import java.util.Vector;

public interface ServerConnectionCallback {
    void accept(Vector<ProductModel> lists);

    void error(String error);
}