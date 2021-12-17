package main.views;

import javax.swing.*;
import java.awt.*;

public class TenantView {


    public void show() {
        System.out.println("test");
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JPanel userNamePanel = new JPanel();
        JLabel phoneLabel = new JLabel("Eeee");
        JTextField phoneTextField = new JTextField("username");

        userNamePanel.add(phoneLabel);
        userNamePanel.add(phoneTextField);

        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password");
        JTextField passTextField = new JTextField("*********");

        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setSize(new Dimension(75, 25));


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

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }
}