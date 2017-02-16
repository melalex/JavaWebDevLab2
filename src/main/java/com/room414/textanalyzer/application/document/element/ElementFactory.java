package com.room414.textanalyzer.application.document.element;

import com.room414.textanalyzer.application.visitor.interfaces.Element;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public interface ElementFactory {
    Element create(String string);
}
