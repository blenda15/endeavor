//Flattening a Linked List
WROOOONGGGGGGGGGGGGGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! See gfg
class GfG{
    Node flatten(Node root){
		if(root == null || root.next == null || root.bottom == null)
			return root;
		Node head = root;
		Node curr= head; // check
		Node hor = root.next;
		Node ver = root.bottom;
		Node ver2 = null;
		while(hor != null){  // && ver != null
			if(hor.data < ver.data){
				curr.bottom = hor;
				curr = curr.next;
				hor = hor.next;
				ver2 = curr.bottom;
				while(ver2 != null && ver != null){
					if(ver2.data < ver.data)
						curr.bottom = ver2;
						curr = curr.bottom;
					
				}
					
				
			}
			else{
				curr.bottom = ver;
				curr = curr.bottom;
				if(ver != null)
					ver = ver.next
			}
		}
		return head;
	}
}