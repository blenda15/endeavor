//Check if Linked List is Palindrome

boolean isPalindrome(Node head){
	if(head == null || head.next == null)
		return 0;
	Stack st = new Stack();
	Node slow = head;
	Node fast = head;
	while(fast.next != null || fast.next.next != null){
		st.push(slow);
		slow =slow.next;
		fast = fast.next.next;
	}
	
	Node mid = slow;
	if(fast.next == null)
		mid = mid.next;
	else{
		st.push(mid);
		mid = mid.next;
	}
		
	while(!st.isEmpty()){
		if(st.pop() != mid.data)
			return false;
		mid = mid.next;
	}
	return true;
}