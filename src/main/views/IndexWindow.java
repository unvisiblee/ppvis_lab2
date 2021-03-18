package main.views;

import main.controller.ProfessorsController;

import javax.swing.*;
import java.awt.*;

public class IndexWindow {
    private final ProfessorsController controller;
    private final JFrame mainWindow;
    private final TablePartial table;

    public IndexWindow(ProfessorsController controller) {
        this.controller = controller;
        mainWindow = new JFrame("Professors");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table = new TablePartial(controller.getAllProfessors());
        contentPane.add(table.getPanel(), BorderLayout.CENTER);
        contentPane.add(new ControlsPartial(controller, this).getPanel(), BorderLayout.WEST);
        mainWindow.setJMenuBar(new MenuPartial(controller, this).getMenuBar());
        mainWindow.setContentPane(contentPane);
        mainWindow.pack();
    }

    public void show() {
        mainWindow.setVisible(true);
    }


    public void updateTable() {
        table.setData(controller.getAllProfessors());
    }
}
