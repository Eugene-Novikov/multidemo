package com.example.core.alg;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextAnalyzerTest {

    @Test
    void testNoSuchFile() {
        var words = new TextAnalyzer().findMostCommonWordsFromFile("no-such-file.txt", null);
        assertTrue(words.isEmpty());
    }

    @Test
    void testSuccessFileReading() {
        var words = new TextAnalyzer().findMostCommonWordsFromFile("text/initial.txt", null);
        assertFalse(words.isEmpty());
        assertEquals(2, words.size());
        assertEquals(Map.of("hello", 1, "world", 1), words);
    }

    @Test
    void testNullText() {
        var words = new TextAnalyzer().findMostCommonWords(null, null);
        assertTrue(words.isEmpty());
    }

    @Test
    void testEmptyText() {
        var words = new TextAnalyzer().findMostCommonWords("", null);
        assertTrue(words.isEmpty());
    }

    @Test
    void testTop1MostCommonWord() {
        var words = new TextAnalyzer().findMostCommonWords("Hello world from my world!", null);
        assertFalse(words.isEmpty());
        assertEquals(1, words.size());
        assertEquals(Map.of("world", 2), words);
    }

    @Test
    void testTop2MostCommonWords() {
        var words = new TextAnalyzer().findMostCommonWords("Hello world from my world, hello, wow, from true: is you! Hello guys. Hello from humanities in whole the world? World - is a cool place!", 2);
        assertFalse(words.isEmpty());
        assertEquals(3, words.size());
        assertEquals(Map.of("world", 4, "hello", 4, "from", 3), words);
    }

    @Test
    void testTop1MostCommonWordFromBigFile() {
        var words = new TextAnalyzer().findMostCommonWordsFromFile("text/big-file.txt", 5);
    }
}
