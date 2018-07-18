//Most frequent word in an array of strings

static String mostFrequent(int len, String[] arr){
	TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
	for(int i = 0; i<len;i++){
		tm.put(arr[i], (tm.get(arr[i])==null) ? 1: (tm.get(arr[i])+1));
	}
	int max = 0;
	(Map.Entry m : tm.entrySet()){
		if(m.getValue()>max){
			max= m.getValue();
		}
	}
	return max;
} 