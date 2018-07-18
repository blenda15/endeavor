RECURSIVE
//failing this test case  [23 23 -98 5]
static void sum(int[] memo, int start, int end, int [] arr){
	if(start == end)
		return arr[start];
	if(arr[start]<0 && arr[end]<0){
		if(arr[start]<arr[end])
			sum(memo, start+1, end, arr);
		else
			sum(memo, start, end-1, arr);
	}
	if (arr[start]>0 && arr[end]>0){
		if(start ==0)
			return memo[end];
		else
			return memo[end]-memo[start-1];
	}
		
	if(arr[start]<0 && arr[end]>0)
		return sum(memo, start+1, end, arr);
	if(arr[start]>0 && arr[end]<0)
		return sum(memo, start, end-1, arr); 
}

static int[] memoize(int arr[]){
	int len =  arr.len;
	int[] memo = new int[len];
	memo[0] = arr[0];
	for(int i = 1; i<len; i++){
		memo[i] = arr[i]+memo[i-1];
	}
	return memo;
}
