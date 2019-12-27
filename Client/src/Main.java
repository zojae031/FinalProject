import controller.Controller;
import data.RepositoryImpl;
import data.ServerConnection;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(/*MainView*/,/*AdminView*/, RepositoryImpl.getInstance(new ServerConnection()));
    }
}
