package com.company;

public class SearchAlgo {
    
     int [] array = {1,2,3,4,5};

     public int leanerSearch(int key){
         for (int i = 0; i < array.length; i++) {
              if (array[i] == key) {
                  return i;
              }
         }
         return  -1;
     }
     public int binarySearch(int key){
         int low = 0;
         int high = array.length;
         while (low <= high){
             int mid = low + (high -low)/ 2;
             if (array[mid] == key)
                 return mid;

             if (array[mid]< key)
                 low = mid+1;

             else
                 high = mid-1;
         }

         return -1;
     }

    public SearchAlgo() {
    }

    public static void main(String[] args) {
        SearchAlgo searchAlgo = new SearchAlgo();
        int result = searchAlgo.binarySearch(3);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
