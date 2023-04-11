package com.github.yoruhinda.texteditor.view.menu;

import javax.swing.*;

public class FileMenu extends JMenuBar {
    private JMenu menu = new JMenu("File");
    private JMenuItem openFileItem = new JMenuItem("Open");
    private JMenuItem saveFileItem = new JMenuItem("Save");
    private JMenuItem closeFileItem = new JMenuItem("Close");

    public FileMenu(){
        add(menu);
        menu.add(openFileItem);
        menu.add(saveFileItem);
        menu.add(closeFileItem);
    }
}
