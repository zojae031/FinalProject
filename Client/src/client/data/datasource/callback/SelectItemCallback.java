package client.data.datasource.callback;

import client.data.dao.ProductModel;

import java.util.Vector;

public interface SelectItemCallback {
    void success(Vector<ProductModel> lists);
}
