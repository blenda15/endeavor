//Merge k sorted arrays
class GfG{
    
    static class HeapNode implements Comparable<HeapNode>{
        int value;
        int arrNo;
        int index;
        public HeapNode(int value, int arrNo, int index){
            this.value = value;
            this.arrNo = arrNo;
            this.index = index;
        }
        public int compareTo(HeapNode o){
            if(o.value<this.value)
                return 1;
            else if(o.value>this.value)
                return -1;
            else
                return 0;
        }
        
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k){
        PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i =0; i<k; i++){
            pq.add(new HeapNode(arrays[i][0], i, 0));
        }
        while(!pq.isEmpty()){
            HeapNode h = pq.poll();
            ans.add(h.value);
            if(h.index<k-1){
                pq.add(new HeapNode(arrays[h.arrNo][h.index+1], h.arrNo, h.index+1));
            }
        }
        return ans;
        }
}