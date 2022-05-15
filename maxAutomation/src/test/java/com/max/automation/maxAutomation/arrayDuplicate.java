package com.max.automation.maxAutomation;

public class arrayDuplicate {

    public static void main(String[] args) {

        duplicatesInArray();
    }

    //Write a program to find duplicates in an array. a[] = {2,3,1,2,3} | Output: 2 3
    public static void duplicatesInArray() {
        int[] a = new int[]{2,3,1,2,3};
        // accessing the elements of the specified array
        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.println("Duplicate element found " + a[j]);

                }

            }


        }
    }
}