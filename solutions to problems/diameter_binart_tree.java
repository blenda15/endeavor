//Diameter of Binary Tree - DFS

class GfG
{	
	void constructAdjList(Node node, HashMap<Integer, ArrayList<Integer>> adjList){
		Node curr = node;
		Stack<Integer> st = new Stack<Integer>();
		st.push(node);
		while(!st.isEmpty()){
			curr = st.pop();
			ArrayList<Integer> arr;
			//if(adjList.containsKey(curr.data)){
				arr = adjList.get(curr.data);
			//}
			//else{
				arr = new ArrayList<Integer>();
				if(curr.left!=null){
					arr.add(curr.left);
					st.push(curr.left);
				}
				if(curr.right!=null){
					arr.add(curr.right);
					st.push(curr.right);
				}
				//if(arr.size()!= 0)
					adjList.put(curr.data, arr);
			//}
		}
		return adjList;
	}0

    int diameter(Node node){
		HashMap<Integer, ArrayList<Integer>> adjList = new ArrayList<Integer, ArrayList<Integer>>();
		Node curr = node;
		adjList = constructAdjList(node, adjList);
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>;
		HashMap<Integer, Boolean> visitedAux = new HashMap<Integer, Boolean>;
		for(Map.Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet()){
			//visited.put(entry.getKey(), new Boolean("True"));
			//ArrayList<Integer> arr = entry.getValue();
			if(entry.getValue().size() == 0 && !(visited.containsKey(entry.getKey()))){
				visited.put(entry.getKey(), new Boolean("True"));
			}
		}
		
	}
}