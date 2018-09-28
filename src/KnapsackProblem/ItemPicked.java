package KnapsackProblem;
import java.util.ArrayList;

public class ItemPicked {
	private ArrayList<Item> list;
	private int totalV;
	private int totalC;
	
	
	public ItemPicked() {

	}
	
	/**
	 * @param list
	 * @param totalV
	 * @param totalC
	 */
	public ItemPicked(ArrayList<Item> list, int totalV, int totalC) {
		this.list = list;
		this.totalV = totalV;
		this.totalC = totalC;
	}
	/**
	 * @return the list
	 */
	public ArrayList<Item> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	/**
	 * @return the totalV
	 */
	public int getTotalV() {
		return totalV;
	}
	/**
	 * @param totalV the totalV to set
	 */
	public void setTotalV(int totalV) {
		this.totalV = totalV;
	}
	/**
	 * @return the totalC
	 */
	public int getTotalC() {
		return totalC;
	}
	/**
	 * @param totalC the totalC to set
	 */
	public void setTotalC(int totalC) {
		this.totalC = totalC;
	}

	
	
}
