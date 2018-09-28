package KnapsackProblem;
import java.util.Comparator;

public class Item {
	
	private int id;
	private double val;
	private double cost;
	
	/**
	 * @param id
	 * @param val
	 * @param cost
	 */
	public Item(int id, double val, double cost) {
		this.id = id;
		this.val = val;
		this.cost = cost;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the val
	 */
	public double getVal() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void setVal(double val) {
		this.val = val;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getValues(){
		return val/cost;
	}
	
	@Override
	public String toString() {
		String result = "valule: "+this.val + " cost: "+this.cost;
		return result;
	}

	
}



