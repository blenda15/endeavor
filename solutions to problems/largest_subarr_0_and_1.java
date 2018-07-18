//Largest subarray of 0's and 1's

int maxLen(int[] arr){
	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	hm.add(0,0);
	hm.add(1,0);
	for(int i =0; i<arr.length; i++){
		if(arr[i] == 0)
			hm.add(0, hm.get(0)+1)
		else
			hm.add(1, hm.get(1)+1)
	}
	
	int num = Math.min(hm.get(0), hm.get(1));
	return num*2;
}