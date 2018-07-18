import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    
    static void searchPattern(String txt, String pat){
        int[] subArray = new int[pat.length()];
        subArray = substringArray(pat);
        int iteratePat =0;
        int iterateTxt =0;
        while(iterateTxt < txt.length()){  //iteratePat <= pat.length() && 
            if(txt.charAt(iterateTxt) == pat.charAt(iteratePat)){
                iteratePat++;
                iterateTxt++;
            }
            if(iteratePat == pat.length())
                    System.out.println("Match at " + (iterateTxt-iteratePat));
            else if (iteratePat< pat.length() && (txt.charAt(iterateTxt) != pat.charAt(iteratePat))){
                if(iteratePat > 0){
                    iteratePat--;
                    iteratePat = subArray[iteratePat];
                }
                    
                else{
                    iterateTxt++;
                    
                }
                  
            }
        }
    }

	static int[] substringArray(String s){
		int[] subArray = new int[s.length()];
		int i = 0;
		int j = 1;
		int max = 0;
		subArray[0] = 0;
		while(j < subArray.length && i < subArray.length){
		    
			if(s.charAt(i) != s.charAt(j)){
			    if( i != 0){
			        i= subArray[i-1];
			    }
			    else{
			        subArray[j] = i;
			        j++;
			    }
			}
			
			
			else if(s.charAt(i) == s.charAt(j)){
			    i++;
			    subArray[j] = i;
			    
				j++;
			}
			
		}
		return subArray;
	}
	
	public static void main(String args[]){
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
		searchPattern(txt, pat);

	}
}