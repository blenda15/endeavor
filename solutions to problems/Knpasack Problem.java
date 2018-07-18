0 - 1 Knapsack Problem

int knapsack(int n, int w, int[] val, int[] wt){
	if(n==0|| w==0){
		return 0;
	}
	if(wt[n-1] > w)
		return knapsack(n-1, w, val, wt);
	else
		return max(knapsack(n-1, w, val, wt), knapsack(n-1, w-wt[n-1],val, wt));	
}