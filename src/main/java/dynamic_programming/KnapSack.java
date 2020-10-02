package dynamic_programming;

/*
The 0-1 knapsack problem is the following. A thief robbing a store finds n items.
The ith item is worth 􏰢i dollars and weighs wi pounds, where 􏰢i and wi are integers.
The thief wants to take as valuable a load as possible, but he can carry at most W
pounds in his knapsack, for some integer W . Which items should he take?
*/

public class KnapSack {
	
	// Method for getting the minimum value
	  public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 

	public int findBestKnapSack(int[] w, int[] v, int W) {
		// Initialize memoised array
		int n = w.length;
		int[][] memo = new int[n+1][W+1];
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=W; j++) {
				memo[i][j] = 0;
			}
		}
		int optimalValue = knapSackRecurse(w, v, W, n, memo);		
		return optimalValue;
	}
	
	public int knapSackRecurse(int[] w, int[] v, int W, int n, int[][] memo) {
		// Base cases
		if (n <= 0) {
			return 0;
		}
		
		// Return memoised values
		if (memo[n][W] > 0) {
			return memo[n][W];
		}
		
		if (w[n-1] > W) {
			memo[n][W] = knapSackRecurse(w, v, W, n-1, memo);
		} else {
			memo[n][W] = Math.max(knapSackRecurse(w, v, W, n-1, memo), 
					v[n-1] + knapSackRecurse(w, v, W-w[n-1], n-1, memo));
		}
	
		return memo[n][W];
	}
	
	public static void main(String[] args) {
		KnapSack ks = new KnapSack();
		
		int W = 50;
		int[] w = {10, 20, 30};
		int[] v = {60, 100, 120};
		int optimalValue = ks.findBestKnapSack(w, v, W);
		System.out.println(optimalValue);
	}
}