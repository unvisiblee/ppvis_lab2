package main.views;

import main.entity.Professor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TablePartial {
    private final JPanel panel = new JPanel(new BorderLayout());
    private final DefaultTableModel tableModel = getModel();
    private final JLabel currentPageLabel;
    private final JLabel recordsCount;
    private final JTextField updatePerPageField;
    private List<Professor> professors;
    private int page = 1;
    private int perPage = 30;

    public TablePartial(List<Professor> professors) {
        this.professors = professors;

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        String[] columnNames = { "Full name", "Faculty", "Department", "Academic Rank", "Degree", "Experience" };
        tableModel.setColumnIdentifiers(columnNames);
        table.setModel(tableModel);
        scrollPane.setPreferredSize(new Dimension(1200, 500));

        JButton nextButton = new JButton(">");
        nextButton.addActionListener(getNextButtonListener(this));
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(getPrevButtonListener(this));
        JButton lastPageButton = new JButton("Last");
        lastPageButton.addActionListener(getLastPageButtonListener(this));
        JButton firstPageButton = new JButton("First");
        firstPageButton.addActionListener(getFirstPageButtonListener(this));
        currentPageLabel = new JLabel();
        JLabel updatePerPageLabel = new JLabel("Per page:");
        updatePerPageField = new JTextField(String.valueOf(perPage), 4);
        updatePerPageField.getDocument().addDocumentListener(getUpdatePerPageListener(this));
        recordsCount = new JLabel("Total count: " + professors.size());

        JPanel pageControlPanel = new JPanel();
        pageControlPanel.add(updatePerPageLabel);
        pageControlPanel.add(updatePerPageField);
        pageControlPanel.add(firstPageButton);
        pageControlPanel.add(prevButton);
        pageControlPanel.add(currentPageLabel);
        pageControlPanel.add(nextButton);
        pageControlPanel.add(lastPageButton);
        pageControlPanel.add(recordsCount);


        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pageControlPanel, BorderLayout.SOUTH);
        rerender();
    }

    public void setData(List<Professor> professors) {
        this.professors = professors;
        rerender();
    }

    public void rerender() {
        List<Professor> professors = dataToDisplay(page, perPage);
        tableModel.setRowCount(0);
        for (Professor professor : professors) {
            Object[] row = new Object[] {
                    professor.getFullName(),
                    professor.getFaculty(),
                    professor.getDepartment(),
                    professor.getAcademicRank(),
                    professor.getDegree(),
                    professor.getExperience(),
            };
            tableModel.addRow(row);
        }
        currentPageLabel.setText(getPage() + "/" + pageCount());
        recordsCount.setText("Total count: " + professors.size());

    }

    public JPanel getPanel() {
        return panel;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getPage() {
        return page;
    }

    public int recordCount() {
        return professors.size();
    }

    public int pageCount() {
        if (perPage == 0) {
            return 1;
        } else {
            return (int) Math.ceil((double)recordCount() / perPage);
        }
    }

    public void setPerPage(int perPage) {
        if (perPage > recordCount()) {
            perPage = recordCount();
        } else if (perPage < 0) {
            perPage = 0;
        }
        this.perPage = perPage;
        rerender();
    }

    public void setPage(int page) {
        if (page > pageCount()){
            page = pageCount();
        } else if (page <= 0) {
            page = 1;
        }
        this.page = page;
        rerender();
    }

    private ActionListener getNextButtonListener(TablePartial table) {
        return e -> table.setPage(table.getPage() + 1);
    }

    private ActionListener getPrevButtonListener(TablePartial table) {
        return e -> table.setPage(table.getPage() - 1);
    }

    private ActionListener getLastPageButtonListener(TablePartial table) {
        return e -> table.setPage(table.pageCount());
    }

    private ActionListener getFirstPageButtonListener(TablePartial table) {
        return e -> table.setPage(1);
    }

    private DefaultTableModel getModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private DocumentListener getUpdatePerPageListener(TablePartial table) {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }
        };
    }

    private void actionForPageListener(TablePartial table) {
        String newPerPage = updatePerPageField.getText();
        newPerPage = newPerPage.equals("") ? "0" : newPerPage;
        table.setPerPage(Integer.parseInt(newPerPage));
        table.setPage(1);
    }
    
    private List<Professor> dataToDisplay(int page, int perPage) {
        int from = (page - 1) * perPage;
        int to = from + perPage;
        to = Math.min(to, professors.size());
        return new ArrayList<>(professors.subList(from, to));
    }
}
