package data;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private ServerConnection serverConnection;

    private RepositoryImpl(ServerConnection serverConnection) {
        this.serverConnection = serverConnection;
    }

    @Override
    public void connectServer(ServerConnectionCallback callback) {
        //TODO Server와 연결하는 동작
        // serverConnection
        serverConnection.doSomething();
                if()
        callback.accept("성공");
                else
        callback.error();
    }

    public static Repository getInstance(ServerConnection serverConnection) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(serverConnection);
        return INSTANCE;
    }

    public interface ServerConnectionCallback {
        void accept(String data);

        void error();
    }
}
