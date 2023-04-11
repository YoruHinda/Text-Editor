package com.github.yoruhinda.texteditor.view.panel;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JEditorPane editorPane = new JEditorPane();
    private JScrollPane jScrollPane = new JScrollPane(editorPane);

    public TextPanel() {
        initialize();
    }

    private void initialize(){
        editorPane.setPreferredSize(new Dimension(450,380));
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(jScrollPane);
    }
}
