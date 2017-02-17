package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.element.word.Word;
import com.room414.textanalyzer.application.document.element.word.WordFactory;
import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.sentance.SentenceFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
class WordCounterTest {
    @Test
    void isEmpty() {
        WordCounterPool.getInstance().setWordsToCount(Arrays.asList("asd", "bsd"));
        Sentence sentence = SentenceFactory.getInstance().create("asd");
        WordCounter counter = WordCounterPool.getInstance().getWordCounter(sentence);
        Word word = WordFactory.getInstance().create("asd");

        assert counter.isEmpty();

        counter.doCount(word);

        assert !counter.isEmpty();
    }

    @Test
    void doCount() {

    }

}