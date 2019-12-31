import data.RepositoryImpl;
import data.datasource.ServerConnection;

public class Main {
    public static void main(String[] args) {
//        Controller controller = new Controller(/*MainView*/,/*AdminView*/, RepositoryImpl.getInstance(new ServerConnection()));
        RepositoryImpl.getInstance(new ServerConnection()).connectServer(new RepositoryImpl.ServerConnectionCallback() {
            @Override
            public void accept(String data) {

            }

            @Override
            public void error() {

            }
        });
    }
}