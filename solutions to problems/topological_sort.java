Toplogical Sort


static void topologicalSort(int v, boolean[] visited, Stack stack, ArrayList<Integer> graph[]){
	visited[v] = true;
	Integer i;
	
	Iterator<Integer> it = graph[v].iterator();
	while(it.hasNext()){
		i = it.next();
		if(!visited[i])
			topologicalSort(i, visited, stack, graph);
	}
	stack.push(new Integer(v));
}

public static int[] topoSort(ArrayList<Integer> graph[],int N){
	boolean visited[] = new boolean[N];
	for(int j=0; j<N;j++){
		visited[j] = false;
	}
	Stack stack = new Stack();
	for(int i=0; i<N; i++){
		if(!visited[i])
			toplogicalSort(i, visited, stack, graph);
	}
	int[] result = new int[N];
	int x=0;
	while(!stack.isEmpty()){
		result[x] = stack.pop();
		x++;
	}
	return result;
}