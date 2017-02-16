package com.room414.textanalyzer.application.document.abstraction;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public interface Element {
    void accept(Visitor visitor);
}
