package com.room414.textanalyzer.application.document.element.word;

import com.room414.textanalyzer.application.document.element.ElementFactory;
import com.room414.textanalyzer.application.visitor.interfaces.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordFactory implements ElementFactory {
    private static WordFactory ourInstance = new WordFactory();

    public static WordFactory getInstance() {
        return ourInstance;
    }

    private Map<String, Word> pool = new HashMap<>();

    private WordFactory() {
    }

    @Override
    public Element create(String string) {
        return pool.computeIfAbsent(string, Word::new);
    }
}
