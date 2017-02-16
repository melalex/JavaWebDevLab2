package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.element.word.Word;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordCounter {
    private Set<String> wordsToSearch;
    private Map<String, MutableInt> map = new HashMap<>();
    private Sentence sentence;
    private int sentenceNumber;

    private static class MutableInt {
        private int value = 1;

        void increment() {
            ++value;
        }

        int get() {
            return value;
        }
    }

    WordCounter(Set<String> wordsToSearch) {
        this.wordsToSearch = wordsToSearch;
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }

    void setSentenceNumber(int sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }

    private void incrementCount(String word) {
        MutableInt count = map.get(word);
        if (count == null) {
            map.put(word, new MutableInt());
        } else {
            count.increment();
        }
    }

    private void checkWord(Word word) {
        word.setAsVisited();
        if (wordsToSearch.contains(word.toString())) {
            word.setAsFeet();
            incrementCount(word.toString());
        }
    }

    public void doCount(Word word) {
        if (word.isFeet()) {
            incrementCount(word.toString());
        } else if (!word.isVisited()) {
            checkWord(word);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d: %s\n", sentenceNumber, sentence.toString()));

        map.forEach((k, v) -> stringBuilder.append(String.format("%s -> %d time(s)\n", k, v.get())));

        return stringBuilder.toString();
    }
}
