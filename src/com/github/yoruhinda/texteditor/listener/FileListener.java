package com.github.yoruhinda.texteditor.listener;

import com.github.yoruhinda.texteditor.manager.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileListener implements ActionListener {
    private FileManager fileManager;

    public FileListener(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem source = (JMenuItem) e.getSource();
            if (source.getText().equalsIgnoreCase("save")) {
                fileManager.save();
            }
            if (source.getText().equalsIgnoreCase("open")) {
                fileManager.open();
            }
            if (source.getText().equalsIgnoreCase("close")) {
                fileManager.close();
            }
        }
    }
}
