package views;

import controllers.AppointmentsController;

import javax.swing.*;
import java.awt.*;

public class SearchWindow {
    private AppointmentsController controller;
    private JFrame mainWindow;
    private TablePartial table;

    public SearchWindow(AppointmentsController controller) {
        this.controller = controller;
        mainWindow = new JFrame("Search");
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
    }

    public void show() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table = new TablePartial(controller.getAppointments().getAppointments());
        contentPane.add(table.getPanel(), BorderLayout.CENTER);
        contentPane.add(new ControlsPartial(controller).getPanel(), BorderLayout.WEST);

        mainWindow.setContentPane(contentPane);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public void dispose() {
        mainWindow.dispose();
    }

    public void updateTable() {
        table.setData(controller.getAppointments().getAppointments());
    }
}
