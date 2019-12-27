package data;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;

    private RepositoryImpl() {

    }

    public static Repository getInstance() {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl();
        return INSTANCE;
    }

}
