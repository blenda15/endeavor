X Total Shapes

void BFSutil(char[][] arr, int a, int b, int[][] visited, int m , int n){
	if(arr[a][b] == 'X'){
		visited[a][b] = 1;
		if(a >0)
			BFSutil(arr, a-1, b, visited);
		if(b>0)
			BFSutil(arr, a, b-1, visited);
		if(a< n-1)
			BFSutil(arr, a+1, b, visited);
		if(b< m-1)
			BFSutil(arr, a, b+1, visited);
		}
}

int noOfShapes(char[][] arr, int n, int m){
	int[][] visited = new int[n][m];
	for(int i =0;i<n; i++){
		for(int j=0; j<m; j++){
			visited[i][j] =  0;
		}
	}
	int count =0;
	
	for(int i =0;i<n; i++){
		for(int j=0; j<m; j++){
			if(arr[i][j] == 'X' && visited[i][j] == 0){
				BFSutil(arr, i, j, visited, n, m);
				count++;
			}
		}
	}
	return count;
}