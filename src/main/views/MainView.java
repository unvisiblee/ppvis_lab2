package main.views;

import main.controller.AuthController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView {
    private final AuthController authController;
    private final ManagerView managerView;
    private final TenantView tenantView;

    public MainView(AuthController authController, ManagerView managerView, TenantView tenantView) {
        this.authController = authController;
        this.managerView = managerView;
        this.tenantView = tenantView;
    }

    public void login() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JPanel userNamePanel = new JPanel();
        JLabel phoneLabel = new JLabel("Username");
        JTextField phoneTextField = new JTextField("username");

        userNamePanel.add(phoneLabel);
        userNamePanel.add(phoneTextField);

        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password");
        JTextField passTextField = new JTextField("*********");

        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setSize(new Dimension(75, 25));
        submitButton.addActionListener(getSubmitButtonListener(frame));

        JButton signUpButton = new JButton();
        signUpButton.setText("SignUp");
        signUpButton.setSize(new Dimension(50, 15));
        signUpButton.addActionListener(getSignUpButtonListener(frame));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));

        passPanel.add(passLabel);
        passPanel.add(passTextField);
       // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(userNamePanel);
        allPanel.add(passPanel);
        allPanel.add(submitButton, BorderLayout.NORTH);
        allPanel.add(signUpButton);

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }

    public void signUp() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(1000, 500));

        JPanel userNamePanel = new JPanel();
        JLabel phoneLabel = new JLabel("Username");
        JTextField phoneTextField = new JTextField("username");

        userNamePanel.add(phoneLabel);
        userNamePanel.add(phoneTextField);

        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password");
        JTextField passTextField = new JTextField("*********");

        passPanel.add(passLabel);
        passPanel.add(passTextField);

        JPanel passconfPanel = new JPanel();
        JLabel passconfLabel = new JLabel("Password");
        JTextField passConfTextField = new JTextField("*********");

        passconfPanel.add(passconfLabel);
        passconfPanel.add(passConfTextField);

        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setSize(new Dimension(75, 25));
        submitButton.addActionListener(getSubmitButtonListener(frame));

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setSize(new Dimension(50, 15));
        loginButton.addActionListener(getLogInButtonListener(frame));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));
        // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(userNamePanel);
        allPanel.add(passPanel);
        allPanel.add(passconfPanel);
        allPanel.add(submitButton, BorderLayout.NORTH);
        allPanel.add(loginButton);
        System.out.println("signup");

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);

    }

    public void showTenantView() {
        tenantView.show();
    }

    public void showManagerView() {
        managerView.show();
    }

    private ActionListener getSubmitButtonListener(Frame frame) {
        return e -> {
            frame.setVisible(false);
            showManagerView();
        };
    }

    private ActionListener getSignUpButtonListener(Frame frame) {
        return e -> {
            frame.setVisible(false);
            signUp();
        };
    }

    private ActionListener getLogInButtonListener(Frame frame) {
        return e -> {
            frame.setVisible(false);
            login();
        };
    }

}


