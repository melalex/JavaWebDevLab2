package com.room414.textanalyzer.application.document.sentance;

import com.room414.textanalyzer.application.document.abstraction.ComponentFactory;
import com.room414.textanalyzer.application.document.abstraction.DocumentComponent;
import com.room414.textanalyzer.application.document.element.charelement.CharElementFactory;
import com.room414.textanalyzer.application.document.element.whitespace.WhiteSpaceFactory;
import com.room414.textanalyzer.application.document.element.word.WordFactory;

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

    private ComponentFactory wordFactory = WordFactory.getInstance();
    private ComponentFactory whiteSpaceFactory = WhiteSpaceFactory.getInstance();
    private ComponentFactory charElementFactory = CharElementFactory.getInstance();

    private SentenceFactory() {
    }

    @Override
    public Sentence create(String sentence) {
        Sentence sentenceObj = new Sentence();
        Matcher splitMatcher = SPLIT_PATTERN.matcher(sentence);
        Matcher wordMatcher;
        Matcher whiteSpaceMatcher;
        DocumentComponent component;
        String match;

        while (splitMatcher.find()) {
            for (int i = 1; i <= splitMatcher.groupCount(); i++) {
                match = splitMatcher.group(i);
                wordMatcher = WORD_PATTERN.matcher(match);
                whiteSpaceMatcher = WHITE_SPACE_PATTERN.matcher(match);

                if (wordMatcher.matches()) {
                    component = wordFactory.create(match);
                } else if(whiteSpaceMatcher.matches()) {
                    component = whiteSpaceFactory.create(match);
                } else {
                    component = charElementFactory.create(match);
                }

                sentenceObj.addComponent(component);
            }
        }

        return sentenceObj;
    }
}
