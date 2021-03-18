package main.views;

import main.form.ProfessorSearchForm;
import main.entity.Professor;
import main.controller.ProfessorsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchWindow {
    private final ProfessorsController controller;
    private final JFrame searchWindow;
    private final TablePartial table;
    private final ProfessorSearchForm form;

    public SearchWindow(ProfessorsController controller) {
        this.controller = controller;
        searchWindow = new JFrame("Search");
        searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form = new ProfessorSearchForm();
        form.updateData(controller.getAllProfessors());

        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton searchButton = new JButton("Search");
        closeButton.addActionListener(getCloseButtonListener());
        searchButton.addActionListener(getSearchButtonListener(form));
        panel.add(closeButton);
        panel.add(searchButton);

        table = new TablePartial(controller.getAllProfessors());
        contentPane.add(table.getPanel(), BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.WEST);

        searchWindow.setContentPane(contentPane);
        searchWindow.pack();
    }

    public void show() {
        form.updateData(controller.getAllProfessors());
        searchWindow.setVisible(true);
    }

    public void dispose() {
        searchWindow.dispose();
    }

    public void updateTable(List<Professor> professors) {
        table.setData(professors);
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSearchButtonListener(ProfessorSearchForm form) {
        return e -> updateTable(controller.applyFilters(form));
    }
}
