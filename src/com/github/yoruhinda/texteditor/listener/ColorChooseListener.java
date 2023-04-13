package com.github.yoruhinda.texteditor.listener;

import com.github.yoruhinda.texteditor.controller.TextEditorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooseListener implements ActionListener {
    private TextEditorController textEditorController;

    public ColorChooseListener(TextEditorController textEditorController) {
        this.textEditorController = textEditorController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton colorButton = (JButton) e.getSource();
            if (colorButton.getText().equalsIgnoreCase("color")) {
                Color chooseColor = JColorChooser.showDialog(colorButton, "Choose Color", Color.BLACK);
                textEditorController.changeTextColor(chooseColor);
            }
        }
    }
}
