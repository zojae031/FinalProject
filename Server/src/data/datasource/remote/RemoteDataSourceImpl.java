package data.datasource.remote;

import data.datasource.remote.network.Server;

import java.io.IOException;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static RemoteDataSource INSTANCE = null;
    private Server server;

    private RemoteDataSourceImpl(Server server) {
        this.server = server;
    }

    public static RemoteDataSource getInstance(final Server server) {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl(server);
        return INSTANCE;
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
    public void sendData(final String data) {
        server.broadCast(data);
    }

    @Override
    public void closeServer() throws IOException {
        server.close();
    }

}
