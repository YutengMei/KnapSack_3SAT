package KnapsackProblem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 * Class that implement different knapsack algorithms.
 */
public class Maximum_Knapsack {
	
	public Maximum_Knapsack() {
			
	}
	
	//Maximum Knapsack Dynamic programming algorithm O(n*w)
	public static ItemPicked knapSack_DP(Knapsack item){
		int[][] table = new int[item.getItemList().length+1][item.getBudget()+1];
		ArrayList<Item> pick = new ArrayList();
		for(int i = 1; i <= item.getItemList().length; i++){
			for (int j = 0; j<=item.getBudget(); j++){
				if(item.getItemList()[i-1].getCost()>j){
					table[i][j] = table[i-1][j];
				
				}
				else{
					table[i][j] = (int) Math.max(table[i-1][j], table[i-1][(int) (j-item.getItemList()[i-1].getCost())]+ item.getItemList()[i-1].getVal());	
				}
				
			}
		}
		
		//Record optimal solution.
		int res = table[item.getItemList().length][item.getBudget()];
		int totalV = res;
		//System.out.println(res);
		int w =  item.getBudget();
		for (int i = item.getItemList().length; i>0 && res >0; i--){
			if(res == table[i-1][w])
				continue;
			else{
				pick.add(item.getItemList()[i-1]);
				res = (int) (res - item.getItemList()[i-1].getVal());
				w = (int) (w - item.getItemList()[i-1].getCost());
			}
		}		
		
//		for(int z = 0 ; z<pick.size();z++){
//			System.out.println(pick.get(z).getCost());
//		}
		//System.out.println(res);
	
		return new ItemPicked(pick, totalV, item.getBudget()-w);
		
	}

	//Maximum Knapsack FPTAS algorithm.
	public static ItemPicked FPTAS(Knapsack item, double eplison){	
		
		int weight[] = new int[item.getItemList().length];
		int scaled[] = new int[item.getItemList().length];
		int amax = getMaxValueitem(item.getItemList());
		int n = item.getItemList().length;
		
		for(int i = 0; i< item.getItemList().length; i++){
			weight[i] = (int) item.getItemList()[i].getCost();
		}
				
		for (int i = 0; i< item.getItemList().length; i++){
			scaled[i] = (int) Math.floor((item.getItemList()[i].getVal()/amax) * n * (1/eplison));
		}
		Item[] scaledValue = new Item[n];
		
		for(int i = 0; i<scaledValue.length;i++){
			scaledValue[i] = new Item(i,scaled[i],item.getItemList()[i].getCost());
		}
		
		Knapsack scaledKS = new Knapsack(scaledValue,item.getBudget());
		ItemPicked solution  = knapSack_DP_min_cost(scaledKS);
		ArrayList<Item> picked = new ArrayList<Item>();
		Item[] itemList = item.getItemList();
		int totalVal = 0;
		int totalCost = 0;
		
		for(int i = 0 ; i<solution.getList().size(); i++){
			
			totalVal += itemList[solution.getList().get(i).getId()].getVal();
			totalCost += itemList[solution.getList().get(i).getId()].getCost();
			picked.add(solution.getList().get(i));
		}
		//System.out.println(totalVal);
		return new ItemPicked(picked,totalVal,totalCost);
	
	}
	
