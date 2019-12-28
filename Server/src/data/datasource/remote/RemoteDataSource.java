package data.datasource.remote;

public interface RemoteDataSource {
    void openServer();

    void sendData(String data);
}
