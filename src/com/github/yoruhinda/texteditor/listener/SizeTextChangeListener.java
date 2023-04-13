package com.github.yoruhinda.texteditor.listener;

import com.github.yoruhinda.texteditor.controller.TextEditorController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SizeTextChangeListener implements ChangeListener {
    private TextEditorController textEditorController;

    public SizeTextChangeListener(TextEditorController textEditorController) {
        this.textEditorController = textEditorController;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JSpinner) {
            JSpinner spinner = (JSpinner) e.getSource();
            Integer value = (Integer) spinner.getValue();
            textEditorController.changeTextSize(value.floatValue());
        }
    }
}
