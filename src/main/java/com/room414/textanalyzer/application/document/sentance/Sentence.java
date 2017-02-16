package com.room414.textanalyzer.application.document.sentance;

import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;
import com.room414.textanalyzer.application.visitor.CountVisitorFactory;
import com.room414.textanalyzer.application.visitor.interfaces.Element;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Sentence extends DocumentComponent {
    private List<Element> elements = new LinkedList<>();
    private Visitor visitor = CountVisitorFactory.getInstance().create(this);
    private int number;

    Sentence(int number) {
        this.number = number;
    }

    void addElement(Element element) {
        elements.add(element);
    }

    @Override
    public void countWords() {
        elements.forEach(e -> e.accept(visitor));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        elements.forEach(e -> stringBuilder.append(e.toString()));

        return stringBuilder.toString();
    }
}
