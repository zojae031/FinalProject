import controller.Controller;
import inject.Injection;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(Injection.getInstance().injectRepository());
        controller.initialize();
    }
}
