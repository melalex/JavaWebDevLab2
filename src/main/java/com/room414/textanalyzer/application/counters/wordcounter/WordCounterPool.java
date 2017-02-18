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

    private Set<String> wordsToCount = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);;
    private LinkedList<WordCounter> pool = new LinkedList<>();

    public static WordCounterPool getInstance() {
        return ourInstance;
    }

    private WordCounterPool() {
        pool.add(new WordCounter(this.wordsToCount));
    }

    public WordCounter getWordCounter(Sentence sentence) {
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
        if (wordsToCount == null) {
            throw new IllegalArgumentException("wordsToCount can't be null");
        }

        if (wordsToCount.contains(null)) {
            throw new IllegalArgumentException("wordsToCount can't contain null");
        }

        this.wordsToCount.clear();
        this.wordsToCount.addAll(wordsToCount);
    }

    public List<WordCounter> getPool() {
        LinkedList<WordCounter> result = (LinkedList<WordCounter>) pool.clone();
        if (result.getLast().isEmpty()) {
            result.removeLast();
        }
        return result;
    }
}
