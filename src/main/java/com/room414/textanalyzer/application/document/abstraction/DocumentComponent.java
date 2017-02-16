package com.room414.textanalyzer.application.document.abstraction;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public abstract class DocumentComponent {
    protected List<DocumentComponent> components = new LinkedList<>();

    public void addComponent(DocumentComponent component) {
        components.add(component);
    }

    public void forEach(Consumer<? super DocumentComponent> consumer) {
        components.forEach(consumer);
    }

    public void forEach(IndexedConsumer<? super DocumentComponent> consumer) {
        int i = 0;

        for (DocumentComponent component : components) {
            consumer.accept(i, component);
            i++;
        }
    }

}