	//Maximum Knapsack dynamic programming min cost algorithm O(n*n*v(amax))
	public static ItemPicked knapSack_DP_min_cost(Knapsack item){
		int amax = getMaxValueitem(item.getItemList());
		//System.out.println(amax);
		//ArrayList<Item> pick = new ArrayList();
		int value [] = new int[item.getItemList().length];
		int cost [] = new int[item.getItemList().length];
		
		for(int i = 0; i<item.getItemList().length;i++){
			value[i] = (int) item.getItemList()[i].getVal();
			cost[i] = (int) item.getItemList()[i].getCost();
		}
		
		int n = item.getItemList().length;
		
		int [][] MinCost  = new int[n][n * amax+1];
		boolean [][] take = new boolean[n][n * amax+1];


		for (int i = 0; i< n; i++){
			MinCost[i][0] = 0;
		}

		for(int t = 1; t<=value[0]; t++){

			MinCost[0][t] = cost[0];
			take[0][t] = true;
		}

		for (int t = (int) (value[0]+1); t<=n*amax; t++){
			MinCost[0][t] = Integer.MAX_VALUE;
			take[0][t] = false;
		}


		for (int i = 1; i< n; i++){
			for (int t = 1; t<=n*amax ; t++){

				int NextT = Math.max(0, t-value[i]);
				int NewCost = cost[i] + MinCost[i-1][NextT];
				if(NewCost<0){
					NewCost = Integer.MAX_VALUE;
				}

				if (MinCost[i-1][t]<= NewCost){
					MinCost[i][t] = MinCost[i-1][t];
					take[i][t] = false;
				}
				else{
					MinCost[i][t] = cost[i]+MinCost[i-1][NextT];
					take[i][t]=true;
				}
			}
		}
		
		//Get optimal solution by traversing Mincost table.
		int budget = item.getBudget();
		int res = n * amax;
		while (res > 0 && MinCost[n - 1][res] > budget) {
			res--;
		}
		ArrayList<Item> pick = new ArrayList<Item>();
		int i = value.length - 1;
		int j = res;
		while (i >= 0 && j > 0) {
			if (take[i][j]) {
				pick.add(item.getItemList()[i]);
				j -= value[i];
			}
			i--;
		}


		//System.out.println(res);
		return new ItemPicked(pick, res, MinCost[n - 1][res]);

	}
	
	//Maximum Knapsack greedy 2 approximation algorithm.
	public static ItemPicked greedy_2_approx(Knapsack item){
		//System.out.println(item.size());
		ArrayList<Item> G = new ArrayList();
		ArrayList<Item> amax = new ArrayList();
		Arrays.sort(item.getItemList(),new Sortbyvalue());
//		for(int i = 0; i < item.getItemList().length ; i++){
//			System.out.println(item.getItemList()[i].getId());
//		}
//		
		double L = item.getBudget();
		for (int i = 0; i < item.getItemList().length && (L > 0); i++){
			//System.out.println(i);
			if(item.getItemList()[i].getCost()<= L){
				G.add(item.getItemList()[i]);
				L = L - item.getItemList()[i].getCost();
			}
		}
		amax.add(getMaxValueArr(item.getItemList()));
		
		int totalV = 0;
		int totalC = 0;
		
		if(amax.get(0).getVal()>getSum(G)){
			totalV = (int) amax.get(0).getVal();
			totalC = (int) amax.get(0).getCost();
			//System.out.println(totalV);
			return new ItemPicked(amax, totalV, totalC);
		}
		else{
			for(int i = 0; i<G.size(); i++){
				totalV = (int) (totalV  + G.get(i).getVal());
				totalC = (int) (totalC  + G.get(i).getCost());
				
			}
			//System.out.println(totalV);
			return new ItemPicked(G, totalV, totalC);
		}
		
	
	}
	
	//Helper function: Displays a 2d array in the console, one line per row.
	public static void printMatrix(int[][] grid) {
		System.out.println("print matrix?");
	    for(int r=0; r<grid.length; r++) {
	       for(int c=0; c<grid[r].length; c++)
	           System.out.print(grid[r][c] + " ");
	       System.out.println();
	    }
	}
	
	
	public static int getMaxValueitem(Item[] items){
		int maxValue = (int) items[0].getVal();
		for(int i=1;i<items.length;i++){
			if(items[i].getVal() > maxValue){
				maxValue = (int) items[i].getVal();
			}
		}
		return maxValue;
	}
	
	public static double getSum(ArrayList<Item> item){
		double sum = 0;
		
		for (int i = 0;  i < item.size(); i++){
			sum = sum + item.get(i).getVal();
		}
		return sum;
	}
	
	public static Item getMaxValueArr(Item[] item){
		double maxValue = item[0].getVal();
		int idx = 0;
		for(int i=1;i<item.length;i++){
			if(item[i].getVal() > maxValue){
				maxValue = item[i].getVal();
				idx = i;
			}
		}
		return item[idx];
	}
	
	
}
