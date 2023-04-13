package com.github.yoruhinda.texteditor.listener;

import com.github.yoruhinda.texteditor.controller.TextEditorController;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontChooseListener implements ItemListener {
    private TextEditorController textEditorController;

    public FontChooseListener(TextEditorController textEditorController) {
        this.textEditorController = textEditorController;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() instanceof String) {
            String fontName = (String) e.getItem();
            Font font = textEditorController.findFontByName(fontName);
            textEditorController.changeTextFont(font);
        }
    }
}
