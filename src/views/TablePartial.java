package views;

import database.AppointmentsLocalStorage;
import models.Appointment;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class TablePartial {
    private JPanel panel = new JPanel(new BorderLayout());
    private DefaultTableModel tableModel = getModel();
    private JTextField updatePerPageField;
    private JTable table;
    private ArrayList<Appointment> appointments;
    private int page = 1;
    private int perPage = 30;

    public TablePartial(AppointmentsLocalStorage appointments) {
        this.appointments = appointments.getAppointments();
        JButton nextButton = new JButton(">");
        JButton prevButton = new JButton("<");
        JButton lastPageButton = new JButton("Last");
        JButton firstPageButton = new JButton("First");

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        String[] columnNames = { "Full name", "Address", "Birth date", "Doctor's full name", "Appointment date", "Diagnosis" };
        tableModel.setColumnIdentifiers(columnNames);
        setData(dataToDisplay(page, perPage));
        table.setModel(tableModel);
        scrollPane.setPreferredSize(new Dimension(1200, 500));

        JPanel pageControlPanel = new JPanel();
        JLabel currentPageLabel = new JLabel(page + "/" + pageCount());
        JLabel updatePerPageLabel = new JLabel("Per page:");
        updatePerPageField = new JTextField(String.valueOf(perPage), 4);
        pageControlPanel.add(updatePerPageLabel);
        pageControlPanel.add(updatePerPageField);
        pageControlPanel.add(firstPageButton);
        pageControlPanel.add(prevButton);
        pageControlPanel.add(currentPageLabel);
        pageControlPanel.add(nextButton);
        pageControlPanel.add(lastPageButton);

        updatePerPageField.getDocument().addDocumentListener(getUpdatePerPageListener(this));

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pageControlPanel, BorderLayout.SOUTH);
    }

    public void setData(ArrayList<Appointment> appointments) {
        tableModel.setRowCount(0);
        for (Appointment appointment : appointments) {
            Object[] row = new Object[] {
                    appointment.getPatientFullName(),
                    appointment.getPatientAddress(),
                    appointment.getPatientBirthDateString(),
                    appointment.getDoctorFullName(),
                    appointment.getDateString(),
                    appointment.getDiagnosis()
            };
            tableModel.addRow(row);
        }
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
        return appointments.size();
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
            this.perPage = recordCount();
        } else {
            this.perPage = perPage;
        }
    }

    public void setPage(int page) {
        this.page = page;
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
        table.setPerPage(Integer.valueOf(newPerPage));
        table.setPage(1);
        setData(dataToDisplay(1, table.getPerPage()));
    }
    
    private ArrayList<Appointment> dataToDisplay(int page, int perPage) {
        int from = (page - 1) * perPage;
        int to = from + perPage;
        return new ArrayList<Appointment>(appointments.subList(from, to));
    }
}
