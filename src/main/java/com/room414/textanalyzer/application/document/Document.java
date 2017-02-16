package com.room414.textanalyzer.application.document;

import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Document extends DocumentComponent {
    private List<DocumentComponent> components = new LinkedList<>();

    public void addComponent(DocumentComponent component) {
        components.add(component);
    }

    @Override
    public void countWords() {
        components.forEach(DocumentComponent::countWords);
    }
}
