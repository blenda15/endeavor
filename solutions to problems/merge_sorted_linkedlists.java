//Merge sorted linkedlists in place

class gfg-{	
	Node merge(Node currA, Node currB){
		if(currA == null && currB == null)
			return null;
		if(currA == null)
			return currB;
		if(currB == null)
			return currA;
		if(currA.data<currB.data){
			currA.next = merge(currA.next, currB);
			return currA;
		}	
		else{
			currB.next = (currA, currB.next);
			return currB;
		}
			
	}
	
	
    Node MergeLists(Node headA, Node headB) {
        Node currA = headA;
        Node currB = headB;
        Node forwA = headA.next;
        Node forwB = headB.next;
        Node curr = null;
		
		/*if(currA.data <currB.data){
			curr = currA;
			currA = currA.next;
		}	
		else{
			curr = currB;
			currB = currB.next;
		}*/
		
		return merge(currA, currB);
   } 
}