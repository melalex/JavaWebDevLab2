package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordCounterFactory {
    private static WordCounterFactory ourInstance = new WordCounterFactory();

    private Set<String> wordToCount = null;
    private LinkedList<WordCounter> pool = new LinkedList<>();

    public static WordCounterFactory getInstance() {
        return ourInstance;
    }

    private WordCounterFactory() {
    }

    public WordCounter CreateWordCounter(Sentence sentence, int sentenceNumber) {
        if (wordToCount == null) {
            throw new IllegalStateException("No word to count");
        }

        return new WordCounter();
    }

    public void setWordToCount(Set<String> wordToCount) {
        this.wordToCount = wordToCount;
    }

    public List<WordCounter> getPool() {
        return (List<WordCounter>) pool.clone();
    }
}
