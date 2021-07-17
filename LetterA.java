package com.company.letters;

import java.util.HashMap;
import java.util.Map;

public class LetterA {
    private static Map<String, String> words = new HashMap <>();{
        words.put("alphabet", "алфавит");
        words.put("ant", "муравей");
        words.put("any", "любой");
    }

    public LetterA(){

    }

    public String getWord(String word){
        String result = "";

        if(words.containsKey(word) == true){
            result = words.get(word);
        }
        else{
            result = null;
        }

        return result;
    }


}
