/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int fixHeap(int[] array, int position, int heapSize) {
        int child = position * 2 + 1;
        if (child >= heapSize) {
            return -1;
        }
        if (child+1 < heapSize && array[child] > array[child+1]) {
            child++;
        }
        if (array[child] < array[position]) {
            // swap the two values
            int temp = array[child];
            array[child] = array[position];
            array[position] = temp;
            return child;
        }
        return -1;
    }
    
    public static void kLargest(int[] array, int k) {
        // Build a heap (on the first k elements, at least)
        for (int i=k-1;i>=0;i--) {
            int index = fixHeap(array, i, k);
            while (index != -1) {
                index = fixHeap(array, index, k);
            }
        }
        for (int index=k;index<array.length;index++) {
            if (array[index] > array[0]) {
                // swap the two values
                int temp = array[index];
                array[index] = array[0];
                array[0] = temp;
                // fix the heap
                int position = 0;
                while (position != -1) {
                    position = fixHeap(array, position, k);
                }
            }
        }
        for (int i=k-1;i>-1;i--) {
            System.out.print(array[i] + " ");
        }
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0; i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        kLargest(arr, k);
	        System.out.println();
	    }
	}
}