package com.company;

import java.util.Collection;
import java.util.Collections;

public class FrequencyCounter {


    public boolean same(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length ; i++) {
            var correctIndex = arr2[i] * 2;
            if (correctIndex == -1){
                return false;
            }
            System.out.println(arr2);

        }
        return true;
    }

    public FrequencyCounter() {
        boolean same = same(new int[]{1, 2, 3, 4}, new int[]{1, 4, 9, 16});
        System.out.println("same = " + same);
    }

    public static void main(String[] args) {
       new FrequencyCounter();

    }
}
