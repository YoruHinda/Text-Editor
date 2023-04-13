package com.github.yoruhinda.texteditor.manager;

import com.github.yoruhinda.texteditor.listener.FileListener;
import com.github.yoruhinda.texteditor.view.TextEditorFrame;
import com.github.yoruhinda.texteditor.view.menu.FileMenu;
import com.github.yoruhinda.texteditor.view.panel.TextPanel;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private FileListener fileListener = new FileListener(this);
    private TextEditorFrame textEditorFrame;
    private TextPanel textPanel;
    private FileMenu fileMenu;

    public FileManager(TextEditorFrame textEditorFrame, FileMenu fileMenu, TextPanel textPanel) {
        this.textEditorFrame = textEditorFrame;
        this.fileMenu = fileMenu;
        this.textPanel = textPanel;
        initializeListener();
    }

    private void initializeListener() {
        fileMenu.getSaveFileItem().addActionListener(fileListener);
        fileMenu.getOpenFileItem().addActionListener(fileListener);
        fileMenu.getCloseFileItem().addActionListener(fileListener);
    }

    public void save() {
        FileDialog saveTxtFile = new FileDialog(textEditorFrame, "Save Txt File", FileDialog.SAVE);
        saveTxtFile.setDirectory("C:\\");
        saveTxtFile.setVisible(true);
        String fileName = saveTxtFile.getDirectory() + saveTxtFile.getFile() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(textPanel.getTextEditor().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() {
        FileDialog openTxtDialog = new FileDialog(textEditorFrame, "Open Txt File", FileDialog.LOAD);
        openTxtDialog.setDirectory("C:\\");
        openTxtDialog.setFile(".txt");
        openTxtDialog.setVisible(true);
        String fileName = openTxtDialog.getDirectory() + openTxtDialog.getFile();
        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();
        try (FileReader fileReader = new FileReader(file);) {
            int content;
            while ((content = fileReader.read()) != -1) {
                fileContent.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textPanel.getTextEditor().setText(fileContent.toString());
    }

    public void close() {
        System.exit(0);
    }
}
