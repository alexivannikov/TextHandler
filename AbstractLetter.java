package com.company.letters;

import java.util.Map;

public abstract class AbstractLetter {
    public String getWord(Map<String, String> words, String word){
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
