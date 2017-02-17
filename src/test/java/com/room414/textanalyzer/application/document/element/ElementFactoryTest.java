package com.room414.textanalyzer.application.document.element;

import com.room414.textanalyzer.application.document.element.charelement.CharElementFactory;
import com.room414.textanalyzer.application.document.element.whitespace.WhiteSpaceFactory;
import com.room414.textanalyzer.application.document.element.word.WordFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
class ElementFactoryTest {
    @TestFactory
    List<DynamicTest> createTests() {
        List<DynamicTest> tests = new LinkedList<>();
        tests.add(DynamicTest.dynamicTest(
                "WordFactory test",
                () -> ElementFactoryTest_pool(WordFactory.getInstance())
        ));
        tests.add(DynamicTest.dynamicTest(
                "WhiteSpaceFactory test",
                () -> ElementFactoryTest_pool(WhiteSpaceFactory.getInstance())
        ));
        tests.add(DynamicTest.dynamicTest(
                "CharElementFactory test",
                () -> ElementFactoryTest_pool(CharElementFactory.getInstance())
        ));
        return tests;
    }

    private void ElementFactoryTest_pool(ElementFactory factory) {
        String element = "test";

        assert factory.create(element) == factory.create(element);
    }

}