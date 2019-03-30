package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

import controllers.AppointmentsController;

public class IndexWindow {
    private AppointmentsController controller;
    private JFrame mainWindow;

    public IndexWindow(AppointmentsController controller) {
        this.controller = controller;
        mainWindow = new JFrame("Hospital");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
    }

    public void show() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        mainWindow.setContentPane(contentPane);

        contentPane.add(new TablePartial(controller.getPatients()).getPanel(), BorderLayout.CENTER);
        contentPane.add(new ControlsPartial(controller).getPanel(), BorderLayout.WEST);

        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
