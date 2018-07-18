BFS Transversal


class Graph
{
	
	private int V;
	private LinkedList<Integer>[] adj;
	
	Graph(int V){
		this.V = V;
		adj = new LinkedList<Integer>[V];
		for(int i =0; i<V; i++){
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge(int u, int w){
		adj[u].add(w);
	}
	
	public void BFS(int s){
		boolean[] visited = new boolean[v];
		for(int i=0; i<V; i++){
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()){
			s = queue.poll();
			
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	
	public static void main(String args[])
	{
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "+
						"(starting from vertex 2)");

		g.BFS(2);
	}
}