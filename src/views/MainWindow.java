package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import views.TablePartial;
import controllers.PatientsController;

public class MainWindow {
    private PatientsController controller;
    private JFrame mainWindow;

    public MainWindow(PatientsController controller) {
        this.controller = controller;
        mainWindow = new JFrame("Hospital");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setLocationRelativeTo(null);
    }

    public void show() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        mainWindow.setContentPane(contentPane);

        contentPane.add(new TablePartial().getPanel());

        mainWindow.setVisible(true);
    }
}
