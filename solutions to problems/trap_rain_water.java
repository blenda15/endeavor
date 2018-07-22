//Trapping rain water

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	
	
	//Using stack
	static int trapWater(int[] arr, int n){
        int ans = 0; int current =0;
        Stack<Integer> st = new Stack<>();
        while(current<n){
            while(!st.isEmpty() && arr[current]>arr[st.peek()]){
                int top = st.pop();
                if(st.isEmpty()){
                    break;
                }
                int distance = current - st.peek()-1;
                int bounded_height = Math.min(arr[current], arr[st.peek()])- arr[top];
                ans += distance*bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
	
	//Using array O(n)
	static int trapWater(int[] arr, int n){
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = arr[0];
        max_right[n-1] = arr[n-1];
        for(int i =1;i<n; i++){
            max_left[i] = Math.max(max_left[i-1], arr[i]);
        }
        for(int i =n-2;i>=0; i--){
            max_right[i] = Math.max(max_right[i+1], arr[i]);
        }
        int water = 0;
        for(int i=1; i<n-1;i++){
            water += Math.min(max_left[i], max_right[i])-arr[i];
        }
        return water;
    }
	

	//O(n*n) Brute force
    static int trapWater(int[] arr, int n){
        int water =0;
        for(int i =1;i<n; i++){
            int max_left = 0;
            int max_right = 0;
            for(int j =i; j>=0; j--){
                max_left = Math.max(arr[j], max_left);
            }
            for(int j=i; j<n;j++){
                max_right = Math.max(arr[j],max_right);
            }
            water += (Math.min(max_left, max_right)-arr[i]);
        }
        return water;
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0; i<n ;i++){
	            arr[i] = sc.nextInt();
	        }
	        System.out.println(trapWater(arr, n));
	    }
	    
	}
}