package data;

import data.datasource.local.DataBase;
import data.datasource.remote.RemoteDataSource;
import data.datasource.remote.callback.LoginCallback;

import java.io.IOException;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private DataBase local;
    private RemoteDataSource remote;

    private RepositoryImpl(DataBase local, RemoteDataSource remote) {
        this.local = local;
        this.remote = remote;
    }

    public static Repository getInstance(DataBase local, RemoteDataSource remote) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(local, remote);
        return INSTANCE;
    }

    @Override
    public void connectClient() {
        remote.openServer(new LoginCallback() {
            @Override
            public void login() {
                //TODO 로컬로 연결후 성공하면
                remote.sendData(local.getProductArray().toString());
                //TODO Handler 사용해서
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
        // TODO: 2020-01-01 지워도 되지 않나요? 확인부탁드립니다.
    }

    @Override
    public void closeServer() {
        try {
            remote.closeServer();
            // Remove DB close
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
