//k’th smallest element in the given array. It is given that all array elements are distinct


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	
	
	
	//Sorting O(nlogn)
    public static int kSmallestElem(int[] arr, int n, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0; i<n ;i++){
	            arr[i] = sc.nextInt();
	        }
	        int k = sc.nextInt();
	        System.out.println(kSmallestElem(arr, n, k));
	    }
	}
}