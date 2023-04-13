package com.github.yoruhinda.texteditor.view;

import com.github.yoruhinda.texteditor.controller.TextEditorController;
import com.github.yoruhinda.texteditor.manager.FileManager;
import com.github.yoruhinda.texteditor.view.menu.FileMenu;
import com.github.yoruhinda.texteditor.view.panel.EditorPanel;
import com.github.yoruhinda.texteditor.view.panel.TextPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextEditorFrame extends JFrame {
    private EditorPanel editorPanel = new EditorPanel();
    private TextPanel textPanel = new TextPanel();
    private FileMenu fileMenu = new FileMenu();
    private BufferedImage imageIcon;
    private final int WIDTH = 500, HEIGHT = 500;

    public TextEditorFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        try {
            imageIcon = ImageIO.read(new File("src/com/github/yoruhinda/texteditor/images/text-editor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new TextEditorController(textPanel, editorPanel);
        new FileManager(this, fileMenu, textPanel);
        setLayout(new BorderLayout());
        setTitle("Text Editor");
        setIconImage(imageIcon);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setJMenuBar(fileMenu);
        add(textPanel, BorderLayout.CENTER);
        add(editorPanel, BorderLayout.NORTH);
        setVisible(true);
    }
}
