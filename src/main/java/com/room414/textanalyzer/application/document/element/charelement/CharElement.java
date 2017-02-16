package com.room414.textanalyzer.application.document.element.charelement;

import com.room414.textanalyzer.application.visitor.interfaces.Element;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class CharElement implements Element {
    private String aChar;

    public CharElement(String aChar) {
        this.aChar = aChar;
    }

    public String getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        return String.valueOf(aChar);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
