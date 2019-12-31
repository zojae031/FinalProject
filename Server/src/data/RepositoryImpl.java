package data;

import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;

import java.io.IOException;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private LocalDataSource local;
    private RemoteDataSource remote;

    private RepositoryImpl(LocalDataSource local, RemoteDataSource remote) {
        this.local = local;
        this.remote = remote;
    }

    public static Repository getInstance(LocalDataSource local, RemoteDataSource remote) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(local, remote);
        return INSTANCE;
    }

    @Override
    public void connectClient() {
        remote.openServer(() -> {

            //TODO DataBase로 리스트 요청하기
            remote.sendData("아아아앙");
        });
    }

    @Override
    public void broadCastClients(String data) {
        remote.sendData(data);
    }

    @Override
    public void connectDataBase() {
        //TODO DataBase 연결코드 @{local}
    }

    @Override
    public void closeServer() {
        try {
            remote.closeServer();
            local.closeDb();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
