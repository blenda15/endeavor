longest common substring DP
Correct solution

int lcs(char[] x, char[] y, int n, int m){
	int result =0;
	int[][] lcs = new int[n+1][m+1];
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(i==0||j==0)
				lcs[i][j]=0;
			else if(x[i-1]==y[j-1]){
				lcs[i][j] = lcs[i-1][j-1] +1;
				result = Math.max(result, lcs[i][j]);
			}
			else
				lcs[i][j]=0
		}
	}
}
