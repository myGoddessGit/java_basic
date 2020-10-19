package com.collection;

import java.util.*;

public class HashMap_C {

    public static void main(String[] args) {
        System.out.println(isMirror(3, 0));
        reverse();
        reverses();
    }

    public static boolean isMirror(int a, int b){
        return ((a >> 31) ^ (b >> 31)) == 0;
    }
    public static void reverse(){
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] array = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : array) {
            list.add(c);
        }
        Collections.reverse(list);
        //Character[] characters = list.toArray(new Character[list.size()]);
        StringBuilder sb = new StringBuilder();
        for (Character character : list){
            sb.append(character);
        }
        System.out.println(sb.toString());
    }

    public static void reverses(){
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] array = str.toCharArray();
        for (int low = 0, high = array.length - 1; low < high; low++, high--){
            char temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : array){
            sb.append(character);
        }
        System.out.println(sb.toString());
    }
}
