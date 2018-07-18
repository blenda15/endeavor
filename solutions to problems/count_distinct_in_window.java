void countDistinct(int A[], int k, int n){
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int end = k;
	int start = 0;
	
	
	while(end< n){
		for(int i = start; i<end; i++){
			int pres= hm.get(A[i]);
			if(pres == null)
				hm.put(A[i], 1);
			else
				hm.put(A[i], hm.get(A[i])+1);// pres+1
		}
		System.out.print(hm.size() + " ");
		int rem = hm.get(A[start]);
		if(rem>1)
			hm.put(A[start], hm.get(A[start])-1);
		else
			hm.remove(A[start]);
		
		end+=1;
		start = end-k;
		
		
		/*int pres2= hm.get(A[end]);
			if(pres == null)
				hm.put(A[i], 1);
			else
				hm.put(A[i], hm.get(A[i])+1);// pres+1
		
		System.out.print(hm.size() + " ");*/
	}
	
}



void countDistinct(int A[], int k, int n){
	
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	/*for(int i =0; i<k; i++){
		//int x = hm.get(A[i]);
		if(hm.get(A[i]) !=null)
			hm.add(A[i], 1);
		else
			hm.add(A[i], hm.get(A[i])+1);	
	}
	for(int j=k+1; j+k<n; j++){
		
	}*/
	int start = 0;
	int end = k;
	while(end<n){
		
		if(!hm.isEmpty()){
			if(hm.get(A[start]) > 1)
				hm.put(A[start], (hm.get(A[start])-1))
			else
				hm.remove(A[start]);
			if(hm.get(A[end]) > 1)
				hm.put(A[end], (hm.get(A[end])+1))
			else
				hm.add(A[end], 1);
			
		}
		
		else{
			
		}
	}
	
	
	
	
	
}

































