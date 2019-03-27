package views;

import database.PatientsLocalStorage;
import models.Patient;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TablePartial {
    private JPanel panel = new JPanel(new BorderLayout());
    private JTable table = new JTable();
    private DefaultTableModel tableModel = getModel();

    public TablePartial(PatientsLocalStorage patients) {
        JButton nextButton = new JButton(">");
        JButton prevButton = new JButton("<");
        JButton lastPageButton = new JButton("Last");
        JButton firstPageButton = new JButton("First");

        JScrollPane scrollPane = new JScrollPane(table);
        String[] columnNames = { "Full name", "Address", "Birth date", "Doctor's full name", "Appointment date", "Diagnosis" };
        tableModel.setColumnIdentifiers(columnNames);
        setData(patients.getPatients());
        table.setModel(tableModel);
        scrollPane.setPreferredSize(new Dimension(800, 400));

        JPanel pageControlPanel = new JPanel();
        pageControlPanel.add(firstPageButton);
        pageControlPanel.add(prevButton);
        pageControlPanel.add(nextButton);
        pageControlPanel.add(lastPageButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pageControlPanel, BorderLayout.SOUTH);
    }

    public void setData(ArrayList<Patient> patients) {
        tableModel.setRowCount(0);
        for (Patient patient : patients) {
            Object[] row = new Object[] {
                    patient.getFullName(),
                    patient.getAddress(),
                    patient.getBirthDateString(),
                    patient.getDoctorFullName(),
                    patient.getAppointmentDateString(),
                    patient.getDiagnosis()
            };
            tableModel.addRow(row);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private DefaultTableModel getModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
