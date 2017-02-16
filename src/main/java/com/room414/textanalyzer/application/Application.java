package com.room414.textanalyzer.application;

import com.room414.textanalyzer.application.counters.wordcounter.WordCounter;
import com.room414.textanalyzer.application.counters.wordcounter.WordCounterPool;
import com.room414.textanalyzer.application.document.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Application {

    public List<WordCounter> analyse(String path, String[] wordsToCount) throws FileNotFoundException{
        WordCounterPool factory = WordCounterPool.getInstance();
        factory.setWordsToCount(new HashSet<>(Arrays.asList(wordsToCount)));
        try (Scanner sentence = new Scanner(new File(path)).useDelimiter("\\.")) {
            Document document = new Document();
            while (sentence.hasNext()) {
                document.add(sentence.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return factory.getPool();
    }
}
