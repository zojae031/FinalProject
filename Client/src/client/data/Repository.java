package client.data;

import client.data.datasource.callback.ServerConnectionCallback;

public interface Repository {
    void connectServer(ServerConnectionCallback callback);
    //Test 주석입니다.
}
