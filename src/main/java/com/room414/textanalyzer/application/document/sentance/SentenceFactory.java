package com.room414.textanalyzer.application.document.sentance;

import com.room414.textanalyzer.application.document.abstraction.ComponentFactory;
import com.room414.textanalyzer.application.document.element.ElementFactory;
import com.room414.textanalyzer.application.document.element.charelement.CharElementFactory;
import com.room414.textanalyzer.application.document.element.whitespace.WhiteSpaceFactory;
import com.room414.textanalyzer.application.document.element.word.WordFactory;
import com.room414.textanalyzer.application.visitor.interfaces.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class SentenceFactory implements ComponentFactory {
    private static final Pattern SPLIT_PATTERN = Pattern.compile("(\\w+)|(\\s+)|([^a-zA-Z\\d\\s:])");
    private static final Pattern WORD_PATTERN = Pattern.compile("\\w+");
    private static final Pattern WHITE_SPACE_PATTERN = Pattern.compile("\\s+");

    private static SentenceFactory ourInstance = new SentenceFactory();

    public static SentenceFactory getInstance() {
        return ourInstance;
    }

    private ElementFactory wordFactory = WordFactory.getInstance();
    private ElementFactory whiteSpaceFactory = WhiteSpaceFactory.getInstance();
    private ElementFactory charElementFactory = CharElementFactory.getInstance();

    private int sentenceCount = 0;

    private SentenceFactory() {
    }

    @Override
    public Sentence create(String sentence) {
        Sentence sentenceObj = new Sentence(++sentenceCount);
        Matcher splitMatcher = SPLIT_PATTERN.matcher(sentence);
        Matcher wordMatcher;
        Matcher whiteSpaceMatcher;
        Element element;
        String match;

        while (splitMatcher.find()) {
            match = splitMatcher.group(0);
            wordMatcher = WORD_PATTERN.matcher(match);
            whiteSpaceMatcher = WHITE_SPACE_PATTERN.matcher(match);

            if (wordMatcher.matches()) {
                element = wordFactory.create(match);
            } else if(whiteSpaceMatcher.matches()) {
                element = whiteSpaceFactory.create(match);
            } else {
                element = charElementFactory.create(match);
            }

            sentenceObj.addElement(element);
        }

        return sentenceObj;
    }
}
