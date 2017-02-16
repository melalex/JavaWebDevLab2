package com.room414.textanalyzer.application.document.sentance;

import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Sentence extends DocumentComponent {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        components.forEach(c -> stringBuilder.append(c.toString()));

        return stringBuilder.toString();
    }

}
