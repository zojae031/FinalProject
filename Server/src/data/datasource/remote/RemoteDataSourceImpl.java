package data.datasource.remote;

import data.datasource.remote.network.Server;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static RemoteDataSource INSTANCE = null;
    private Server server;

    private RemoteDataSourceImpl(Server server) {
        this.server = server;

    }

    @Override
    public void openServer() {
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendData(String data) {
        server.broadCast(data);
    }

    public static RemoteDataSource getInstance(Server server) {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl(server);
        return INSTANCE;
    }

}
