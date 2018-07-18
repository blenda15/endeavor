//Segregate even and odd nodes in a Linked List
CCOOOORRECT THIS-- ERONG APPROACH SEE IN GFG
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node next;
    public Node(int data){
        data = this.data;
    }
}

class GFG {
    static Node order(Node head){
        Node curr = head;
        Node firstOdd = null;
        Node previousEven = null;
        Node prev = null;
        while(curr!=null){
            //Odd Node
            if(curr.data % 2 == 1){
                if(firstOdd ==null){
                    firstOdd = curr;
                }
            }
            
            //even Node
            else{
                if(previousEven == null){
                    previousEven = curr;
                    head = previousEven;
                }
                else{//repetitive in case of 2nd case
                    previousEven.next = curr;
                    previousEven = previousEven.next;
                    prev.next = curr.next;//wrong for second case
                }
                //if(prev != null)
                    //prev.next = curr.next;
                if(firstOdd != null){
                    curr.next = firstOdd;
                    curr=prev;
                }
            }
            prev = curr;
            curr = curr.next;
            //curr= prev.next;
        }
        return head;
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int tests = sc.nextInt();
	    Node prev = new Node(sc.nextInt());
	    tests--;
	    while(tests-->0){
	        Node node = new Node(sc.nextInt());
	        prev.next = node;
	        prev = node;
	        Node head = order(prev);
    	    Node curr = head;
    	    while(curr != null){
    	        System.out.print(curr.data + " ");
    	    }
    	    System.out.println();
	    }
	}
}