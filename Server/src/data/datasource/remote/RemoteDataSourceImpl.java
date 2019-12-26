package data.datasource.remote;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static RemoteDataSource INSTANCE = null;

    private RemoteDataSourceImpl() {

    }

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) INSTANCE = new RemoteDataSourceImpl();
        return INSTANCE;
    }
}
