package data;

import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;
import data.datasource.remote.callback.LoginCallback;

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
        remote.openServer(new LoginCallback() {
            @Override
            public void login() {
                //TODO 로컬로 연결후 성공하면
                remote.sendData("itemLists JsonArray to String");

            }

            @Override
            public void error() {
                System.out.println("로그인 실패!!!");
            }
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
