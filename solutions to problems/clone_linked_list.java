//clone linked list with a arb pointer

{

import java.util.*;
class Node
{
    int data;
    Node next, arb;
    
    Node(int d)
    {
        next = arb = null;
    }
}
class Cloning
{
   static Node head;
    
    public static void addToTheLast(Node node)
    {
        	if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    
    
    public static boolean validation(Node head,Node res,Node cloned_add,Node generated_add)
    {
        
    if(generated_add==cloned_add)
        return false;
	Node temp1 = head;
	Node temp2 = res;
	int len1=0,len2=0;
	while(temp1!=null)
	{
		len1++;
		temp1=temp1.next;
	}
	while(temp2!=null)
	{
		len2++;
		temp2 = temp2.next;
	}
	/*if lengths not equal */
	if(len1!=len2)
	return false;
	temp1= head;
	temp2=res;
	while(temp1!=null)
	{
		if(temp1.data!=temp2.data)
		return false;
		if(temp1.arb!=null && temp2.arb!=null)
		{
			if(temp1.arb.data!=temp2.arb.data)
			return false;
		}else if(temp1.arb!=null && temp2.arb==null)
			return false;
		temp1= temp1.next;
		temp2=temp2.next;
	}
	return true;
    }
   // public static void printList()
   
   public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       
       while(t-- > 0)
       {
           Node generated_add = null;
           int n = sc.nextInt();
           int q = sc.nextInt();
           
           int a1 = sc.nextInt();
           Node head = new Node(a1);
           addToTheLast(head);
           
           for(int i = 1; i < n; i++)
           {
               int a = sc.nextInt();
               addToTheLast(new Node(a));
           }
           
             for(int i=0;i<q;i++)
    {
       int a = sc.nextInt();
       int b = sc.nextInt();
       
       Node tempA=head;
       int count=-1;
       while(tempA!=null)
       {
           count++;
           if(count==a-1)
            break;
           tempA=tempA.next;
       }
       Node tempB = head;
       count=-1;
       while(tempB!=null)
       {
           count++;
           if(count==b-1)
            break;
           tempB=tempB.next;
       }
       //when both a is greater than N
       if(a<=n)
       tempA.arb = tempB;
       }
       
       generated_add = head;
       GfG g = new GfG();
       Node res = g.copyList(head);
       
       Node cloned_add = res;
       
       if(validation(head,res,cloned_add,generated_add) == true)
         System.out.println("1");
         else
         System.out.println("false");
       }
       
   }
}

}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

	//function to copy linked list*/
class GfG
{
    Node copyList(Node head)
    {
        Node curr = head;
        Node n;
        //creating new nodes for list
        while(curr.next!= null){
            Node temp = curr.next;
            n = new Node(curr.data);
            curr.next = n;
            n.next = temp;
            curr = temp;
        }
        
        n = new Node(curr.data);
        curr.next = n;
        
        //setting arb pointers
        Node origCurr = head;
        Node newCurr = origCurr.next;
        while(newCurr.next!=null){
            if(origCurr.arb != null)
                newCurr.arb = origCurr.arb.next;    //line189
            origCurr = newCurr.next;
            newCurr = origCurr.next;
        }
        if(origCurr.arb != null)
            newCurr.arb = origCurr.arb.next;
        
        //separate the two lists
        origCurr = head;
        newCurr = origCurr.next;
        Node newHead = origCurr.next;
        while(newCurr.next != null){
            origCurr.next = newCurr.next;
            newCurr.next = origCurr.next.next;
            origCurr = origCurr.next;
            newCurr = newCurr.next;
        }
        origCurr.next = null;
        return newHead;
    }
}