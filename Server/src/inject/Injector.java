package inject;

import data.Repository;
import data.datasource.local.LocalDataSource;
import data.datasource.remote.RemoteDataSource;

public interface Injector {
    Repository injectRepository();

    LocalDataSource injectLocalDataSource();

    RemoteDataSource injectRemoteDataSource();


}
