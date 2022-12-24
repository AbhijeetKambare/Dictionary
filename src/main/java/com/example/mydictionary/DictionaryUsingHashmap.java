package com.example.mydictionary;

import java.util.HashMap;

public class DictionaryUsingHashmap {
    private HashMap<String,String> dictionary;
     public DictionaryUsingHashmap(){
         this.dictionary=new HashMap<>();
        addWordList();
     }

     public boolean addWord(String word, String meaning){
         try{
             dictionary.put(word, meaning);
         }
         catch (Exception e){
             e.printStackTrace();
             return false;
         }
         return true;
     }
     public String getMeaning(String word){
         if(dictionary.containsKey(word)){
             return dictionary.get(word);
         }
         else{
             return "Word does Not Exist"; 
         }
     }
     public void addWordList(){
         addWord("Beautiful","Pretty");
     }
}
