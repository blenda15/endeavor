//Does array represent Heap

 static int isHeap(int[] arr, int n){
        for(int i =0; i<=(n/2)-1; i++){
            /*if(!((2*i+1)>n)){
                if(arr[i]<arr[2*i+1])
                    return 0;
            }
            if(!((2*i+2)>n)){
                if(arr[i]<arr[2*i+2])
                    return 0;
                }*/
    		if(arr[i]<arr[2*i+1])// || arr[i]<arr[2*i+2])
    			return 0;
    		if(2*i+2 <= n-1){
        		if(arr[i]<arr[2*i+2])
        		    return 0;
    		}
			
        }
	    return 1;
    }  