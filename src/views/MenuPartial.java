package views;

import controllers.StudentsController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuPartial {
    private JMenuBar menuBar;
    private StudentsController controller;

    public MenuPartial(StudentsController controller) {
        this.controller = controller;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".xml","xml"));

        menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        JMenu action = new JMenu("Action");
        JMenuItem createItem = new JMenuItem("Create");
        JMenuItem deleteItem = new JMenuItem("Delete");
        JMenuItem searchItem = new JMenuItem("Search");

        openItem.addActionListener(getOpenItemListener(fileChooser));
        saveItem.addActionListener(getSaveItemListener(fileChooser));

        createItem.addActionListener(getCreateItemListener());
        deleteItem.addActionListener(getDeleteItemListener());
        searchItem.addActionListener(getSearchItemListener());

        menu.add(openItem);
        menu.add(saveItem);

        action.add(createItem);
        action.add(deleteItem);
        action.add(searchItem);

        menuBar.add(menu);
        menuBar.add(action);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private ActionListener getOpenItemListener(JFileChooser fileChooser) {
        return e -> {
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();;
                controller.open(file);
            }
        };
    }

    private ActionListener getSaveItemListener(JFileChooser fileChooser) {
        return e -> {
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();;
                controller.save(file);
            }
        };
    }

    private ActionListener getCreateItemListener() {
        NewWindow window = new NewWindow(controller);
        return e -> window.show();
    }

    private ActionListener getDeleteItemListener() {
        DeleteWindow window = new DeleteWindow(controller);
        return e -> window.show();
    }

    private ActionListener getSearchItemListener() {
        SearchWindow window = new SearchWindow(controller);
        return e -> window.show();
    }
}
