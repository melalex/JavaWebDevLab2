package com.room414.textanalyzer.application;

import com.room414.textanalyzer.application.counters.wordcounter.WordCounter;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
class ApplicationTest {
    @Test
    void analyse() {
        Application application = new Application();
        try {
            List<WordCounter> wordCounters = application.analyse(
                    "/home/melalex/Projects/Epam/Labs/Lab2/JavaWebDevLab2/lorem.txt",
                    new String[] {"lorem"}
            );
            wordCounters.forEach(r -> System.out.println(r.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}