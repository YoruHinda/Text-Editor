package com.github.yoruhinda.texteditor.view.panel;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JEditorPane textEditor = new JEditorPane();
    private JScrollPane jScrollPane = new JScrollPane(textEditor);

    public TextPanel() {
        initialize();
    }

    private void initialize() {
        textEditor.setPreferredSize(new Dimension(450, 380));
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(jScrollPane);
    }

    public JEditorPane getTextEditor() {
        return textEditor;
    }
}
