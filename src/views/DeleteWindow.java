package views;

import controllers.AppointmentsController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DeleteWindow {
    private AppointmentsController controller;
    private JFrame deleteWindow;

    public DeleteWindow(AppointmentsController controller) {
        this.controller = controller;
        deleteWindow = new JFrame("Delete");
        deleteWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        AppointmentFormPartial form = new AppointmentFormPartial(controller);
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
    }

    public void dispose() {
        deleteWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(AppointmentFormPartial form) {
        return e -> {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("patientName", form.getPatientName());
            params.put("patientSurname", form.getPatientSurname());
            params.put("patientCity", form.getPatientCity());
            params.put("patientStreet", form.getPatientStreet());
            params.put("patientBuildingNumber", form.getPatientBuildingNumber());
            params.put("patientBirthDate", form.getPatientBirthDate());
            params.put("doctorName", form.getDoctorName());
            params.put("doctorSurname", form.getDoctorSurname());
            params.put("date", form.getDate());
            params.put("diagnosis", form.getDiagnosis());
            controller.remove(params);
        };
    }
}
