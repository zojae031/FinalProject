package data.datasource.remote;

import data.datasource.remote.network.Server;

import java.io.IOException;

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

    @Override
    public void closeServer() throws IOException {
        server.close();
    }

    public static RemoteDataSource getInstance(Server server) {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl(server);
        return INSTANCE;
    }

}
