package com.github.yoruhinda.texteditor.view.panel;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel {
    private JLabel fontLabel = new JLabel("Font:");
    private JComboBox<String> fonts = new JComboBox<>();
    private JButton color = new JButton("Color");
    private JSpinner fontSize = new JSpinner(new SpinnerNumberModel(20, 8, 100, 1));

    public EditorPanel() {
        initialize();
    }

    private void initialize() {
        for (String availableFontFamilyName : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
            fonts.addItem(availableFontFamilyName);
        }
        ((JSpinner.DefaultEditor) fontSize.getEditor()).getTextField().setEditable(false);
        color.setFocusPainted(false);
        add(fontLabel);
        add(fonts);
        add(color);
        add(fontSize);
    }

    public JComboBox<String> getFonts() {
        return fonts;
    }

    public JButton getColor() {
        return color;
    }

    public JSpinner getFontSize() {
        return fontSize;
    }
}
