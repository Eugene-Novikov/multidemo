package com.example.core.alg;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class TextAnalyzer {

    private static final String DELIMITERS_REGEX = "[\\s\\.\\,\\!\\?\\:\\-]";

    public Map<String, Integer> findMostCommonWords(String text, Integer topN) {
        text = Optional.ofNullable(text).map(String::trim).orElse("");
        if (StringUtils.isBlank(text)) {
            return Collections.emptyMap();
        }

        var words = text.split(DELIMITERS_REGEX);
        var wordSumMap = new HashMap<String, Integer>(words.length);
        var max = 0;

        for (String word : words) {
            if (StringUtils.isBlank(word)) {
                continue;
            }
            word = word.toLowerCase();

            Integer currentQuantity = wordSumMap.get(word);
            if (currentQuantity == null) {
                wordSumMap.put(word, 1);
                if (max == 0) max = 1;// for first element: "Hello world!"
            } else {
                var quantity = ++currentQuantity;
                wordSumMap.put(word, quantity);
                if (quantity > max) max = quantity;
            }
        }

        topN = topN != null ? topN : 1;
        if (topN == 1) {
            int finalMax = max;
            return wordSumMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == finalMax)
                    .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        var sumTS = new TreeSet<>(wordSumMap.values());
        var topNMax = new HashMap<Integer, Object>(topN);
        for (int i = 0; i < topN; i++) {
            topNMax.put(sumTS.pollLast(), null);
        }

        return wordSumMap.entrySet().stream()
                .filter(entry -> topNMax.containsKey(entry.getValue()))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Integer> findMostCommonWordsFromFile(String filePath, Integer topN) {
        try {
            File file = new ClassPathResource(filePath).getFile();
            String fileText = new String(Files.readAllBytes(file.toPath()));
            return findMostCommonWords(fileText, topN);
        } catch (IOException e) {
            System.err.println("No file with such name in resources");
            return Collections.emptyMap();
        }
    }
}
