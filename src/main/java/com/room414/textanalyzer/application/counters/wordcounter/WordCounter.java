package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.element.word.Word;

import java.util.*;
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

        MutableInt() {

        }

        MutableInt(int value) {
            this.value = value;
        }

        void increment() {
            ++value;
        }

        MutableInt sum(MutableInt other) {
            return new MutableInt(this.value + other.value);
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

    private static Map<String, MutableInt> mapSum(Map<String, MutableInt> map1, Map<String, MutableInt> map2) {
        Map<String, MutableInt> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        result.putAll(map1);
        for (String key : map2.keySet()) {
            MutableInt value = result.get(key);
            if (value != null) {
                result.put(key, value.sum(map2.get(key)));
            } else {
                result.put(key, map2.get(key));
            }
        }
        return result;
    }



    public WordCounter sum(WordCounter other) {
        WordCounter result = new WordCounter(wordsToSearch);
        result.map = mapSum(this.map, other.map);
        return result;
    }

    public Map<String, Integer> getMap() {
        return map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().asInteger()));
    }

    public List<Pair<String, Integer>> getSortedMap() {
         return map
                 .entrySet()
                 .stream()
                 .map(e -> new Pair<>(e.getKey(), e.getValue().asInteger()))
                 .sorted(Comparator.reverseOrder())
                 .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (sentence != null) {
            stringBuilder.append(String.format("%d: %s\n", sentence.getNumber(), sentence.toString()));
        }

        List<Pair<String, Integer>> sortedMap = getSortedMap();

        sortedMap.forEach(p -> stringBuilder.append(String.format(
                "%s -> %d time(s)\n",
                p.getFirstValue(),
                p.getSecondValue()
        )));

        return stringBuilder.toString();
    }
}
