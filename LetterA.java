package com.company.letters;

import java.util.HashMap;
import java.util.Map;

public class LetterA extends AbstractLetter{
    public String result;
    private static Map<String, String> words = new HashMap <>();{
        words.put("alphabet", "алфавит");
        words.put("ant", "муравей");
        words.put("any", "любой");
    }

    public LetterA(String word){
        result = super.getWord(words, word);
    }
}
