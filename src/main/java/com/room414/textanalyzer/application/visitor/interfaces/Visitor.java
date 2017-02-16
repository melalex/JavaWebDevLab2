package com.room414.textanalyzer.application.visitor.interfaces;

import com.room414.textanalyzer.application.document.element.charelement.CharElement;
import com.room414.textanalyzer.application.document.element.whitespace.WhiteSpace;
import com.room414.textanalyzer.application.document.element.word.Word;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public interface Visitor {
    void visit(Word word);
    void visit(WhiteSpace whiteSpace);
    void visit(CharElement charElement);
}
