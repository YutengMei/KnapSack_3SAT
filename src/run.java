import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import KnapsackProblem.Item;
import KnapsackProblem.ItemPicked;
import KnapsackProblem.Knapsack;
import KnapsackProblem.Maximum_Knapsack;
import ThreeSATProblem.CNF;
import ThreeSATProblem.Clause;
import ThreeSATProblem.Literals;
import ThreeSATProblem.ThreeSAT;
/*
 * Run this class to get statistic of different algorithms.
 */

public class run {
	
	private static double knapSack_DP_Avg_time = 0;
	private static double knapSack_DP_Max_time = 0;
	private static double knapSack_DP_Min_time = 0;
	private static double knapSack_DP_Median_time = 0;
	
	private static double knapSack_DP_min_cost_Avg_time = 0;
	private static double knapSack_DP_min_cost_Max_time = 0;
	private static double knapSack_DP_min_cost_Min_time = 0;
	private static double knapSack_DP_min_cost_Median_time = 0;
	
	private static double FPTAS_Avg_time = 0;
	private static double FPTAS_Max_time = 0;
	private static double FPTAS_Min_time = 0;
	private static double FPTAS_Median_time = 0;
	
	private static double FPTAS2_Avg_time = 0;
	private static double FPTAS2_Max_time = 0;
	private static double FPTAS2_Min_time = 0;
	private static double FPTAS2_Median_time = 0;
	
	private static double FPTAS10_Avg_time = 0;
	private static double FPTAS10_Max_time = 0;
	private static double FPTAS10_Min_time = 0;
	private static double FPTAS10_Median_time = 0;
	
	private static double greedy_2_approx_Avg_time = 0;
	private static double greedy_2_approx_Max_time = 0;
	private static double greedy_2_approx_Min_time = 0;
	private static double greedy_2_approx_Median_time = 0;
		
	private static double knapSack_DP_min_cost_Avg_Quality  = 0;
	private static double knapSack_DP_min_cost_Max_Quality  = 0;
	private static double knapSack_DP_min_cost_Min_Quality  = 0;
	private static double knapSack_DP_min_cost_Median_Quality  = 0;
	
	private static double FPTAS_Avg_Quality  = 0;
	private static double FPTAS_Max_Quality  = 0;
	private static double FPTAS_Min_Quality  = 0;
	private static double FPTAS_Median_Quality  = 0;
	
	private static double FPTAS2_Avg_Quality  = 0;
	private static double FPTAS2_Max_Quality  = 0;
	private static double FPTAS2_Min_Quality  = 0;
	private static double FPTAS2_Median_Quality  = 0;
	
	private static double FPTAS10_Avg_Quality  = 0;
	private static double FPTAS10_Max_Quality  = 0;
	private static double FPTAS10_Min_Quality  = 0;
	private static double FPTAS10_Median_Quality  = 0;
	
	private static double greedy_2_approx_Avg_Quality  = 0;
	private static double greedy_2_approx_Max_Quality  = 0;
	private static double greedy_2_approx_Min_Quality  = 0;
	private static double greedy_2_approx_Median_Quality  = 0;
	
	private static double DPLL_Avg_time = 0;
	private static double DPLL_Max_time = 0;
	private static double DPLL_Min_time = 0;
	private static double DPLL_Median_time = 0;
	
	private static double GSAT_Avg_time = 0;
	private static double GSAT_Max_time = 0;
	private static double GSAT_Min_time = 0;
	private static double GSAT_Median_time = 0;
	
