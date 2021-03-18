package main.views;

import main.form.ProfessorSearchForm;
import main.entity.Professor;
import main.controller.ProfessorsController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteWindow {
    private final ProfessorsController controller;
    private final JFrame deleteWindow;
    private final IndexWindow indexWindow;
    ProfessorSearchForm form;

    public DeleteWindow(ProfessorsController controller, IndexWindow indexWindow) {
        this.controller = controller;
        this.indexWindow = indexWindow;
        deleteWindow = new JFrame("Delete");
        deleteWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form = new ProfessorSearchForm();
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton deleteButton = new JButton("Delete");
        closeButton.addActionListener(getCloseButtonListener());
        deleteButton.addActionListener(getSubmitButtonListener(form));
        panel.add(closeButton);
        panel.add(deleteButton);

        contentPane.add(panel);

        deleteWindow.setContentPane(contentPane);
        deleteWindow.pack();
    }

    public void show() {

        deleteWindow.setVisible(true);
        form.updateData(controller.getAllProfessors());
    }

    public void dispose() {
        deleteWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(ProfessorSearchForm form) {
        return e -> {
            List<Professor> searchResults = this.controller.applyFilters(form); // todo

            controller.remove(searchResults);

            new Alert(getRemovedRecordsList(searchResults));
            indexWindow.updateTable();
            this.deleteWindow.setVisible(false);
        };
    }

    private String getRemovedRecordsList(List<Professor> removedRecords) {
        if (removedRecords.size() == 0) {
            return "No matches.";
        }
        StringBuilder text = new StringBuilder(removedRecords.size() + " professors were removed:\n");
        for (int index = 0; index < removedRecords.size(); index++) {
            Professor professor = removedRecords.get(index);
            text.append(professor.getFullName()).append("\n");
            if (index >= 9) {
                return text + "And " + (removedRecords.size() - index - 1) + " more.";
            }
        }
        return text.toString();
    }

}