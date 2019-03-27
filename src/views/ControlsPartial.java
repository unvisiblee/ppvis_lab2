package views;

import javax.swing.*;
import java.awt.*;

public class ControlsPartial {
    private JPanel panel = new JPanel(new GridLayout(15, 1, 0, 10));

    public ControlsPartial() {
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        panel.add(addButton);
        panel.add(searchButton);
        panel.add(deleteButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}