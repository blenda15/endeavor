Detect cycle in an undirected graph

Boolean isCyclicUtil(int v, LinkedList<Integer>[] alist, boolean[] visited, int parent){
	visited[v] = true;
	Integer i;
	Iterator<Integer> it = alist[v].iterator();
	while(it.hasNext()){
		i = it.next();
		
		if(!visited[i]){
			if(isCyclicUtil(i, alist, visited, v))
				return true;
		}
		else if(i != parent){
			return true;
		}
	}
	return false;
}


Boolean isCyclic(int V, LinkedList<Integer>[] alist){
	boolean[] visited = new boolean[V];
	for(int j= 0; j<V; j++)
		visited[j] = false;
	
	for(int i=0; i<V; i++){
		if(!visited[i])
			if(isCyclicUtil(i, alist, visited, -1))
				return true;
	}
	return false;
}