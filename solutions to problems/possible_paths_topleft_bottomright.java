//Count all possible paths from top left to bottom right

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int ways(int m, int n){
        int[][] memo = new int[m][n];
        for(int x =0; x<m;x++){
            memo[x][0] = 1;
        }
        for(int y=0; y<n; y++){
            memo[0][y] = 1;
        }
        for(int i=1; i<m;i++){
            for(int j =1;j<n;j++){
                memo[i][j] = (memo[i-1][j] + memo[i][j-1])%1000000007;
            }
            
        }
        return memo[m-1][n-1];
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int m = sc.nextInt();
	        int n = sc.nextInt();
	        System.out.println(ways(m, n));
	    }
	}
}