import controller.Controller;
import inject.Injection;

public class Main {
    public static void main(String[] args) {
        new Controller(Injection.getInstance().injectRepository());
    }
}
