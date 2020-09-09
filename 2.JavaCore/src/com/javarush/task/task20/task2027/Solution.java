package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Кроссворд
{'f', 'd', 'e', 'r', 'l', 'k'},
{'u', 's', 'a', 'm', 'e', 'o'},
{'l', 'n', 'g', 'r', 'o', 'v'},
{'m', 'l', 'p', 'r', 'r', 'h'},
{'p', 'o', 'e', 'e', 'j', 'j'}
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };
        List<Word> detectedWords = (detectAllWords(crossword, "one"));

//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
//        List<Word> detectedWords = detectAllWords(crossword, "home", "same");
        if(!detectedWords.isEmpty()) {
//            System.out.println(detectedWords.toString());
            System.out.println(detectedWords.size());
            for(Word w : detectedWords) {
                System.out.println(w);
            }
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> wordsWithCoordinates = new ArrayList<>();
        for(String word : words) {      //looking through every word in words
            for(int y = 0; y < crossword.length; y++) {     //for each string of crossword
                for(int x = 0; x < crossword[y].length; x++) {      //for each element of that string
                    if(crossword[y][x] == word.charAt(0)) {     //if current (y,x) letter equals first letter of current word
                        // going through all 8 directions in which current word is able to fit
                        //up direction
                        if(y >= word.length() - 1) {    //if word fits up direction
                            boolean match = true;       //all the letters are matching by default
                            for(int p = 1; p < word.length(); p++) {     //matching through each letter in this direction
                                if(crossword[y - p][x] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x, y - (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //up-right direction
                        if((y >= word.length() - 1) && (x <= crossword[y].length - word.length())) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y - p][x + p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + (word.length() - 1), y - (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //right direction
                        if(x <= crossword[y].length - word.length()) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y][x + p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + (word.length() - 1), y);
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //down-right direction
                        if((y <= crossword.length - word.length()) && (x <= crossword[y].length - word.length())) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y + p][x + p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + (word.length() - 1), y + (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //down direction
                        if(y <= crossword.length - word.length()) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y + p][x] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x, y + (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //down-left direction
                        if((y <= crossword.length - word.length()) && (x >= word.length() - 1)) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y + p][x - p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (word.length() - 1), y + (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //left direction
                        if(x >= word.length() - 1) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y][x - p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (word.length() - 1), y);
                                wordsWithCoordinates.add(w);
                            }
                        }
                        //up-left direction
                        if((y >= word.length() - 1) && (x >= word.length() - 1)) {
                            boolean match = true;
                            for(int p = 1; p < word.length(); p++) {
                                if(crossword[y - p][x - p] != word.charAt(p)) {
                                    match = false;
                                    break;
                                }
                            }
                            if(match == true) {     //add the word to List
                                Word w = new Word(word);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (word.length() - 1), y - (word.length() - 1));
                                wordsWithCoordinates.add(w);
                            }
                        }
                    }
                }
            }
        }
        return wordsWithCoordinates;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
