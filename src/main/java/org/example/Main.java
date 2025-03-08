package org.example;

import java.util.Random;

public class Main {
    final static Random rand = new Random();
    public static void main(String[] args) {
        int[] arrOne = {1, 2, 3, 4, 5};
//        int[] arrTwo = {5,7,4, 2,1,3,6};
//        int[] arrThree = {4,3,2,7,9,0,8,1,5,6};
//        int[] arrFour = {0,4,15,12,2,5,3,1,6,7,8,9,10,11,13,14};
//        int[] arrFive = {1,2,3,4,5,6,7,8,9,10};
//        int[] arrSix = {10,9,8,7,6,5,4,3,2,1};
//        int[] arrSeven = {1,2,3,4,5,6,7,8,9,10};
//
//        System.out.println("1st lowest in One: \nExpected: 1    Actual: " + getkthLowest(1, arrOne, arrOne.length));
//        System.out.println("2nd lowest in One: \nExpected: 2    Actual: " + getkthLowest(2, arrOne, arrOne.length));
//        System.out.println("3rd lowest in One: \nExpected: 3    Actual: " + getkthLowest(3, arrOne, arrOne.length));
//
//        System.out.println("1st lowest in Two: \nExpected: 1    Actual: " + getkthLowest(1, arrTwo, arrTwo.length));
//        System.out.println("2nd lowest in Two: \nExpected: 2    Actual: " + getkthLowest(2, arrTwo, arrTwo.length));
//        System.out.println("3rd lowest in Two: \nExpected: 3    Actual: " + getkthLowest(3, arrTwo, arrTwo.length));
//
//        System.out.println("1st lowest in Three: \nExpected: 0    Actual: " + getkthLowest(1, arrThree, arrThree.length));
//        System.out.println("2nd lowest in Three: \nExpected: 1    Actual: " + getkthLowest(2, arrThree, arrThree.length));
//        System.out.println("3rd lowest in Three: \nExpected: 2    Actual: " + getkthLowest(3, arrThree, arrThree.length));
//
//        System.out.println("1st lowest in Four: \nExpected: 0    Actual: " + getkthLowest(1, arrFour, arrFour.length));
//        System.out.println("2nd lowest in Four: \nExpected: 1    Actual: " + getkthLowest(2, arrFour, arrFour.length));
//        System.out.println("3rd lowest in Four: \nExpected: 2    Actual: " + getkthLowest(3, arrFour, arrFour.length));
//
//        System.out.println("1st lowest in Five: \nExpected: 1    Actual: " + getkthLowest(1, arrFive, arrFive.length));
//        System.out.println("2nd lowest in Five: \nExpected: 2    Actual: " + getkthLowest(2, arrFive, arrFive.length));
//        System.out.println("3rd lowest in Five: \nExpected: 3    Actual: " + getkthLowest(3, arrFive, arrFive.length));
//
//        System.out.println("1st lowest in Six: \nExpected: 1    Actual: " + getkthLowest(1, arrSix, arrSix.length));
//        System.out.println("2nd lowest in Six: \nExpected: 2    Actual: " + getkthLowest(2, arrSix, arrSix.length));
//        System.out.println("3rd lowest in Six: \nExpected: 3    Actual: " + getkthLowest(3, arrSix, arrSix.length));
//
//        System.out.println("1st lowest in Seven: \nExpected: 1    Actual: " + getkthLowest(1, arrSeven, arrSeven.length));
//        System.out.println("2nd lowest in Seven: \nExpected: 2    Actual: " + getkthLowest(2, arrSeven, arrSeven.length));
//        System.out.println("3rd lowest in Seven: \nExpected: 3    Actual: " + getkthLowest(3, arrSeven, arrSeven.length));
    }

    /**
     * This function returns the kth lowest number in the array
     * @param k - the lowest number wanted
     * @param arr - the array to search
     * @return - the kth lowest number
     */
    public static int getkthLowest(int k, int[] arr, int arrayLength) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int pivot = arr[rand.nextInt(arr.length)];

        int[] lower = new int[arr.length];
        int[] higher = new int[arr.length];

        int lowerLength = 0;
        int higherLength = 0;
        int pivotCount = 0;

        for(int i = 0; i < arrayLength; i++) {
            if (arr[i] < pivot) {
                lower[lowerLength] = arr[i];
                lowerLength++;
            } else if (arr[i] > pivot) {
                higher[higherLength] = arr[i];
                higherLength++;
            } else {
                pivotCount++;
            }
        }

        if (lowerLength >= k) {
            return getkthLowest(k, lower, lowerLength);
        } else if (lowerLength + pivotCount >= k) {
            return pivot;
        } else {
            return getkthLowest(k - lowerLength - pivotCount, higher, higherLength);
        }
    }
}