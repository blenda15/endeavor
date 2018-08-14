//Form a palindrome: Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	//Dynamic Programming
	static int minPal(String str){
		
	}
	
	
	
	//RECURSIVE
    static int minPal(String str, int start, int end){
        if(start>=end)
            return 0;
		if(str.charAt(start) == str.charAt(end)){
			start++;
			end--;
			return minPal(str, start, end);
		}
		if(end-start<=2){
			if(str.charAt(start+1) == str.charAt(start) || str.charAt(end-1) == str.charAt(end))
				return 1;
			else
				return 2;
		}
        return 1+ Math.min(minPal(str, start, end-1), minPal(str, start+1, end));
    }
    
	public static void main (String[] args) throws IOException {
	    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int noTestCase = Integer.parseInt(scan.readLine());
		for(int i=0;i<noTestCase;i++){
		    String str = scan.readLine();
		    System.out.println(minPal(str, 0, str.length()-1));
		}
	}
}