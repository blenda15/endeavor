import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	static int occurence(int[] arr, int n){
		int l = arr.length;
		int mid = l/2;
		int midElem = arr[mid];
		while(midElem != n || mid >=0 || mid <= l-1){
			midElem = arr[mid];
			if(midElem > n ){
				mid = mid/2;
			}
			else if(midElem < n ){
				mid = (mid+ (l-1))/2;
			}
		}
		
		if(midElem != n){
			return -1;
		}
		int count = 0;
		int x= mid;
		while(arr[mid] == n && mid>=0 && mid<= l-1){
			count++;
			mid+=1;
		}
		
		mid = x;
		while(arr[mid] ==n && mid>=0 && mid<= l-1){
			count++;
			mid-=1;
		}
		return count-1;
	}


	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int tests  = sc.nextInt();
	    while(tests-- >0){
	        int len = sc.nextInt();
	        int n = sc.nextInt();
	        int[] arr = new int[len];
	        for(int i=0; i<len;i++)
	            arr[i] = sc.nextInt();
	        System.out.println(occurence(arr, n));
	    }
	    
	    
	    
	}
}

------------------------------------------------------------------------------------------------------------------------------------------------------



// Java program to count occurrences 
// of an element
 import java.util.*;
class Main
{
    /* if x is present in arr[] then returns 
       the count of occurrences of x, 
       otherwise returns -1. */
    static int count(int arr[], int x, int n)
    {
      // index of first occurrence of x in arr[0..n-1]    
      int i; 
       
      // index of last occurrence of x in arr[0..n-1]
      int j; 
          
      /* get the index of first occurrence of x */
      i = first(arr, 0, n-1, x, n);
      
      /* If x doesn't exist in arr[] then return -1 */
      if(i == -1)
        return i;
         
      /* Else get the index of last occurrence of x. 
         Note that we are only looking in the 
         subarray after first occurrence */ 
      j = last(arr, i, n-1, x, n);     
         
      /* return count */
      return j-i+1;
    }
      
    /* if x is present in arr[] then returns the 
       index of FIRST occurrence of x in arr[0..n-1], 
       otherwise returns -1 */
    static int first(int arr[], int low, int high, int x, int n)
    {
      if(high >= low)
      {
        /*low + (high - low)/2;*/ 
        int mid = (low + high)/2;  
        if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
          return mid;
        else if(x > arr[mid])
          return first(arr, (mid + 1), high, x, n);
        else
          return first(arr, low, (mid -1), x, n);
      }
      return -1;
    }
      
    /* if x is present in arr[] then returns the 
       index of LAST occurrence of x in arr[0..n-1], 
       otherwise returns -1 */
    static int last(int arr[], int low, int high, int x, int n)
    {
      if(high >= low)
      {
        /*low + (high - low)/2;*/     
        int mid = (low + high)/2; 
        if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
          return mid;
        else if(x < arr[mid])
          return last(arr, low, (mid -1), x, n);
        else
          return last(arr, (mid + 1), high, x, n);      
      }
      return -1;
    }
      
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	    int tests  = sc.nextInt();
	    while(tests-- >0){
	        int len = sc.nextInt();
	        int n = sc.nextInt();
	        int[] arr = new int[len];
	        for(int i=0; i<len;i++)
	            arr[i] = sc.nextInt();
	       
	       int c = count(arr, n, len);
        System.out.println(n+" occurs "+c+" times");
    }
}
}