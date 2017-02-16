package com.room414.textanalyzer.application.document.element.word;

import com.room414.textanalyzer.application.document.abstraction.ComponentFactory;
import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordFactory implements ComponentFactory {
    private static WordFactory ourInstance = new WordFactory();

    public static WordFactory getInstance() {
        return ourInstance;
    }

    private WordFactory() {
    }

    @Override
    public DocumentComponent create(String string) {
        return null;
    }
}
