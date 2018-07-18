//Dijkstra Algorithm

static int minDistance(int[] dist, boolean[] sptSet, int[][] graph, int V){
    	int min_dist = -1;
    	int min = Integer.MAX_VALUE;
    	for(int x=0; x<V; x++){
    		if(sptSet[x] == false && dist[x] < min){
    			min_dist= x;
    			min = dist[x];
    		}
    	}
    	return min_dist;
    }
    
    public static void dijkstra(int graph[][], int src ,int V){
        if(V==0)
            return;
    	int[] dist = new int[V];
    	boolean[] sptSet = new boolean[V];
    	
    	for(int i=0; i<V; i++){
    		dist[i] = Integer.MAX_VALUE;
    		sptSet[i] = false;
    	}
    	dist[src] = 0;
    	
    	for(int count =0; count<V-1; count++){
    		int u = minDistance(dist, sptSet, graph, V);
    		
    		sptSet[u] = true;
    		for(int v =0; v<V-1; v++){
				if(!sptSet[v]&& graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE&&dist[u] + graph[u][v]< dist[v]){
    			dist[v] = dist[u] + graph[u][v];
				}
			}
    		
    	}
    	
    	for(int g=0; g<V; g++){
    		System.out.print(dist[g] + " ");
    	}
    }