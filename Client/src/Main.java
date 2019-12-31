import controller.Controller;
import data.RepositoryImpl;
import data.ServerConnection;
import ui.UserView;
import ui.UserViewImpl;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
       // Controller controller = new Controller(/*MainView*/,/*AdminView*/, RepositoryImpl.getInstance(new ServerConnection()));
        new UserViewImpl();

    }
}
