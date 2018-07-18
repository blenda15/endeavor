Minimum number of jumps
//failing for 10
//2 3 1 1 2 4 2 0 1 1

int minJump(int[] arr){
	int len = arr.length;
	int end = len-1;
	int memo[] = new int[len];
	memo[len-1] = 0;
	for(int i= end-1;i>-1;i--){
		if(end-i < arr[i])
			memo[i]=1;
		else
			memo[i] = 1+ memo[i+arr[i]];
	}
	return memo[0];
}