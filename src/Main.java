public class Main {
    public static void main(String[] args) {
        int[] arrOne = {1, 2, 3, 4, 5};
        int[] arrTwo = {5,7,4, 2,1,3,6};
        int[] arrThree = {4,3,2,7,9,0,8,1,5,6};
        int[] arrFour = {0,4,15,12,2,5,3,1,6,7,8,9,10,11,13,14};
        int[] arrFive = {1,2,3,4,5,6,7,8,9,10};
        int[] arrSix = {10,9,8,7,6,5,4,3,2,1};
        int[] arrSeven = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("1st lowest in One: " + getkthLowest(1, arrOne));
        System.out.println("2nd lowest in One: " + getkthLowest(2, arrOne));
        System.out.println("3rd lowest in One: " + getkthLowest(3, arrOne));

        System.out.println("1st lowest in Two: " + getkthLowest(1, arrTwo));
        System.out.println("2nd lowest in Two: " + getkthLowest(2, arrTwo));
        System.out.println("3rd lowest in Two: " + getkthLowest(3, arrTwo));

        System.out.println("1st lowest in Three: " + getkthLowest(1, arrThree));
        System.out.println("2nd lowest in Three: " + getkthLowest(2, arrThree));
        System.out.println("3rd lowest in Three: " + getkthLowest(3, arrThree));

        System.out.println("1st lowest in Four: " + getkthLowest(1, arrFour));
        System.out.println("2nd lowest in Four: " + getkthLowest(2, arrFour));
        System.out.println("3rd lowest in Four: " + getkthLowest(3, arrFour));

        System.out.println("1st lowest in Five: " + getkthLowest(1, arrFive));
        System.out.println("2nd lowest in Five: " + getkthLowest(2, arrFive));
        System.out.println("3rd lowest in Five: " + getkthLowest(3, arrFive));

        System.out.println("1st lowest in Six: " + getkthLowest(1, arrSix));
        System.out.println("2nd lowest in Six: " + getkthLowest(2, arrSix));
        System.out.println("3rd lowest in Six: " + getkthLowest(3, arrSix));

        System.out.println("1st lowest in Seven: " + getkthLowest(1, arrSeven));
        System.out.println("2nd lowest in Seven: " + getkthLowest(2, arrSeven));
        System.out.println("3rd lowest in Seven: " + getkthLowest(3, arrSeven));
    }

    private static int getkthLowest(int k, int[] arr) {
        int pivot = arr[0];

        int[] lower = new int[arr.length];
        int[] higher = new int[arr.length];

        int lowerLength = 0;
        int higherLength = 0;

        for(int j : arr) {
            if (j < pivot) {
                lower[lowerLength] = j;
                lowerLength++;
            } else if (j > pivot) {
                higher[higherLength] = j;
                higherLength++;
            }
        }

        if(lowerLength == k){
            return getHighest(lower);
        } else if (lowerLength < k) {
            return getLowest(higher);
        }
        return getkthLowest(k, lower);
    }

    private static int getHighest(int[] arr) {
        int highest = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > highest) {
                highest = arr[i];
            }
        }
        return highest;
    }

    private static int getLowest(int[] arr) {
        int lowest = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        return lowest;
    }

}