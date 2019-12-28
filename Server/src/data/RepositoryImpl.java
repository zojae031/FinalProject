package data;

import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;

import java.util.Scanner;

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

        remote.openServer();
        Scanner sc = new Scanner(System.in);
        remote.sendData(sc.nextLine());
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
