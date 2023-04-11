package com.github.yoruhinda.texteditor.view;

import com.github.yoruhinda.texteditor.view.menu.FileMenu;
import com.github.yoruhinda.texteditor.view.panel.EditorPanel;
import com.github.yoruhinda.texteditor.view.panel.TextPanel;

import javax.swing.*;
import java.awt.*;

public class TextEditorFrame extends JFrame {
    private final int WIDTH = 500, HEIGHT = 500;
    private FileMenu fileMenu = new FileMenu();
    private TextPanel textPanel = new TextPanel();
    private EditorPanel editorPanel = new EditorPanel();

    public TextEditorFrame(){
        initializeFrame();
    }

    private void initializeFrame(){
        setLayout(new BorderLayout());
        setTitle("Text Editor");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setJMenuBar(fileMenu);
        add(textPanel, BorderLayout.CENTER);
        add(editorPanel, BorderLayout.NORTH);
        setVisible(true);
    }
}
