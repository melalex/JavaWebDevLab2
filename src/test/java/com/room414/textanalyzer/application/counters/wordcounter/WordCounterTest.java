package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.element.word.Word;
import com.room414.textanalyzer.application.document.element.word.WordFactory;
import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.sentance.SentenceFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
class WordCounterTest {
    WordCounterTest() {
        WordCounterPool.getInstance().setWordsToCount(Arrays.asList(
                "asd",
                "bsd",
                "qwe",
                "fgh",
                "tyu",
                "iop"
        ));
    }

    @Test
    void isEmpty_empty() {
        Sentence sentence = SentenceFactory.getInstance().create("asd");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);

        assert counter.isEmpty();
    }

    @Test
    void isEmpty_full() {
        Sentence sentence = SentenceFactory.getInstance().create("asd");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);
        Word word = WordFactory.getInstance().create("asd");

        counter.doCount(word);

        assert !counter.isEmpty();
    }

    @Test
    void doCount_feet() {
        Sentence sentence = SentenceFactory.getInstance().create("bsd");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);
        Word word = WordFactory.getInstance().create("bsd");

        counter.doCount(word);

        Map<String, Integer> map = counter.getMap();

        assert map.get("bsd") != null;
    }

    @Test
    void doCount_un_feet() {
        Sentence sentence = SentenceFactory.getInstance().create("bla-bla");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);
        Word word = WordFactory.getInstance().create("bla");

        counter.doCount(word);

        Map<String, Integer> map = counter.getMap();

        assert map.get("bla") == null;
    }

    @Test
    void doCount_checked() {
        Sentence sentence = SentenceFactory.getInstance().create("qwe");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);
        Word word = WordFactory.getInstance().create("qwe");
        word.setAsVisited();
        word.setAsVisited();

        counter.doCount(word);

        Map<String, Integer> map = counter.getMap();

        assert map.get("qwe") == null;
    }
}