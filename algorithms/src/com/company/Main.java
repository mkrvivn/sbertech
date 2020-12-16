package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++)
        {
            char tmp = s[s.length - i];
            s[s.length - i] = s[i];
            s[i] = tmp;
        }
    }
}
