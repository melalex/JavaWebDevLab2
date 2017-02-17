package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.element.word.Word;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class WordCounter {
    private Set<String> wordsToSearch;
    private Map<String, MutableInt> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Sentence sentence;

    private static class MutableInt {
        private int value = 1;

        void increment() {
            ++value;
        }

        int get() {
            return value;
        }

        Integer asInteger() {
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

    public Map<String, Integer> getMap() {
        return map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().asInteger()));
    }

    public Map<String, Integer> getSortedMap() {
        return map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result;
                    if (e1.getValue().get() != e2.getValue().get()) {
                        result = e1.getValue().get() - e2.getValue().get();
                    } else {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().asInteger()));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d: %s\n", sentence.getNumber(), sentence.toString()));

        Map<String, Integer> sortedMap = getSortedMap();

        sortedMap.forEach((k, v) -> stringBuilder.append(String.format("%s -> %d time(s)\n", k, v)));

        return stringBuilder.toString();
    }
}
