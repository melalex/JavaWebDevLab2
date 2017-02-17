package com.room414.textanalyzer.application.document.element.whitespace;

import com.room414.textanalyzer.application.document.element.ElementFactory;
import com.room414.textanalyzer.application.visitor.interfaces.Element;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WhiteSpaceFactory implements ElementFactory {
    private static WhiteSpaceFactory ourInstance = new WhiteSpaceFactory();

    public static WhiteSpaceFactory getInstance() {
        return ourInstance;
    }

    private WhiteSpace space = new WhiteSpace(" ");

    private WhiteSpaceFactory() {
    }

    @Override
    public WhiteSpace create(String string) {
        return space;
    }
}
