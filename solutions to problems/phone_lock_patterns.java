//Number of mobile lock patterns
//number of dots = 9 (3x3 grid), min and max dots needed as input

class GFG{
    static final int N = 3; 
    
    public static int dfs(int si, int sy, int count, int[] dx, int[] dy, boolean[][] visited){
        if(count == 0)
            return 1;
        if(count <0)
            return 0;
        visited[si][sy] = true;
        int ways = 0;
        int elem = 0;
        int new_i, new_j;
        while(elem<8){
            new_i = si+dx[elem];
            new_j = sy+dy[elem];
            if(new_i>=0&&new_i<N&&new_j>=0&&new_j<N){
                //if(!visited[new_i][new_j]){
                    ways += dfs(new_i, new_j, count-1, dx, dy, visited);
                    
                //}
                visited[new_i][new_j] = false;
            }
            elem++;
        }
        //visited[si][sy] = true;
        return ways;
    }
    public static void initVisited(boolean[][] visited){
        for(int i =0;i<N; i++){
            for(int j =0; j<N;j++){
                visited[i][j] = false;
            }
        }
    }
    
    public static int count(int min, int max){
        int ways =0;
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        boolean[][] visited = new boolean[N][N];
        for(int i =min; i<=max; i++){
            ways += 4*dfs(0, 0, i, dx, dy, visited); //1,3,7,9 symmetrical
            //initVisited(visited);
            ways += 4*dfs(0, 1, i, dx, dy, visited);//2,4,6,8 symmetrical
            //initVisited(visited);
            ways += dfs(1, 1, i, dx, dy, visited);//for 5
            //initVisited(visited);
        }
        return ways;
    }
    
    public static void main(String[] args){
        System.out.println(count(4, 6));
    }
}