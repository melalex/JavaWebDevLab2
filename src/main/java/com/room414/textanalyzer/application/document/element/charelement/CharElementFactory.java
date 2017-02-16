package com.room414.textanalyzer.application.document.element.charelement;

import com.room414.textanalyzer.application.document.abstraction.ComponentFactory;
import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class CharElementFactory implements ComponentFactory {
    private static CharElementFactory ourInstance = new CharElementFactory();

    public static CharElementFactory getInstance() {
        return ourInstance;
    }
    private Map<String, CharElement> pool = new HashMap<>();

    private CharElementFactory() {
    }

    @Override
    public DocumentComponent create(String string) {
        return pool.computeIfAbsent(string, CharElement::new);
    }

}
