package data;

public interface Repository {
    void connectClient();

    void broadCastClients(String data);

    void connectDataBase();

    void closeServer();
}
