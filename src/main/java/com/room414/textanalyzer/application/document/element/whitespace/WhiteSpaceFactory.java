package com.room414.textanalyzer.application.document.element.whitespace;

import com.room414.textanalyzer.application.document.abstraction.ComponentFactory;
import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WhiteSpaceFactory implements ComponentFactory {
    private static WhiteSpaceFactory ourInstance = new WhiteSpaceFactory();

    public static WhiteSpaceFactory getInstance() {
        return ourInstance;
    }

    private WhiteSpaceFactory() {
    }

    @Override
    public DocumentComponent create(String string) {
        return null;
    }
}
