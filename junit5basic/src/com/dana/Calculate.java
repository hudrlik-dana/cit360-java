package com.dana;

import java.util.HashMap;
import java.util.Map;

public class Calculate {
    // adding
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // subtracting
    public static int subtractNumbers(int a, int b) {
        return a - b;
    }

    // dividing
    public static int divideNumbers(int a, int b) {
        return a / b;
    }

    // compare numbers
    public static boolean sameNumbers(int a, int b) {
        boolean sameNumber = true;

        if (a != b) {
            System.out.println("false - different numbers");
            sameNumber = false;
        } else {
            System.out.println("true - same numbers");
        }
        return sameNumber;
    }

    // compare strings
    public static boolean differentCharacters(String a, String b) {
        boolean differentCharacter = true;

        if (a != b) {
            System.out.println("true - different characters");
            differentCharacter = false;
        } else {
            System.out.println("false - same characters");
        }
        return differentCharacter;
    }

    // compare 2 strings not case sensitive
    public boolean compareStrings(String first, String second) {
        // not case sensitive
        if(first.equalsIgnoreCase(second)) {
            return true;
        } else {
            return false;
        }
    }

    // concatenate 2 strings
    public static String concatStrings(String first, String second) {
        return first.concat(second);
    }

    // determine if expected value is false
    public static boolean isNumberEven(int anyNumber) {
        boolean answer = false;

        if (anyNumber % 2 == 0) {
            answer = true;
            System.out.println("number is even");
        }
        return answer;
    }

    // determine if expected value is true
    public static boolean isNumberOdd(int anyNumber) {
        boolean answer = false;

        if (anyNumber % 2 != 0) {
            answer = true;
            System.out.println("number is odd");
        }
        return answer;
    }

    // check for key-value pair in HashMap<> not null and null
    public static String notNullKeyValuePair(final String key) {
        // create HashMap object named keyValue
        Map<String, String> keyValue = new HashMap<String, String>();

        // add keys and values - key state, value city
        keyValue.put("California", "Big Bear");
        keyValue.put("Utah", "Herriman");
        keyValue.put("Oregon", "Beaverton");
        keyValue.put("Somewhere", "");

        return keyValue.get(key);
    }

    // working on assertArrayEquals(expected, actual)
    public static void arrayTest() {
        // create array with positions 0,1,2
        int[] myArray = new int[3];
        // loop used to add numbers to myArray[]
        for (int i = 0; i < 3; i++){
            // increase each entry by 1
            myArray[i] = i + 1;
        }
        // print myArray
        for (int i = 0; i < 3; i++){
            System.out.println("myArray ["+ i +"] = "+ myArray[i]);
        }
        // print array length
        System.out.println("Array length  =  "+ myArray.length);
        myArray[2] = 10;
    }

    // add 1 to the arrays value
    public int[] addOneToArray(int[] value) {
        int length = value.length;
        int[] answer = new int[length];
        // loop through array adding 1 to each number
        for (int i = 0; i < length; i++) {
            answer[i] = value[i] + 1;
        }
        return answer;
    }

}