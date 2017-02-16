package com.room414.textanalyzer.application.document.element.charelement;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class CharElement {
    private String aChar;

    public CharElement(String aChar) {
        this.aChar = aChar;
    }

    public String getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        return String.valueOf(aChar);
    }
}
