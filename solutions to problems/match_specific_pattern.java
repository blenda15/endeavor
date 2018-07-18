//Match specific pattern

static String hashFunc(pattern){
	Integer i =0;
	StringBuilder sb = new StringBuilder();
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	for(int i=0; i<pattern.length(); i++){
		if(hm.get(pattern.charAt(i))==null)
			hm.put(pattern.charAt(i), i++);
		sb.append(i);
	}
	return sb.toString();
}

public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern){
	String hash = hashFunc(pattern);
	ArrayList<String> ans = new ArrayList<String>();
	for(String word: dict){
		String h = hashFunc(word);
		if(h.equals(hash))
			ans.add(word)
	}
	return ans;
}