package com.company.recursion;

public class RecursionTest {
    int sumRange(int num){
        if (num == 1)  return 1;
        return num + sumRange(num -1);
    }

     int  fact(int num){
         var total = 1;
         for (int i = num ; i > 0; i--){
              total *=i;
         }
         return  total;
     }

     int factWithRecursion( int num){
        if (num == 1) return 1;
         return num* factWithRecursion(num-1);
     }

    public RecursionTest() {
        int sumRange = sumRange(3);
        System.out.println("sumRange = " + sumRange);
        int fact = factWithRecursion(4);
        System.out.println("fact = " + fact);
    }

    public static void main(String[] args) {
      new RecursionTest();
    }
}
