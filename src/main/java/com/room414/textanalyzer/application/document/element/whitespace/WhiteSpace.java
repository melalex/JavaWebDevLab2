package com.room414.textanalyzer.application.document.element.whitespace;

import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;
import com.room414.textanalyzer.application.visitor.interfaces.Element;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WhiteSpace extends DocumentComponent implements Element {
    private String whiteSpace;

    public WhiteSpace(String whiteSpace) {
        this.whiteSpace = whiteSpace;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return whiteSpace;
    }
}
