package com.github.yoruhinda.texteditor.view.panel;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel {
    private JLabel fontLabel = new JLabel("Font:");
    private JComboBox<Font> fonts = new JComboBox<>();
    private JButton color = new JButton("Color");
    private JSpinner fontSize = new JSpinner();

    public EditorPanel(){
        add(fontLabel);
        add(fonts);
        add(color);
        add(fontSize);
    }
}
