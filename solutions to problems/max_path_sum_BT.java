//Find the maximum path sum between two leaves of a binary tree
GFG

class Res{
	int val;
}

int maxpathsum(Node root){
	Res res = new Res();
	res.value = Integer.MIN_VAL;
	maxSumPathUtil(root, res);
	return res.val;
}

int maxSumPathUtil(Node node, Res res){
	if(node == null)
		return 0;
	if(node.left == null && node.right == null)
		return node.data;
	
	int ls = maxSumPathUtil(node.left, res);
	int rs = maxSumPathUtil(node.right, res);
	
	if(node.left != null && node.right != null){
		res.val = Math.max(res.val, ls+rs+node.data);
		return Math.max(ls, rs) + node.data;
	}
	
	return (node.left == null)?rs+node.data: ls+node.data;
}