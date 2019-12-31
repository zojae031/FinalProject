package data.datasource.remote;

import java.io.IOException;

public interface RemoteDataSource {
    void openServer();

    void sendData(String data);

    void closeServer() throws IOException;
}
