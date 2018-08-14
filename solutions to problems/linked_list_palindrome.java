/* Check if linked list is palindrome*/
	boolean isPalindrome(Node head) 
	{
		Node slow = head; 
		Node fast = head;
		Node prev = head;
		Node midpt = null;
		boolean res = true;

		if (head != null && head.next != null) 
		{
			//middle of list in slow pointer
			while (fast != null && fast.next != null) 
			{
				fast = fast.next.next;
				prev = slow;
				slow = slow.next;
			}
			if (fast != null) 
			{
				midpt = slow;
				slow = slow.next;
			}

			// Reverse the second half and compare it with first half
			Node head2 = slow;
			prev.next = null;
			Node prev2 = null;
    		Node current = head2;
    		Node next;
    		while (current != null) 
    		{
    			next = current.next;
    			current.next = prev2;
    			prev2 = current;
    			current = next;
    		}
    		head2 = prev2;
			
			boolean ans = compare(head, head2);			
			if (midpt != null) 
			{
				prev.next = midpt;
				midpt.next = head2;
			} else
				prev.next = head2;
		}
		return ans;
	}

	boolean compare(Node head1, Node head2) 
	{
		Node temp1 = head1;
		Node temp2 = head2;
		while (temp1 != null && temp2 != null) 
		{
			if (temp1.data == temp2.data) 
			{
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else
				return false;
		}
		if (temp1 == null && temp2 == null)
			return true;
		return false;
	}