package com.room414.textanalyzer.application.visitor;

import com.room414.textanalyzer.application.counters.wordcounter.WordCounter;
import com.room414.textanalyzer.application.counters.wordcounter.WordCounterPool;
import com.room414.textanalyzer.application.document.element.charelement.CharElement;
import com.room414.textanalyzer.application.document.element.whitespace.WhiteSpace;
import com.room414.textanalyzer.application.document.element.word.Word;
import com.room414.textanalyzer.application.document.sentance.Sentence;
import com.room414.textanalyzer.application.visitor.interfaces.Visitor;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class CountVisitor implements Visitor {
    private WordCounter wordCounter;


    CountVisitor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    void setWordCounter(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @Override
    public void visit(Word word) {
        wordCounter.doCount(word);
    }

    @Override
    public void visit(WhiteSpace whiteSpace) {

    }

    @Override
    public void visit(CharElement charElement) {

    }
}
