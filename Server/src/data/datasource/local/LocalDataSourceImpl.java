package data.datasource.local;

public class LocalDataSourceImpl implements LocalDataSource {
    private static LocalDataSource INSTANCE = null;

    private LocalDataSourceImpl() {

    }

    public static LocalDataSource getInstance() {
        if (INSTANCE == null) INSTANCE = new LocalDataSourceImpl();
        return INSTANCE;
    }

    @Override
    public void closeDb() {

    }
}
