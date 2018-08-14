//https://www.interviewbit.com/problems/coins-in-a-line/

public class Solution {
    public int maxcoin(int[] A, int start, int end){
        int x = 0;
        if(start>=end)
            return 0;
        if(A[end]>A[start]){
            end--;
        }
        else{
            start++;
        }
        return Math.max(maxcoin(A, start+1, end) +A[start], maxcoin(A, start, end-1)+A[end]);
    }
    
    public int maxcoin(int[] A) {
        int start = 0;
        int end = A.length-1;
        return Math.max(maxcoin(A, start+1, end) +A[start], maxcoin(A, start, end-1)+A[end]);
    }
}
