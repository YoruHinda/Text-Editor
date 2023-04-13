package com.github.yoruhinda.texteditor.controller;

import com.github.yoruhinda.texteditor.listener.ColorChooseListener;
import com.github.yoruhinda.texteditor.listener.FontChooseListener;
import com.github.yoruhinda.texteditor.listener.SizeTextChangeListener;
import com.github.yoruhinda.texteditor.view.panel.EditorPanel;
import com.github.yoruhinda.texteditor.view.panel.TextPanel;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TextEditorController {
    private List<Font> fontList = Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
    private TextPanel textPanel;
    private EditorPanel editorPanel;

    public TextEditorController(TextPanel textPanel, EditorPanel editorPanel) {
        this.textPanel = textPanel;
        this.editorPanel = editorPanel;
        setDefaultFontAndFontSize();
        initializeListener();
    }

    public void initializeListener() {
        editorPanel.getFonts().addItemListener(new FontChooseListener(this));
        editorPanel.getColor().addActionListener(new ColorChooseListener(this));
        editorPanel.getFontSize().addChangeListener(new SizeTextChangeListener(this));
    }

    private void setDefaultFontAndFontSize() {
        Integer defaultFontSize = (Integer) editorPanel.getFontSize().getValue();
        Font font = findFontByName(String.valueOf(editorPanel.getFonts().getSelectedItem())).deriveFont(defaultFontSize.floatValue());
        textPanel.getTextEditor().setFont(font);
    }

    public void changeTextFont(Font font) {
        Integer fontSize = (Integer) editorPanel.getFontSize().getValue();
        Font fontWithSize = font.deriveFont(fontSize.floatValue());
        textPanel.getTextEditor().setFont(fontWithSize);
    }

    public void changeTextColor(Color color) {
        textPanel.getTextEditor().setForeground(color);
    }

    public void changeTextSize(float size) {
        Font sizeChanged = textPanel.getFont().deriveFont(size);
        textPanel.getTextEditor().setFont(sizeChanged);
    }

    public Font findFontByName(String fontName) {
        return fontList.stream().filter(font -> font.getFontName().contains(fontName)).findFirst().orElseThrow(() -> new RuntimeException("Error Find Font!!!"));
    }
}
