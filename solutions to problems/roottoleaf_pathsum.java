//Root to leaf path sum
Not sure if this is correct, run on IDE
class GfG
{
    int find(Node node, int count, int sum){
		if(count == sum || node == null)
				return 0;
		int count = node.data;
		int temp = count;
		if(node.left != null)
			count += find(node.left, count, sum);
		if(count != sum){
			count = temp;
			if(node.right != null)
				count += find(node.right, count, sum);
		}
		return count;
	}
	
	boolean hasPathSum(Node node, int sum)
    {
        int count = 0;
		count += find(node, count, sum);
		if(count == sum)
			return true;
		else
			return false;
    }
}