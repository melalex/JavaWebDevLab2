package com.room414.textanalyzer.application.counters.wordcounter;

import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.document.sentance.SentenceFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
class WordCounterPoolTest {
    @Test
    void getWordCounter_normal() {
        WordCounterPool.getInstance().setWordsToCount(Arrays.asList(
                "asd",
                "bsd",
                "qwe",
                "fgh",
                "tyu",
                "iop"
        ));
        Sentence sentence = SentenceFactory.getInstance().create("asd");

        WordCounterPool.getInstance().getWordCounter(sentence);
    }

    @Test
    void setWordsToCount_exception() {
        assertThrows(
                IllegalArgumentException.class,
                () -> WordCounterPool.getInstance().setWordsToCount(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> WordCounterPool.getInstance().setWordsToCount(Arrays.asList(
                        "asd",
                        "bsd",
                        null,
                        "fgh",
                        "tyu",
                        "iop"
                ))
        );
    }

}