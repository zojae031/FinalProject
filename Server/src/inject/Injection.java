package inject;

import data.Repository;
import data.RepositoryImpl;
import data.datasource.local.LocalDataSource;
import data.datasource.local.LocalDataSourceImpl;
import data.datasource.remote.RemoteDataSource;
import data.datasource.remote.RemoteDataSourceImpl;
import data.datasource.remote.network.Server;

public class Injection implements Injector {
    private static Injection INSTANCE = null;

    private LocalDataSource local = null;
    private RemoteDataSource remote = null;
    private Repository repository = null;

    private Injection() {

    }

    @Override
    public Repository injectRepository() {
        if (repository == null)
            repository = RepositoryImpl.getInstance(injectLocalDataSource(), injectRemoteDataSource());
        return repository;
    }

    @Override
    public LocalDataSource injectLocalDataSource() {
        if (local == null) local = LocalDataSourceImpl.getInstance();
        return local;
    }

    @Override
    public RemoteDataSource injectRemoteDataSource() {
        if (remote == null) remote = RemoteDataSourceImpl.getInstance(new Server());
        return remote;
    }

    public static Injection getInstance() {
        if (INSTANCE == null) INSTANCE = new Injection();
        return INSTANCE;
    }
}
