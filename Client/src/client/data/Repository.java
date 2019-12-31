package client.data;

public interface Repository {
    void connectServer(RepositoryImpl.ServerConnectionCallback callback);

}
