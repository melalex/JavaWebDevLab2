package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public WordCounter getWordCounter(Sentence sentence, int sentenceNumber) {
        if (wordsToCount == null) {
            throw new IllegalStateException("No word to count");
        }

        WordCounter wordCounter = pool.getLast();

        if (!wordCounter.isEmpty()) {
            wordCounter = new WordCounter(wordsToCount);
        } else {
            wordCounter.setSentence(sentence);
            wordCounter.setSentenceNumber(sentenceNumber);
        }

        return wordCounter;
    }

    public void setWordsToCount(Set<String> wordsToCount) {
        this.wordsToCount = wordsToCount;
    }

    public List<WordCounter> getPool() {
        return (List<WordCounter>) pool.clone();
    }
}
