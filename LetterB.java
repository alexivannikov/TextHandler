package com.company.letters;

import java.util.HashMap;
import java.util.Map;

public class LetterB {
    private static Map<String, String> words = new HashMap <>();{
        words.put("bat", "летучая мышь");
        words.put("big", "большой");
        words.put("black", "черный");
    }

    public LetterB(){

    }

    public String getWord(String word){
        String result = "";

        if(words.containsKey(word) == true){
            result = words.get(word);
        }
        else{
            result = word;
        }

        return result;
    }


}
