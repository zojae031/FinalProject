package data;

import data.datasource.ServerConnection;

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
        //TODO Server와 연결하는 동작
        // serverConnection

        serverConnection.start();
        serverConnection.send();


    }

    public interface ServerConnectionCallback {
        void accept(String data);

        void error();
    }
}
