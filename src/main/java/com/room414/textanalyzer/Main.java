package com.room414.textanalyzer;

import com.room414.textanalyzer.application.Application;
import com.room414.textanalyzer.application.counters.wordcounter.WordCounter;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Arguments should face pattern \"path/to/file.txt arg1 ... argn\"");
            return;
        }

        try {
            Application application = new Application();
            List<WordCounter> result = application.analyse(args[0], Arrays.copyOfRange(args, 1, args.length - 1));
            result.forEach(r -> System.out.println(r.toString()));

            Optional<WordCounter> globalResultStream = result
                    .stream()
                    .map(w -> w)
                    .reduce((w, r) -> r.sum(w));

            if (globalResultStream.isPresent()) {
                System.out.println("Global result:");
                System.out.println(globalResultStream.get());
            }

        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }
}
