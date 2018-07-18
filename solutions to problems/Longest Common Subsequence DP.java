Longest common subsequence

Iterative
//check geeks for geeks.. this might fail some cases
boolean compare(char c, String s, int len, int start){
	int j = start;
	while(j<len){
		if(s.charAt(j)==c)
			return true;
		j++;
	}
	return false
}

int lcs(String str1, String str2, int strlen1, int strlen2, int count){ // a len blen as it was given as input in the problem
	//bool isPres = false;
	int start =0;
	for(int i=0; i<strlen1;i++){
		if(compare(str1.charAt(i), str2, strlen2, start)==true){
			count++;
			start++;
		}
		
	}
	return count;
}