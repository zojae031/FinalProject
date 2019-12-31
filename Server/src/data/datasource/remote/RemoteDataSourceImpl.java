package data.datasource.remote;

import com.google.gson.JsonParser;
import data.datasource.remote.callback.LoginCallback;
import data.datasource.remote.network.Server;

import java.io.IOException;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static RemoteDataSource INSTANCE = null;
    private Server server;
    private JsonParser parser = new JsonParser();

    private RemoteDataSourceImpl(Server server) {
        this.server = server;
    }

    public static RemoteDataSource getInstance(final Server server) {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl(server);
        return INSTANCE;
    }

    @Override
    public void openServer(LoginCallback callback) {
        server.startServer();
        server.ReceiveData(data -> {
            if (parser.parse(data).getAsJsonObject().get("login").getAsString().equals("100")) {
                callback.login();
            }

        });
    }

    @Override
    public void sendData(final String data) {
        server.send(data);
    }

    @Override
    public void closeServer() throws IOException {
        server.close();
    }

}
