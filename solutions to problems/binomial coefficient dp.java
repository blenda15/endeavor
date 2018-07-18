RECURSIVE
causes Stack Overflow because of too many recursive calls in stack memory
int binomial(int n, int r){
	if(n==r || r==0)
		return 1;
	return binomial(n-1, r-1) + binomial(n-1, r);
}
----------------------------------------------------------------------------------------------------------------------------------------------
DP
//using a 2x2 matrix
n -> 0  1  2  3  4
r|
0    1	1  1  1  1
1	 /	1  2  3  
2    /
3    /
4    /
and so on fill this table. The value of an entry can be seen by pattern - that the binomial(n-1, r-1) + binomial(n-1, r) follows

int binomial(int n, int r, int[][] mat){
	//int[][] mat = new int[n][r];
	mat[0][0] =1;
	if(n==r || r==0)
		return 1;
	if(mat[n][r]==0)
		mat[n][r] = binomial(n-1,r-1,mat)+binomial(n-1,r, mat);
	return mat[n][r];
}