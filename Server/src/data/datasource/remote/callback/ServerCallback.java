package data.datasource.remote.callback;

public interface ServerCallback {
    void login();

    void selectItem(String select);

    void error();
}
