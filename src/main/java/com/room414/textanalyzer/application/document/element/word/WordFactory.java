package com.room414.textanalyzer.application.document.element.word;

import com.room414.textanalyzer.application.document.element.ElementFactory;
import com.room414.textanalyzer.application.visitor.interfaces.Element;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordFactory implements ElementFactory {
    private static WordFactory ourInstance = new WordFactory();

    public static WordFactory getInstance() {
        return ourInstance;
    }

    private Map<String, Word> pool = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private WordFactory() {
    }

    @Override
    public Word create(String string) {
        return pool.computeIfAbsent(string, Word::new);
    }
}
