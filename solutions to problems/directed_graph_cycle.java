Cycle detection directed graph

boolean hasCycleUtil(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored){
	visited[v] = true;
	explored[v] = true;
	Integer i;
	Iterator<Integer> it = alist[v].iterator();
	while(it.hasNext()){
		i = it.hasNext();
		if(!visited[i])
			if(hasCycleUtil(i, alist, visited, explored))
				return true;
		else if(explored[i])
			return true;
	}
	explored[v] = false;
	return false;
}

public boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited,boolean[] explored){
	for(int p=0; p<v; p++){
		visited[p] = false;
	}
	for(int q=0; q<v; q++){
		explored[q] = false;
	}
	for(int i =0; i<v; i++){
		if(!visited[i])
			if(hasCycleUtil(i, alist, visited, explored))
				return true;
	}
	return false;
}