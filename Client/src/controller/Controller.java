package controller;

import data.Repository;
import ui.AdminView;
import ui.UserView;

public class Controller {
    UserView userView;
    AdminView adminView;
    Repository repository;

    public Controller(UserView userView, AdminView adminView, Repository repository) {
        this.userView = userView;
        this.adminView = adminView;
        this.repository = repository;
    }


}
