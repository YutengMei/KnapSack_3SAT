package KnapsackProblem;

public class MinCostAndTake {
	
	private int [][] MinCost; 
	boolean [][] take;
	
	public MinCostAndTake() {

	}
	/**
	 * @param minCost
	 * @param take
	 */
	public MinCostAndTake(int[][] minCost, boolean[][] take) {
		this.MinCost = minCost;
		this.take = take;
	}
	/**
	 * @return the minCost
	 */
	public int[][] getMinCost() {
		return MinCost;
	}
	/**
	 * @param minCost the minCost to set
	 */
	public void setMinCost(int[][] minCost) {
		MinCost = minCost;
	}
	/**
	 * @return the take
	 */
	public boolean[][] getTake() {
		return take;
	}
	/**
	 * @param take the take to set
	 */
	public void setTake(boolean[][] take) {
		this.take = take;
	}

	
	
}
