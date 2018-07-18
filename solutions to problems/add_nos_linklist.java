
Node addTwoLists(Node first, Node second){
	Node curr1 = first;         
	Node curr2 = second;
	Node result = new Node();
	Node resCurr= result;
	int carryOver=0;
	while(curr1!=null || curr2!=null){
		if (resCurr!=null){
			resCurr.next= new Node();
			resCurr = resCurr.next;}
		int sum = curr1.data+curr2.data+carryOver;
		if(sum >9){
			resCurr.data= sum-10;
			carryOver =1;}
		else{
			resCurr.data = sum;
			carryOver =0;
		}
		
		if(curr1.next!=null && curr2.next!=null){
			curr1=curr1.next;
			curr2=curr2.next;
		}
		else
		break;
		//if(curr2.next!=null) 
			//curr2=curr2.next;
		//else
		//break;
		
	}
	if(curr1.next==null && curr2.next!=null){
		curr2.next.data +=carryOver;
		resCurr.next= curr2.next;
		
	}
		
	if(curr2.next==null && curr1.next!=null){
		curr1.next.data +=carryOver;
		resCurr.next= curr1.next;
	}
		
	return result;
}

///recursive---TRY

1 7 1 5 1 3 3 9 4 8 2 3 6 0 9 0 7 0 2 0 0 0 4 0 8 1 1 9 9 3 9 9 1 2 6 4 7 9 3 2 8 7 5 6 0 4 6 9 6 8 9 6 8 5 9 8 7 0 7 8 5 8 7 8 0 5 2 8 5
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 5 7 9 1 7 3 9 6 9 9 8 7 7 3 6 5 2


Recursive

Node addTwoLists(Node first, Node second){
	int carry =0;
	int result =new Node();
	resCurr= result;
	Node curr1 = first;
	Node curr2 = second;
	int sum =0;
	while(curr1.next != null || curr2.next != null){
		if(sum>9){
			resCurr.data = sum-10;
			carry =1;
		}
		else{
			resCurr.data = sum;
			carry = 0;
		}
		curr1= curr1.next;
		curr2 = curr2.next;
		resCurr.next=new Node();
	}
	
	sum = curr1.data+curr2.data+carry;
	
	if(curr1.next != null && curr2.next == null){
		if(sum > 9){
			resCurr.data = sum-10;
			resCurr.next = add(new Node(1), curr1.next);
		}
		else{
			resCurr.data = sum;
			resCurr.next = curr1.next;
		}
	}
	else if(curr2.next != null && curr1.next == null){
		if(sum > 9){
			resCurr.data = sum-10;
			resCurr.next = add(new Node(1), curr2.next);
		}
		else{
			resCurr.data = sum;
			resCurr.next = curr2.next;
		}
	}
	else{
		if(sum < 9){
			resCurr.data = sum;
		}
		else{
			resCurr.data = sum-10;
			resCurr.next = new Node(1);
		}
	}
	
}
