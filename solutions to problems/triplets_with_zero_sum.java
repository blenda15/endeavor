//Find triplets with zero sum

boolean searchElem(int[] arr, int elem, int n){
    	for(int i =0; i<n; i++){
    		if(arr[i] == elem)
    			return true;
    	}
    	return false;
    }
    
public boolean findTriplets(int arr[] , int n){
	Arrays.sort(arr);
	if(arr[0]>0 || arr[0]==0)
		return false;
	if(arr[n-1] < 0)
		return false;
	int sum;
	int elem;
	for(int i= 0; i<n-1;i++){
		for(int j=i+1; j<n;j++){
			sum = arr[i]+ arr[j];
			if(sum>0)
				return false;
			if(sum == 0)
				if(j!=n-1)
					if(arr[j+1] == 0)
						return true;
					else
						return false;
				else
					return false;
			elem = Math.abs(sum);
			return searchElem(arr, elem, n);
		}
	}
	return false;
}

Failing test case
23
39 11 13 -64 3 8 48 -42 64 -45 82 36 82 -34 85 68 96 41 7 -59 90 -7 76
