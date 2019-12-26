package data.datasource.remote;

import data.datasource.remote.server.Server;

import java.io.IOException;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static RemoteDataSource INSTANCE = null;
    private Server server;

    private RemoteDataSourceImpl(Server server) {
        this.server = server;
        try {
            String ip = server.initServer();
            System.out.println("서버 연결 성공 : " + ip);
        } catch (IOException e) {
            System.out.println("서버 연결 오류" + e.getMessage());
        }
    }

    @Override
    public void openServer() {
        try {
            server.startServer(data -> {//데이터 들어오는 부분

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RemoteDataSource getInstance(Server server) {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl(server);
        return INSTANCE;
    }
}
