//Intersection of Two Linked Lists

//Array Subset of another array

boolean isSubset(int[] arr1, int[] arr2, int m, int n){
	HashSet<Integer> hset = new HashSet<>();
	
	for(int i=0; i<m; i++){
		hset.add(arr1[i]);
	}
	
	for(int j=0; j<n; j++){
		if(hset.contains(arr2[i]))
			return true;
	}
	return false;
}