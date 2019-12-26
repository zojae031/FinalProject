package data;

import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private LocalDataSource local = null;
    private RemoteDataSource remote = null;

    private RepositoryImpl(LocalDataSource local, RemoteDataSource remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public void connectClient() {
        remote.openServer();
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
