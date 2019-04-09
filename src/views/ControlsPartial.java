package views;

import controllers.StudentsController;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlsPartial {
    private StudentsController controller;
    private JPanel panel = new JPanel(new GridLayout(15, 1, 0, 10));

    public ControlsPartial(StudentsController controller) {
        this.controller = controller;
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        panel.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));

        addButton.addActionListener(getAddButtonListener());
        searchButton.addActionListener(getSearchButtonListener());
        deleteButton.addActionListener(getDeleteButtonListener());

        panel.add(addButton);
        panel.add(searchButton);
        panel.add(deleteButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private ActionListener getAddButtonListener() {
        return e -> controller.newRecord();
    }

    private ActionListener getSearchButtonListener() {
        return e -> controller.search();
    }

    private ActionListener getDeleteButtonListener() {
        return e -> controller.delete();
    }
}
