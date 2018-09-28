package KnapsackProblem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Class that generate 100 random knapsack instances, and output into a txt file.
 */
public class GenerateKnapSackInstances {

	public static void main(String[] args) throws IOException {
		String fileName = "KnapsackInstances.txt";
		int numOfInstance  = 100;
		FileWriter file = new FileWriter(new File(fileName));
		for(int i = 1; i<numOfInstance+1; i++){
			file.write("Instance"+" "+i+"\n");
			int budget = (int) Math.floor(Math.random()*20000 + 2000);
			file.write(budget+"");
			int size = 200;
			for(int j = 0; j<size;j++){
				int value = (int) Math.floor(Math.random()*2000+1);
				int cost = (int) Math.floor(Math.random()*2000+1);
				file.write("\n" + value + "," + cost);
			}
			file.write("\n");
			
		}
		file.close();
	}

}
