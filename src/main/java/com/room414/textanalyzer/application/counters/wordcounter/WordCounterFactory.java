package com.room414.textanalyzer.application.counters.wordcounter;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordCounterFactory {
    private static WordCounterFactory ourInstance = new WordCounterFactory();

    private Set<String> wordToCount = null;

    public static WordCounterFactory getInstance() {
        return ourInstance;
    }

    private WordCounterFactory() {
    }

    public WordCounter CreateWordCounter() {
        if (wordToCount == null) {
            throw new IllegalStateException("No word to count");
        }

        return new WordCounter();
    }

    public void setWordToCount(Set<String> wordToCount) {
        this.wordToCount = wordToCount;
    }
}
