package com.backend;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    /**
     *
     * @param text - text from input
     * @return sentencesList - Array that include separated sentences
     */
    
    public static List<StringBuffer> splitSentences(StringBuffer text) {
        List<StringBuffer> sentencesList = new ArrayList<>();
        StringBuffer currentSentence = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            currentSentence.append(c);

            if (isSentenceEndingCharacter(c)) {
                String sentenceToAdd = removeSentenceEndingCharacters(currentSentence.toString()).trim();
                sentencesList.add(new StringBuffer(sentenceToAdd));
                currentSentence = new StringBuffer();
            }
        }

        if (!currentSentence.isEmpty()) {
            String lastSentence = removeSentenceEndingCharacters(currentSentence.toString()).trim();
            sentencesList.add(new StringBuffer(lastSentence));
        }

        return sentencesList;
    }

    /**
     *
     * @param character - symbols from text
     * @return checking template
     */

    private static boolean isSentenceEndingCharacter(char character) {
        return character == '.' || character == '!' || character == '?';
    }

    /**
     *
     * @param sentence - current sentence
     * @return sentence that exclude ending symbol
     */

    private static String removeSentenceEndingCharacters(String sentence) {
        StringBuilder result = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (!isSentenceEndingCharacter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     *
     * @param sentencesList - Array from previous method splitSentences
     * @return Array that includes all words (not in lower case)
     */

    public static List<StringBuffer> splitWords(List<StringBuffer> sentencesList) {
        List<StringBuffer> wordsList = new ArrayList<>();
        StringBuffer currentWord = new StringBuffer();

        for (StringBuffer sentence : sentencesList) {
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    currentWord.append(c);
                } else {
                    if (currentWord.length() > 0) {
                        wordsList.add(new StringBuffer(currentWord.toString()));
                        currentWord.setLength(0);
                    }
                }
            }
        }

        if (currentWord.length() > 0) {
            wordsList.add(new StringBuffer(currentWord.toString()));
        }

        return wordsList;
    }

    /**
     *
     * @param word - word from list of words
     * @return list of letters
     */

    public static List<StringBuffer> splitLetters(StringBuffer word) {
        List<StringBuffer> lettersList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            lettersList.add(new StringBuffer(Character.toString(word.charAt(i))));
        }
        return lettersList;
    }

    /**
     *
     * @param word - word from list of words
     * @return integer, that indicates how much vowels we have in word
     */

    public static int countVowels(StringBuffer word) {
        List<StringBuffer> lettersList = splitLetters(word);
        int vowelCount = 0;

        for (StringBuffer letter : lettersList) {
            char c = Character.toLowerCase(letter.charAt(0));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    /**
     *
     * @param wordsList - Array from previous method splitWords
     * @return list of words that sorted from fewer vowels to most
     */

    public static List<StringBuffer> sortByVowelCount(List<StringBuffer> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            for (int j = 0; j < wordsList.size() - i - 1; j++) {
                int count1 = countVowels(wordsList.get(j));
                int count2 = countVowels(wordsList.get(j + 1));

                if (count1 > count2) {
                    // Обмін елементів, якщо потрібно
                    StringBuffer temp = wordsList.get(j);
                    wordsList.set(j, wordsList.get(j + 1));
                    wordsList.set(j + 1, temp);
                }
            }
        }

        return wordsList;
    }

    /**
     *
     * @param wordsList - Array from previous method sortByVowelCount
     * @return Array of an Array from words like 1: pa, 2: para, 3: parara...
     */

    public static List<List<StringBuffer>> groupByVowelCount(List<StringBuffer> wordsList) {
        List<List<StringBuffer>> groupedWords = new ArrayList<>();
        List<StringBuffer> sortedList = sortByVowelCount(wordsList);

        int maxVowelCount = getMaxVowelCount(sortedList);

        for (int i = 0; i <= maxVowelCount; i++) {
            groupedWords.add(new ArrayList<>());
        }

        for (StringBuffer word : sortedList) {
            int vowelsCount = countVowels(word);
            groupedWords.get(vowelsCount).add(word);
        }

        return groupedWords;
    }

    /**
     *
     * @param wordsList - Array that have one-type value of vowels
     * @return integer, that indicates max value of vowels in every word
     */

    public static int getMaxVowelCount(List<StringBuffer> wordsList) {
        int maxVowelCount = 0;

        for (StringBuffer word : wordsList) {
            int vowelsCount = countVowels(word);
            maxVowelCount = Math.max(maxVowelCount, vowelsCount);
        }

        return maxVowelCount;
    }
}