package com.company.letters;

import java.util.HashMap;
import java.util.Map;

public class LetterB extends AbstractLetter{
    public String result;
    private static Map<String, String> words = new HashMap <>();{
        words.put("bat", "летучая мышь");
        words.put("big", "большой");
        words.put("black", "черный");
    }

    public LetterB(String word){
        result = super.getWord(words, word);
    }
}
