package com.room414.textanalyzer.application.document.element.word;

import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;
import com.room414.textanalyzer.application.visitor.interfaces.Element;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Word extends DocumentComponent implements Element {
    private boolean isVisited = false;
    private boolean isFeet = false;
    private String string;

    Word(String string) {
        this.string = string;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setAsVisited() {
        isVisited = true;
    }

    public boolean isFeet() {
        return isFeet;
    }

    public void setAsFeet() {
        isFeet = true;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
