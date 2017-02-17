package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordCounterPool {
    private static WordCounterPool ourInstance = new WordCounterPool();

    private Set<String> wordsToCount = null;
    private LinkedList<WordCounter> pool = new LinkedList<>();

    public static WordCounterPool getInstance() {
        return ourInstance;
    }

    private WordCounterPool() {

    }

    public WordCounter getWordCounter(Sentence sentence) {
        if (wordsToCount == null) {
            throw new IllegalStateException("No word to count");
        }

        WordCounter wordCounter = pool.getLast();

        if (wordCounter.isEmpty()) {
            wordCounter.setSentence(sentence);
        } else {
            wordCounter = new WordCounter(wordsToCount);
            wordCounter.setSentence(sentence);
            pool.add(wordCounter);
        }

        return wordCounter;
    }

    public void setWordsToCount(List<String> wordsToCount) {
        this.wordsToCount = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        this.wordsToCount.addAll(wordsToCount);
        pool.add(new WordCounter(this.wordsToCount));
    }

    public List<WordCounter> getPool() {
        return (List<WordCounter>) pool.clone();
    }
}
