package com.company;

import com.company.letters.LetterA;
import com.company.letters.LetterB;

import java.io.*;
import java.util.*;

public class TextHandler {
    static ArrayList <String> lineList = new ArrayList();

    public TextHandler(){

    }

    /*Чтение текста из текстового файла*/
    public static ArrayList <String> readFile(String str){
        String line = "";

        if(lineList.isEmpty() != true){
            lineList.clear();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(str))){
            while((line = br.readLine()) != null){
                lineList.add(line);
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return lineList;
    }

    /*Перевод текста в список слов*/
    public static ArrayList <String> getWords(String str) {
        ArrayList <String> wordList = new ArrayList();

        readFile(str);

        for(int i = 0; i < lineList.size(); i++){
            lineList.get(i).trim();

            String word = "";

            for(int j = 0; j < lineList.get(i).length(); j++) {
                if(lineList.get(i).charAt(j) == ' ') {
                    wordList.add(word);

                    word = "";

                    continue;
                }
                else if(lineList.get(i).charAt(j) == ',') {
                    wordList.add(word);

                    word = "";

                    continue;
                }
                else if(lineList.get(i).charAt(j) == '.') {
                    wordList.add(word);

                    word = "";

                    continue;
                }
                else{
                    word += lineList.get(i).charAt(j);
                }
            }

            wordList.add(word);
        }

        return wordList;
    }

    /*Поиск строки в тексте*/
    public static void findLine(String str1, String str2){
        ArrayList <String> wordList = new ArrayList();
        int n = 0;

        wordList = getWords(str1);

        for(int i = 0; i < wordList.size(); i++){
            if(str2.equals(wordList.get(i)) == true)
            {
                n++;
            }
        }

        if(n != 0){
            System.out.println("Cтрока " + str2 + " найдена " + n + " раз");
        }
        else{
            System.out.println("Строка не найдена");
        }
    }

    /*Сравнение двух текстов*/
    public static ArrayList<String> compareTexts(String str1, String str2){
        ArrayList <String> firstList = new ArrayList<>();
        ArrayList <String> secondList = new ArrayList<>();
        ArrayList <String> thirdList = new ArrayList<>();
        ArrayList <String> resultList = new ArrayList<>();

        boolean exists = false;
        int n = 0;

        firstList = getWords(str1);
        secondList = getWords(str2);

        for(int i = 0; i < firstList.size(); i++){
            n = 0;
            exists = false;

            thirdList.add(firstList.get(i));

            for(int j  = 0; j < thirdList.size() - 1; j++){
                if(firstList.get(i).equals(thirdList.get(j)) == true){
                    exists = true;

                    break;
                }
            }

            if(exists == true){
                thirdList.remove(thirdList.size() - 1);

                continue;
            }
            else{
                for(int j = 0; j < secondList.size(); j++){
                    if(firstList.get(i).equals(secondList.get(j)) == true){
                        n++;
                    }

                    if(n != 0){
                        break;
                    }
                }
            }

            if(n == 0){
                resultList.add(firstList.get(i));
            }
        }

        if(resultList.isEmpty() != true){
            System.out.println("В тексте найдено " + resultList.size() + " уникальных слов:");
        }
        else{
            System.out.println("Тексты совпадают");
        }

        return resultList;
    }

    /*Перевод строки с английского языка*/
    public static String getTranslation(String str1){
        String resStr = "";
        ArrayList <String> stringList = new ArrayList<>();

        stringList = getWords(str1);

        for(int i = 0; i < stringList.size(); i++){
            if(stringList.get(i).charAt(0) == 'a'){
                resStr += new LetterA().getWord(stringList.get(i)) + " ";
            }
            else if(stringList.get(i).charAt(0) == 'b'){
                resStr += new LetterB().getWord(stringList.get(i)) + " ";
            }
        }

        return resStr;
    }
}
