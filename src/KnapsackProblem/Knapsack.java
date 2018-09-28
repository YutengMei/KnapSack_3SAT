package KnapsackProblem;

public class Knapsack {
	
	private Item[] itemList;
	private int budget;
	
	
	public Knapsack(){
		
	}
	
	/**
	 * @return the itemList
	 */
	
	public Knapsack(Item[] list, int budget){
		setItemList(list);
		setBudget(budget);
	}
	
	public Item[] getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(Item[] itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}

	
	@Override
	public String toString() {
		String str = "budget = " + budget + "\n";
		for(int i = 0; i < itemList.length; i++){
			str += (i+1) + ". " + itemList[i].toString() + "\n";
		}
		return str;
	}
	
	
}
