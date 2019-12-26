package data.datasource.remote;

import data.datasource.remote.server.Server;

public interface RemoteDataSource {
    void openServer(Server.ReceiveListener listener);
}
