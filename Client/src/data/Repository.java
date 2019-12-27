package data;

public interface Repository {
    void connectServer(RepositoryImpl.ServerConnectionCallback callback);

}
