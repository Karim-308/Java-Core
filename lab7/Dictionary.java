package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Dictionary {
    private HashMap<Character, ArrayList<String>> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            dictionary.put(c, new ArrayList<String>());
        }
    }

    public void addWord(String word) {

        if (word.isEmpty() || word == null)
            return;

        char indexCharacter = Character.toLowerCase(word.charAt(0));


        dictionary.get(indexCharacter).add(word.toLowerCase());

        Collections.sort(dictionary.get(indexCharacter));

    }

    public void print() {

        for (char c : dictionary.keySet()) {
            System.out.println("Character " + c +"\n "+ dictionary.get(c));
        }
    }

    public void printWords(char c) {

        System.out.println("Character " + c +"\n "+ dictionary.get(Character.toLowerCase(c)));

    }

}
