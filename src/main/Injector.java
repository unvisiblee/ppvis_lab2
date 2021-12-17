package main;

import main.controller.AuthController;
import main.repository.TransientUserRepository;
import main.service.UserService;
import main.views.MainView;
import main.views.ManagerView;
import main.views.TenantView;

public class Injector {
    public static void main(String[] args) {

        MainView mainView = new MainView(new AuthController(new UserService(new TransientUserRepository())), new ManagerView(), new TenantView());
        mainView.login();
    }
}