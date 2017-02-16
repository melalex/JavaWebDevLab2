package com.room414.textanalyzer.application.visitor;

import com.room414.textanalyzer.application.counters.wordcounter.WordCounter;
import com.room414.textanalyzer.application.counters.wordcounter.WordCounterPool;
import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class CountVisitorFactory {
    private static CountVisitorFactory ourInstance = new CountVisitorFactory();

    public static CountVisitorFactory getInstance() {
        return ourInstance;
    }

    private WordCounterPool wordCounterPool = WordCounterPool.getInstance();
    private CountVisitor visitor;

    private CountVisitorFactory() {

    }

    public Visitor create(Sentence sentence) {
        WordCounter wordCounter = wordCounterPool.getWordCounter(sentence);
        if (visitor == null) {
            visitor = new CountVisitor(wordCounter);
        } else {
            visitor.setWordCounter(wordCounter);
        }

        return visitor;
    }
}
