//Merge k sorted arrays

private class Node implements Comparable<Integer>{
	int array, index, value;
	
	public Node(int array, int index, int value){
		this.array = array;
		this.index = index;
		this.value = value;
	}
	
	public int compareTo(Node n){
		if(value>n.value) return 1;
		if(value<n.value) return -1;
		return 0;
	}
}

class GfG{
	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		PriorityQueue<Node> pq =  new PriorityQueue<Node>();
		for(int i=0; i<arrays.length; i++){
			pq.add(new Node(i, 0, arrays[i][0]));
		}
		for(int i=0; !pq.isEmpty; i++){
			Node n = pq.poll();
			arr.add(n.value);
			int newIndex = n.index+1;
			if(newIndex<arrays[n.arrays].length){
				pq.add(new Node(n.arrays, newIndex, arrays[n.arrays][newIndex]));
			}
		}
		return arr;
	}
}