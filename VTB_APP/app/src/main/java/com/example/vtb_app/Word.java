package com.example.vtb_app;

import java.util.Objects;

public class Word {

    private String RussianWord;
    private String EnglishWord;

    public Word(String russianWord, String englishWord) {
        RussianWord = russianWord;
        EnglishWord = englishWord;
    }

    public String getRussianWord() {
        return RussianWord;
    }

    public String getEnglishWord() {
        return EnglishWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!RussianWord.equals(word.RussianWord)) return false;
        return EnglishWord.equals(word.EnglishWord);
    }

    @Override
    public int hashCode() {
        int result = RussianWord.hashCode();
        result = 31 * result + EnglishWord.hashCode();
        return result;
    }
}
