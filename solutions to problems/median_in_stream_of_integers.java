//Median in a stream of integers (Running median) returning floor of median

//1.Minheap implementation- done using 1 min heap--- failing test cases in GFG beacuse of not taking numbers as stream or shit

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	static double median(ArrayList<Integer> arr){
		int len = arr.size();
		if (len == 0)
			return 0;
		if(len ==1)
			return arr.get(0);
		if(len%2 == 0){
			double median = (arr.get(len/2) + arr.get(len/2-1))/2;
			return median;
		}
		else{
			return arr.get(len/2);
		}
	}
	
	static int heapifyUtil(ArrayList<Integer> arr, int position, int heapSize){
		int child = 2*position+1;
		if(child >= heapSize)
			return -1;
		if(child+1 < heapSize && arr.get(child) > arr.get(child+1))
			child++;
		if(arr.get(child) < arr.get(position)){
			int temp = arr.get(child);
			arr.set(child, arr.get(position));
			arr.set(position, temp);
			return child;
		}
		return -1;
	}
	
	static void heapify(ArrayList<Integer> arr){
		int heapSize = arr.size();
		for(int i = heapSize-1; i>-1; i--){
			int index = heapifyUtil(arr, i, heapSize);
			while(index != -1){
				index = heapifyUtil(arr, index, heapSize);
			}
		}
	}

	static void addElem(ArrayList<Integer> arr, int e){
		arr.add(e);
	}
	
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
			int[] a = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			GFG g = new GFG(); // had added this in hope of removing the above mentioned issue in submission, like in below code
	        ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i =0; i<n;i++){
	            //int e = sc.nextInt();
				g.addElem(arr,a[i]);
	            //arr.add(e);
	            g.heapify(arr);
				int ans = (int)Math.floor(g.median(arr));
	            System.out.println(ans);
	        }
	}
}
---------------------------------------------------------------------------------------------------------------------------------------

//2. Using Priority Queues. Passes all test cases
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Solution S = new Solution();
        PriorityQueue<Integer> upperMinHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> lowerMaxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        	public int compare(Integer a,Integer b){
        		return -1*a.compareTo(b);
        	}
        });
        for(int i = 0;i<a.length;i++){
        	S.addNumberToHeaps(a[i],lowerMaxHeap,upperMinHeap);
        	S.rebalanceHeaps(lowerMaxHeap,upperMinHeap);
        	System.out.println(S.calculateMedian(lowerMaxHeap,upperMinHeap));
        }
    }

    void addNumberToHeaps(int n,PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
    	if(lowerMaxHeap.size()==0 || n<lowerMaxHeap.peek())
    		lowerMaxHeap.add(n);
    	else
    		upperMinHeap.add(n);
    }

    void rebalanceHeaps(PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
    	PriorityQueue<Integer> biggerHeap = lowerMaxHeap.size()>upperMinHeap.size()?lowerMaxHeap:upperMinHeap;
    	PriorityQueue<Integer> smallerHeap = lowerMaxHeap.size()<upperMinHeap.size()?lowerMaxHeap:upperMinHeap;

    	if(biggerHeap.size()-smallerHeap.size()>=2){
    		smallerHeap.add(biggerHeap.poll());
    	}
    }

    int calculateMedian(PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
		PriorityQueue<Integer> biggerHeap = lowerMaxHeap.size()>upperMinHeap.size()?lowerMaxHeap:upperMinHeap;
    	PriorityQueue<Integer> smallerHeap = lowerMaxHeap.size()<upperMinHeap.size()?lowerMaxHeap:upperMinHeap;

    	if(biggerHeap.size()==lowerMaxHeap.size())
    		return (int)Math.floor(((double)biggerHeap.peek()+lowerMaxHeap.peek())/2);
    	return ((int)Math.floor(biggerHeap.peek()));
    }


}