package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
The 0-1 knapsack problem is the following. A thief robbing a store finds n items.
The ith item is worth 􏰢i dollars and weighs wi pounds, where 􏰢i and wi are integers.
The thief wants to take as valuable a load as possible, but he can carry at most W
pounds in his knapsack, for some integer W . Which items should he take?
In the fractional knapsack problem, the setup is the same, but the thief can take
fractions of items, rather than having to make a binary (0-1) choice for each item.
*/

class KnapSackItem {
	private int idx;
	public double weight;
	public double value;
	public Double valuePerWeight;
	
	public KnapSackItem(int idx, double weight, double value) {
		this.idx = idx;
		this.weight = weight;
		this.value = value;
		this.valuePerWeight = value / weight;
	}
}

public class FractionalKnapSack {
	
	public int findBestFractionalKnapSack(double[] w, double[] v, double W) {
		int numItems = w.length;
		int optimalValue = 0;

		// Create objects of items
		KnapSackItem[] items = new KnapSackItem[numItems];
		for (int i=0; i<numItems; i++) {
			items[i] = new KnapSackItem(i, w[i], v[i]);
		}
		
		// Sort item objects in descending order of valuePerWeight
		Arrays.sort(items, new Comparator<KnapSackItem>() {
			@Override
			public int compare(KnapSackItem i1, KnapSackItem i2) {
				return i2.valuePerWeight.compareTo(i1.valuePerWeight);
			}
			
		});
		
		// Make greedy choice (highest valuePerWeight),
		// If weight of current object is less than remaining capacity, use full item
		// If not use fraction of that item
		double remainingCapacity = W;
		for(KnapSackItem item: items) {
			double currentWeight = item.weight;
			double currentValue = item.value;
			
			if (currentWeight <= remainingCapacity) {
				optimalValue += currentValue;
				remainingCapacity -= currentWeight;
			} else {
				double fraction = remainingCapacity / currentWeight;
				optimalValue += fraction * currentValue;
				remainingCapacity = 0;
			}	
		}
		
		return optimalValue;
	}
	
	public static void main(String[] args) {
		FractionalKnapSack fks = new FractionalKnapSack();
		
		double W = 50;
		double[] w = {10, 20, 30};
		double[] v = {60, 100, 120};
		int optimalValue = fks.findBestFractionalKnapSack(w, v, W);
		System.out.println(optimalValue);
	}
}