package com.backend;

import java.util.List;
import java.util.Scanner;
import static com.backend.Parser.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();
        StringBuffer inputBuffer = new StringBuffer(inputText);

        List<StringBuffer> sentencesList = Parser.splitSentences(inputBuffer);
        List<StringBuffer> wordsList = Parser.splitWords(sentencesList);
        List<StringBuffer> sortedList = Parser.sortByVowelCount(wordsList);
        List<List<StringBuffer>> groupedWords = groupByVowelCount(sortedList);

        System.out.println("Split Sentences: " + sentencesList);
        System.out.println("Split Words: " + wordsList);
        System.out.println("Sorted Words by Vowel Count: " + sortedList);

        for (int i = 0; i < groupedWords.size(); i++) {
            List<StringBuffer> words = groupedWords.get(i);

            if (!words.isEmpty()) {
                System.out.println(i + " vowels: " + words);
            }
        }

    }
}