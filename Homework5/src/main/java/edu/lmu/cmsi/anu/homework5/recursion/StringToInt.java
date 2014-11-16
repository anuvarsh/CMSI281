package edu.lmu.cmsi.anu.homework5.recursion;

public class StringToInt {

    public static int stringToInt(String str) {
        if (str.length() < 1) {
            throw new IllegalArgumentException("Please enter a string of digits.");
        }

        int leastDigit = Integer.parseInt(Character.toString(str.charAt(str.length()-1)));

        if (str.length() > 1) {
            return leastDigit + 10*(stringToInt(str.substring(0, str.length()-1)));
        } else {
            return leastDigit;
        }
    } 
}