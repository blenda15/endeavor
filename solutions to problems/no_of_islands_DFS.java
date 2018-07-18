// Java program to count islands in boolean 2D matrix


import java.util.*;
import java.lang.*;
import java.io.*;

class Islands
{
    
    boolean isSafe(int[][] arr, boolean[][] visited, int k, int l, int n, int m){
    	return (k>=0)&&(l>=0)&&(k<n)&&(l<m)&&(arr[k][l] ==1)&&(!visited[k][l]);
    }
    
    void DFS(int[][] arr, boolean[][] visited, int k, int l, int n, int m){
    	visited[k][l] = true;
    	
    	int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
    	
    	for(int x=0; x<8; x++){
    		if(isSafe(arr, visited, k+rowNbr[x], l+colNbr[x], n, m))
    			DFS(arr, visited, k+rowNbr[x], l+colNbr[x], n, m);
    	}
    }
    
    int islands(int[][] arr, int n, int m){
        int count =0;
    	boolean[][] visited = new boolean[n][m];
    	
    	for(int i =0; i<n; i++){
    		for(int j =0; j<m; j++){
    			visited[i][j]= false;
    		}
    	}
    	
    	for(int k=0; k<n; k++){
    		for(int l=0;l<m; l++){
    			if(!visited[k][l] && arr[k][l]==1){
    				DFS(arr, visited, k, l, n, m);
					count++;
    			}
    				
    		}
    	}
    	return count;
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		int M[][]= new int[][] {{1, 1, 0, 0, 0},
								{0, 1, 0, 0, 1},
								{1, 0, 0, 1, 1},
								{0, 0, 0, 0, 0},
								{1, 0, 1, 0, 1}
								};
		Islands I = new Islands();
		System.out.println("Number of islands is: "+ I.islands(M, 5, 5));
	}
}
