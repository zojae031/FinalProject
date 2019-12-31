package data.datasource.remote;

import data.datasource.remote.callback.LoginCallback;

import java.io.IOException;

public interface RemoteDataSource {
    void openServer(LoginCallback callback);

    void sendData(String data);

    void closeServer() throws IOException;
}
