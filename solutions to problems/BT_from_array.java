//Construct Binary Tree from Parent Array
this is not entirely correct. See GFG!!!!!!!

createNode(int[] parent, Node[] created){
	
}

createTree(int[] parent){
	Node[] created = new Node[parent.length];
	Node root;
	for(i=0;i<parent.length;i++){
		if(parent[i] == -1){
			root= new Node(i);
			created[i] = root;
		}
		else{
			Node par = created[parent[i]];
			Node n = new Node(i);
			if(par.left == null)
				par.left= n;
			else{
				par.right = n;
		}
		created[i] = n;
	}
}