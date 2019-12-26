package data;

import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private LocalDataSource local;
    private RemoteDataSource remote;

    private RepositoryImpl(LocalDataSource local, RemoteDataSource remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public void connectClient() {
        remote.openServer(data -> {
            System.out.println("받아온 데이터 : " + data);
        });
    }

    @Override
    public void connectDataBase() {
        //TODO DataBase 연결코드 @{local}
    }

    public static Repository getInstance(LocalDataSource local, RemoteDataSource remote) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(local, remote);
        return INSTANCE;
    }
}