	private static double ApproxMax3SAT_Avg_time = 0;
	private static double ApproxMax3SAT_Max_time = 0;
	private static double ApproxMax3SAT_Min_time = 0;
	private static double ApproxMax3SAT_Median_time = 0;

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Running...");
		getKnapSackTimeStat();
		System.out.println("------------------------------------------------");
		System.out.println("------KnapSack Algorithms Runing Time Stat------");
		System.out.println("------------------------------------------------");
		System.out.println("=============knapSack_DP_max_value=============");
		System.out.println("Average time: "+ knapSack_DP_Avg_time);
		System.out.println("Maximum time: "+ knapSack_DP_Max_time);
		System.out.println("Minimum time: "+ knapSack_DP_Min_time);
		System.out.println("Median time: "+ knapSack_DP_Median_time);
		System.out.println("=============knapSack_DP_min_cost==============");
		System.out.println("Average time: "+ knapSack_DP_min_cost_Avg_time);
		System.out.println("Maximum time: "+ knapSack_DP_min_cost_Max_time);
		System.out.println("Minimum time: "+ knapSack_DP_min_cost_Min_time);
		System.out.println("Median time: "+ knapSack_DP_min_cost_Median_time);
		System.out.println("==================FPTAS(0.5)====================");
		System.out.println("Average time: "+ FPTAS_Avg_time);
		System.out.println("Maximum time: "+ FPTAS_Max_time);
		System.out.println("Minimum time: "+ FPTAS_Min_time);
		System.out.println("Median time: "+ FPTAS_Median_time);
		System.out.println("==================FPTAS(2)====================");
		System.out.println("Average time: "+ FPTAS2_Avg_time);
		System.out.println("Maximum time: "+ FPTAS2_Max_time);
		System.out.println("Minimum time: "+ FPTAS2_Min_time);
		System.out.println("Median time: "+ FPTAS2_Median_time);
		System.out.println("==================FPTAS(10)====================");
		System.out.println("Average time: "+ FPTAS10_Avg_time);
		System.out.println("Maximum time: "+ FPTAS10_Max_time);
		System.out.println("Minimum time: "+ FPTAS10_Min_time);
		System.out.println("Median time: "+ FPTAS10_Median_time);
		System.out.println("==================greedy_2_approx==================");
		System.out.println("Average time: "+ greedy_2_approx_Avg_time);
		System.out.println("Maximum time: "+ greedy_2_approx_Max_time);
		System.out.println("Minimum time: "+ greedy_2_approx_Min_time);
		System.out.println("Median time: "+ greedy_2_approx_Median_time);
		System.out.println("Running...");
		getThreeSatTimeStat();
		System.out.println("------------------------------------------------");
		System.out.println("------ThreeSAT Algorithms Runing Time Stat------");
		System.out.println("------------------------------------------------");
		System.out.println("=================DPLL===================");
		System.out.println("Average time: "+ DPLL_Avg_time);
		System.out.println("Maximum time: "+ DPLL_Max_time);
		System.out.println("Minimum time: "+ DPLL_Min_time);
		System.out.println("Median time: "+ DPLL_Median_time);
		System.out.println("=================GSAT====================");
		System.out.println("Average time: "+ GSAT_Avg_time);
		System.out.println("Maximum time: "+ GSAT_Max_time);
		System.out.println("Minimum time: "+ GSAT_Min_time);
		System.out.println("Median time: "+ GSAT_Median_time);
		System.out.println("==================ApproxMax3SAT===================");
		System.out.println("Average time: "+ ApproxMax3SAT_Avg_time);
		System.out.println("Maximum time: "+ ApproxMax3SAT_Max_time);
		System.out.println("Minimum time: "+ ApproxMax3SAT_Min_time);
		System.out.println("Median time: "+ ApproxMax3SAT_Median_time);
		System.out.println("Running...");
		getKnapSackQualityStat();
		System.out.println("------------------------------------------------");
		System.out.println("--------KnapSack Algorithms Quality Stat--------");
		System.out.println("------------------------------------------------");
		System.out.println("=============knapSack_DP_min_cost==============");
		System.out.println("Average quality: "+ knapSack_DP_min_cost_Avg_Quality);
		System.out.println("Maximum quality: "+ knapSack_DP_min_cost_Max_Quality);
		System.out.println("Minimum quality: "+ knapSack_DP_min_cost_Min_Quality);
		System.out.println("Median quality: "+ knapSack_DP_min_cost_Median_Quality);
		System.out.println("==================FPTAS(0.5)====================");
		System.out.println("Average quality: "+ FPTAS_Avg_Quality);
		System.out.println("Maximum quality: "+ FPTAS_Max_Quality);
		System.out.println("Minimum quality: "+ FPTAS_Min_Quality);
		System.out.println("Median quality: "+ FPTAS_Median_Quality);
		System.out.println("==================FPTAS(2)====================");
		System.out.println("Average quality: "+ FPTAS2_Avg_Quality);
		System.out.println("Maximum quality: "+ FPTAS2_Max_Quality);
		System.out.println("Minimum quality: "+ FPTAS2_Min_Quality);
		System.out.println("Median quality: "+ FPTAS2_Median_Quality);
		System.out.println("==================FPTAS(10)====================");
		System.out.println("Average quality: "+ FPTAS10_Avg_Quality);
		System.out.println("Maximum quality: "+ FPTAS10_Max_Quality);
		System.out.println("Minimum quality: "+ FPTAS10_Min_Quality);
		System.out.println("Median quality: "+ FPTAS10_Median_Quality);
		System.out.println("==================greedy_2_approx==================");
		System.out.println("Average quality: "+ greedy_2_approx_Avg_Quality);
		System.out.println("Maximum quality: "+ greedy_2_approx_Max_Quality);
		System.out.println("Minimum quality: "+ greedy_2_approx_Min_Quality);
		System.out.println("Median quality: "+ greedy_2_approx_Median_Quality);

	}
	
	//Get the quality of different knapsack algorithms.
	public static void getKnapSackQualityStat() throws FileNotFoundException{
		
		Maximum_Knapsack Knapsackrun = new Maximum_Knapsack();
		Knapsack[] instances = ReadKnapsackInstance();
		ArrayList<Double> maximumVal = new ArrayList<>();
		ArrayList<Double> knapSack_DP_min_cost_val = new ArrayList<>();
		ArrayList<Double> FPTAS_val = new ArrayList<Double>();
		ArrayList<Double> FPTAS2_val = new ArrayList<Double>();
		ArrayList<Double> FPTAS10_val = new ArrayList<Double>();
		ArrayList<Double> greedy_2_approx_val = new ArrayList<Double>();
		ArrayList<Double> g2 = new ArrayList<Double>();
		
		double knapSack_DP_min_cost_Tot_quality = 0;
		double FPTAS_Tot_quality = 0;
		double FPTAS2_Tot_quality = 0;
		double FPTAS10_Tot_quality = 0;
		double greedy_2_approx_Tot_quality = 0;
		
		//Record the maximum value of each knapsack instance can achieve with given budget.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.knapSack_DP(instances[i]);
			maximumVal.add((double) items.getTotalV());
			
		}
		
		//Run Mincost algorithm with 100 instances, and record the statistics.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.knapSack_DP_min_cost(instances[i]);
			double quality = items.getTotalV()/maximumVal.get(i);
			knapSack_DP_min_cost_val.add(quality);
			knapSack_DP_min_cost_Tot_quality+=quality;
		}
		Collections.sort(knapSack_DP_min_cost_val);
		knapSack_DP_min_cost_Min_Quality = knapSack_DP_min_cost_val.get(0);
		knapSack_DP_min_cost_Max_Quality = knapSack_DP_min_cost_val.get(knapSack_DP_min_cost_val.size()-1);
		knapSack_DP_min_cost_Avg_Quality = knapSack_DP_min_cost_Tot_quality/knapSack_DP_min_cost_val.size();
		int middle = knapSack_DP_min_cost_val.size()/2;
		if(knapSack_DP_min_cost_val.size()%2 == 1){
			knapSack_DP_min_cost_Median_Quality = knapSack_DP_min_cost_val.get(middle);
		}else{
			knapSack_DP_min_cost_Median_Quality = (knapSack_DP_min_cost_val.get(middle-1)+knapSack_DP_min_cost_val.get(middle))/2;
		}

		//Run FPTAS(0.5) algorithm with 100 instances, and record the statistics.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.FPTAS(instances[i],0.5);
			double quality = items.getTotalV()/maximumVal.get(i);
			FPTAS_val.add(quality);
			FPTAS_Tot_quality+=quality;
		}
		Collections.sort(FPTAS_val);
		FPTAS_Min_Quality = FPTAS_val.get(0);
		FPTAS_Max_Quality = FPTAS_val.get(FPTAS_val.size()-1);
		FPTAS_Avg_Quality = FPTAS_Tot_quality/FPTAS_val.size();
		int middle1 = FPTAS_val.size()/2;
		if(FPTAS_val.size()%2 == 1){
			FPTAS_Median_Quality = FPTAS_val.get(middle1);
		}else{
			FPTAS_Median_Quality = (FPTAS_val.get(middle1-1)+FPTAS_val.get(middle1))/2;
		}

		
		//Run FPTAS(2) algorithm with 100 instances, and record the statistics.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.FPTAS(instances[i],2);
			double quality = items.getTotalV()/maximumVal.get(i);
			FPTAS2_val.add(quality);
			FPTAS2_Tot_quality+=quality;
		}
		Collections.sort(FPTAS2_val);
		FPTAS2_Min_Quality = FPTAS2_val.get(0);
		FPTAS2_Max_Quality = FPTAS2_val.get(FPTAS2_val.size()-1);
		FPTAS2_Avg_Quality = FPTAS2_Tot_quality/FPTAS2_val.size();
		int middle2 = FPTAS2_val.size()/2;
		if(FPTAS2_val.size()%2 == 1){
			FPTAS2_Median_Quality = FPTAS2_val.get(middle2);
		}else{
			FPTAS2_Median_Quality = (FPTAS2_val.get(middle2-1)+FPTAS2_val.get(middle2))/2;
		}

		//Run FPTAS(100) algorithm with 100 instances, and record the statistics.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.FPTAS(instances[i],100);
			double quality = items.getTotalV()/maximumVal.get(i);
			FPTAS10_val.add(quality);
			FPTAS10_Tot_quality+=quality;
	
		}
		Collections.sort(FPTAS10_val);
		FPTAS10_Min_Quality = FPTAS10_val.get(0);
		FPTAS10_Max_Quality = FPTAS10_val.get(FPTAS10_val.size()-1);
		FPTAS10_Avg_Quality = FPTAS10_Tot_quality/FPTAS10_val.size();
		int middle3 = FPTAS10_val.size()/2;
		if(FPTAS10_val.size()%2 == 1){
			FPTAS10_Median_Quality = FPTAS10_val.get(middle3);
		}else{
			FPTAS10_Median_Quality = (FPTAS10_val.get(middle3-1)+FPTAS10_val.get(middle3))/2;
		}
		
		//Run greedy 2 approximation algorithm with 100 instances, and record the statistics.
		for(int i = 0; i<instances.length; i++){
			ItemPicked items = Knapsackrun.greedy_2_approx(instances[i]);
			double quality = items.getTotalV()/maximumVal.get(i);
			greedy_2_approx_val.add(quality);
			greedy_2_approx_Tot_quality+=quality;
	
		}
		Collections.sort(greedy_2_approx_val);
		greedy_2_approx_Min_Quality = greedy_2_approx_val.get(0);
		greedy_2_approx_Max_Quality = greedy_2_approx_val.get(greedy_2_approx_val.size()-1);
		greedy_2_approx_Avg_Quality = greedy_2_approx_Tot_quality/greedy_2_approx_val.size();
		int middle4 = greedy_2_approx_val.size()/2;
		if(greedy_2_approx_val.size()%2 == 1){
			greedy_2_approx_Median_Quality = greedy_2_approx_val.get(middle4);
		}else{
			greedy_2_approx_Median_Quality = (greedy_2_approx_val.get(middle4-1)+greedy_2_approx_val.get(middle4))/2;
		}
	}
	
	//Get the maximum, average, median and mininum run time with different knapsack algorithms.
	public static void getKnapSackTimeStat() throws FileNotFoundException{
		
		Maximum_Knapsack Knapsackrun = new Maximum_Knapsack();
	
		
		ArrayList<Double> knapsack_DP_Time = new ArrayList<Double>();
		ArrayList<Double> knapSack_DP_min_cost_Time = new ArrayList<Double>();
		ArrayList<Double> FPTAS_Time = new ArrayList<Double>();
		ArrayList<Double> FPTAS2_Time = new ArrayList<Double>();
		ArrayList<Double> FPTAS10_Time = new ArrayList<Double>();
		ArrayList<Double> greedy_2_approx_Time = new ArrayList<Double>();
		
		double knapSack_DP_Tot_time = 0;	
		double knapSack_DP_min_cost_Tot_time = 0;
		double FPTAS_Tot_time = 0;
		double FPTAS2_Tot_time = 0;
		double FPTAS10_Tot_time = 0;
		double greedy_2_approx_Tot_time = 0;
		
		//Get 100 knapsack instances.
		Knapsack[] instances = ReadKnapsackInstance();


		//Run testing of 100 instances with dynamic programming algorithm O(n*w)
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.knapSack_DP(instances[i]);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			knapsack_DP_Time.add(processTimeInS);
			knapSack_DP_Tot_time+=processTimeInS;
		}
		
		Collections.sort(knapsack_DP_Time);
		knapSack_DP_Min_time = knapsack_DP_Time.get(0);
		knapSack_DP_Max_time = knapsack_DP_Time.get(knapsack_DP_Time.size()-1);
		knapSack_DP_Avg_time = knapSack_DP_Tot_time/knapsack_DP_Time.size();
		int middle = knapsack_DP_Time.size()/2;
		if(knapsack_DP_Time.size()%2 == 1){
			knapSack_DP_Median_time = knapsack_DP_Time.get(middle);
		}else{
			knapSack_DP_Median_time = (knapsack_DP_Time.get(middle-1)+knapsack_DP_Time.get(middle))/2;
		}
		
		//Run testing of 100 instances with dynamic programming min cost algorithm O(n*n*v(amax))
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.knapSack_DP_min_cost(instances[i]);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			knapSack_DP_min_cost_Time.add(processTimeInS);
			knapSack_DP_min_cost_Tot_time+=processTimeInS;
		}
		
		Collections.sort(knapSack_DP_min_cost_Time);
		knapSack_DP_min_cost_Min_time = knapSack_DP_min_cost_Time.get(0);
		knapSack_DP_min_cost_Max_time = knapSack_DP_min_cost_Time.get(knapSack_DP_min_cost_Time.size()-1);
		knapSack_DP_min_cost_Avg_time = knapSack_DP_min_cost_Tot_time/knapSack_DP_min_cost_Time.size();
		int middle1 = knapSack_DP_min_cost_Time.size()/2;
		if(knapsack_DP_Time.size()%2 == 1){
			knapSack_DP_min_cost_Median_time = knapSack_DP_min_cost_Time.get(middle1);
		}else{
			knapSack_DP_min_cost_Median_time = (knapSack_DP_min_cost_Time.get(middle1-1)+knapSack_DP_min_cost_Time.get(middle1))/2;
		}
		
		//Run testing of 100 instances with FPTAS algorithm with 0.5 factor
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.FPTAS(instances[i], 0.5);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			FPTAS_Time.add(processTimeInS);
			FPTAS_Tot_time+=processTimeInS;
		}
		Collections.sort(FPTAS_Time);
		FPTAS_Min_time = FPTAS_Time.get(0);
		FPTAS_Max_time = FPTAS_Time.get(FPTAS_Time.size()-1);
		FPTAS_Avg_time = FPTAS_Tot_time/FPTAS_Time.size();
		int middle2 = FPTAS_Time.size()/2;
		if(FPTAS_Time.size()%2 == 1){
			FPTAS_Median_time = FPTAS_Time.get(middle2);
		}else{
			FPTAS_Median_time = (FPTAS_Time.get(middle2-1)+FPTAS_Time.get(middle2))/2;
		}
		
		
		//Run testing of 100 instances with FPTAS algorithm with 2 factor
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.FPTAS(instances[i], 2);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			FPTAS2_Time.add(processTimeInS);
			FPTAS2_Tot_time+=processTimeInS;
		}
		Collections.sort(FPTAS2_Time);
		FPTAS2_Min_time = FPTAS2_Time.get(0);
		FPTAS2_Max_time = FPTAS2_Time.get(FPTAS2_Time.size()-1);
		FPTAS2_Avg_time = FPTAS2_Tot_time/FPTAS2_Time.size();
		int middle4 = FPTAS2_Time.size()/2;
		if(FPTAS2_Time.size()%2 == 1){
			FPTAS2_Median_time = FPTAS2_Time.get(middle4);
		}else{
			FPTAS2_Median_time = (FPTAS2_Time.get(middle4-1)+FPTAS2_Time.get(middle4))/2;
		}
		
		
		//Run testing of 100 instances with FPTAS algorithm with 100 factor
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.FPTAS(instances[i], 100);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			FPTAS10_Time.add(processTimeInS);
			FPTAS10_Tot_time+=processTimeInS;
		}
		Collections.sort(FPTAS10_Time);
		FPTAS10_Min_time = FPTAS10_Time.get(0);
		FPTAS10_Max_time = FPTAS10_Time.get(FPTAS10_Time.size()-1);
		FPTAS10_Avg_time = FPTAS10_Tot_time/FPTAS10_Time.size();
		int middle5 = FPTAS10_Time.size()/2;
		if(FPTAS10_Time.size()%2 == 1){
			FPTAS10_Median_time = FPTAS10_Time.get(middle5);
		}else{
			FPTAS10_Median_time = (FPTAS10_Time.get(middle5-1)+FPTAS10_Time.get(middle5))/2;
		}
		
		//Run testing of 100 instances with greedy 2 approximation algorithm 
		for(int i = 0; i<instances.length; i++){
			long startTime = System.nanoTime();
			Knapsackrun.greedy_2_approx(instances[i]);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);		
			greedy_2_approx_Time.add(processTimeInS);
			greedy_2_approx_Tot_time+=processTimeInS;
		}
		Collections.sort(greedy_2_approx_Time);
		greedy_2_approx_Min_time = greedy_2_approx_Time.get(0);
		greedy_2_approx_Max_time = greedy_2_approx_Time.get(greedy_2_approx_Time.size()-1);
		greedy_2_approx_Avg_time = greedy_2_approx_Tot_time/greedy_2_approx_Time.size();
		int middle3 = greedy_2_approx_Time.size()/2;
		if(greedy_2_approx_Time.size()%2 == 1){
			greedy_2_approx_Median_time = greedy_2_approx_Time.get(middle3);
		}else{
			greedy_2_approx_Median_time = (greedy_2_approx_Time.get(middle3-1)+greedy_2_approx_Time.get(middle3))/2;
		}		
	}

	//Get the maximum, average, median and mininum run time with different 3SAT algorithms.
	public static void getThreeSatTimeStat() throws FileNotFoundException{
		ThreeSAT ThreeSATRun = new ThreeSAT();
		ArrayList<Double> DPLL_Time = new ArrayList<Double>();
		ArrayList<Double> GSAT_Time = new ArrayList<Double>();
		ArrayList<Double> ApproxMax3SAT_Time = new ArrayList<Double>();
		double DPLL_Time_Tot_time = 0;	
		double GSAT_Tot_time = 0;
		double ApproxMax3SAT_Tot_time = 0;
		
		//Get 100 3SAT instances.
		CNF[] instances = ReadThreeSatInstance();
	
		//Run testing of 100 instances with DPLL algorithm.
		for(int i = 0; i<instances.length; i++){
			ArrayList<Integer> truthAssignmentSoFar = new ArrayList<Integer>();
			CNF instanceCopy = new CNF(instances[i]);
			long startTime = System.nanoTime();
			ThreeSATRun.DPLL(instanceCopy, truthAssignmentSoFar);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);	
			DPLL_Time.add(processTimeInS);
			DPLL_Time_Tot_time+=processTimeInS;
		}
		Collections.sort(DPLL_Time);
		DPLL_Min_time = DPLL_Time.get(0);
		DPLL_Max_time  = DPLL_Time.get(DPLL_Time.size()-1);
		DPLL_Avg_time = DPLL_Time_Tot_time/DPLL_Time.size();
		int middle = DPLL_Time.size()/2;
		if(DPLL_Time.size()%2 == 1){
			DPLL_Median_time = DPLL_Time.get(middle);
		}else{
			DPLL_Median_time = (DPLL_Time.get(middle-1)+DPLL_Time.get(middle))/2;
		}
		
		//Run testing of 100 instances with GSAT algorithm.
		for(int i = 0; i<instances.length; i++){
			CNF instanceCopy = new CNF(instances[i]);
			long startTime = System.nanoTime();
			ThreeSATRun.GSAT(instanceCopy, 10, 10);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);	
			GSAT_Time.add(processTimeInS);
			GSAT_Tot_time+=processTimeInS;
		}
		Collections.sort(GSAT_Time);
		GSAT_Min_time = GSAT_Time.get(0);
		GSAT_Max_time  = GSAT_Time.get(GSAT_Time.size()-1);
		GSAT_Avg_time = GSAT_Tot_time/GSAT_Time.size();
		int middle1 = GSAT_Time.size()/2;
		if(GSAT_Time.size()%2 == 1){
			GSAT_Median_time = GSAT_Time.get(middle1);
		}else{
			GSAT_Median_time = (GSAT_Time.get(middle1-1)+GSAT_Time.get(middle1))/2;
		}
		
		//Run testing of 100 instances with greedy algorithm.
		for(int i = 0; i<instances.length; i++){
			CNF instanceCopy = new CNF(instances[i]);
			long startTime = System.nanoTime();
			ThreeSATRun.ApproxMax3SAT(instanceCopy);
			long endTime = System.nanoTime();
			long processTime = endTime - startTime;
			double processTimeInS = processTime / (double) Math.pow(10, 9);	
			ApproxMax3SAT_Time.add(processTimeInS);
			ApproxMax3SAT_Tot_time+=processTimeInS;
		}
		Collections.sort(ApproxMax3SAT_Time);
		ApproxMax3SAT_Min_time = ApproxMax3SAT_Time.get(0);
		ApproxMax3SAT_Max_time  = ApproxMax3SAT_Time.get(ApproxMax3SAT_Time.size()-1);
		ApproxMax3SAT_Avg_time = ApproxMax3SAT_Tot_time/ApproxMax3SAT_Time.size();
		int middle2 = ApproxMax3SAT_Time.size()/2;
		if(GSAT_Time.size()%2 == 1){
			ApproxMax3SAT_Median_time = ApproxMax3SAT_Time.get(middle2);
		}else{
			ApproxMax3SAT_Median_time = (ApproxMax3SAT_Time.get(middle2-1)+ApproxMax3SAT_Time.get(middle2))/2;
		}
		
	}
	
	//Read 100 random generate knapsack instances from file. 
	public static Knapsack[] ReadKnapsackInstance() throws FileNotFoundException{
		
		String fileName = "KnapsackInstances.txt";
		
		int budget;
		Knapsack[] instances1 = new Knapsack[100];
		Scanner filereader = new Scanner(new File(fileName));
		int instanceNum = 0;
		while(filereader.hasNextLine()){
			Item[] items = new Item[200];
			String InstanceName = filereader.nextLine();
			budget = Integer.parseInt(filereader.nextLine());
			for(int i = 0; i <200; i++){
				String item = filereader.nextLine();
				String[] oneItem = item.split(",");
				int value = Integer.parseInt(oneItem[0]);
				int cost = Integer.parseInt(oneItem[1]);
				items[i] = new Item(i,value,cost);
			}
			instances1[instanceNum] =  new Knapsack(items,budget);
			instanceNum++;
		}
		filereader.close();
		
		return instances1;

	}
	
	//Read 100 random generate 3SAT instances from file. 
	public static CNF[] ReadThreeSatInstance() throws FileNotFoundException{
		String fileName = "ThreeSatInstances.txt";
		Scanner filereader = new Scanner(new File(fileName));
		CNF[] instances = new CNF[100];
		int num = 0;
		
		while(filereader.hasNextLine()){
			ArrayList<Clause> clauses = new ArrayList<Clause>();	
			String InstanceName = filereader.nextLine();
			//System.out.println(budget);
			for(int i = 0; i <5; i++){
				ArrayList<Literals> literals = new ArrayList<Literals>();
				String item = filereader.nextLine();
				String[] oneItem = item.split(",");
				for(int j = 0; j<oneItem.length;j++){
					literals.add(new Literals(Integer.parseInt(oneItem[j])));
				}
				clauses.add(new Clause(literals));
			}
			instances[num] = new CNF(clauses);
			num++;
		}
		filereader.close();
		return instances;

	}
	

}
