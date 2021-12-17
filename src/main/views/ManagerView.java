package main.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView {

    public void show() {
        System.out.println("test");
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JButton watchLinkedB = new JButton();
        watchLinkedB.setText("Watch linked tenants");
        watchLinkedB.setSize(new Dimension(75, 25));
        watchLinkedB.addActionListener(e -> {
            frame.setVisible(false);
            watchFixedTenants();
        });

        JButton watchTenantsB = new JButton();
        watchTenantsB.setText("Watch active tenants");
        watchTenantsB.setSize(new Dimension(75, 25));
        watchTenantsB.addActionListener(e -> {
            frame.setVisible(false);
            watchActiveTenants();
        });

        JButton watchHistoryB = new JButton();
        watchHistoryB.setText("Watch history");
        watchHistoryB.setSize(new Dimension(75, 25));
        watchHistoryB.addActionListener(e -> {
            frame.setVisible(false);
            watchTenantsHistory();
        });

        JButton blockB = new JButton();
        blockB.setText("Block user");
        blockB.setSize(new Dimension(75, 25));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));


        // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(watchLinkedB);
        allPanel.add(watchTenantsB);
        allPanel.add(watchHistoryB);
        allPanel.add(blockB);
        allPanel.add(watchLinkedB, BorderLayout.NORTH);

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }

    public void watchFixedTenants() {
        System.out.println("Show tenants");
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JButton tenant1 = new JButton();
        tenant1.setText("Tenant1");
        tenant1.setSize(new Dimension(75, 25));


        JButton tenant2 = new JButton();
        tenant2.setText("Tenant2");
        tenant2.setSize(new Dimension(75, 25));


        JButton tenant3 = new JButton();
        tenant3.setText("Tenant3");
        tenant3.setSize(new Dimension(75, 25));


        JButton blockB = new JButton();
        blockB.setText("Block user");
        blockB.setSize(new Dimension(75, 25));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));


        // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(tenant1);
        allPanel.add(tenant2);
        allPanel.add(tenant3);

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }

    public void watchActiveTenants() {
        System.out.println("Show tenants");
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JButton tenant1 = new JButton();
        tenant1.setText("Tenant1");
        tenant1.setSize(new Dimension(75, 25));


        JButton tenant2 = new JButton();
        tenant2.setText("Tenant2");
        tenant2.setSize(new Dimension(75, 25));


        JButton tenant3 = new JButton();
        tenant3.setText("Tenant3");
        tenant3.setSize(new Dimension(75, 25));


        JButton blockB = new JButton();
        blockB.setText("Block user");
        blockB.setSize(new Dimension(75, 25));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));


        // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(tenant1);
        allPanel.add(tenant2);
        allPanel.add(tenant3);

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }

    public void watchTenantsHistory() {
        System.out.println("Show tenants");
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));

        JButton rentRecord1 = new JButton();
        rentRecord1.setText("Rent Record 1");
        rentRecord1.setSize(new Dimension(75, 25));


        JButton rentRecord2 = new JButton();
        rentRecord2.setText("Rent Record 2");
        rentRecord2.setSize(new Dimension(75, 25));


        JButton rentRecord3 = new JButton();
        rentRecord3.setText("Rent Record 3");
        rentRecord3.setSize(new Dimension(75, 25));


        JPanel marginLabel = new JPanel();
        marginLabel.setPreferredSize(new Dimension(500, 150));


        // passPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        allPanel.add(rentRecord1);
        allPanel.add(rentRecord2);
        allPanel.add(rentRecord3);

        frame.add(marginLabel,BorderLayout.NORTH);
        frame.add(allPanel);
        frame.setVisible(true);
    }
}