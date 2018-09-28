package ThreeSATProblem;

import java.util.*;
import java.util.function.Predicate;

/*
 * Class that implement DPLL, GSAT and 7/8 approximation algorithms for solving 3SAT problems.
 */
public class ThreeSAT {

	
	public ThreeSAT() {
			
	}

	//DPLL algorithm.
	public static DPLLSolution DPLL(CNF formulaSoFar, ArrayList<Integer> truthAssignmentSoFar){
		//Get all literals in the formula.
		ArrayList<Integer> variables = new ArrayList();		
		for(int i = 0; i<formulaSoFar.getClauses().size(); i++){
			for(int j = 0; j<formulaSoFar.getClauses().get(i).getLiterals().size();j++){
				if(!variables.contains(Math.abs(formulaSoFar.getClauses().get(i).getLiterals().get(j).getLiterals()))){
					variables.add(Math.abs(formulaSoFar.getClauses().get(i).getLiterals().get(j).getLiterals()));
				}
			}
		}
		DPLLSolution solution = DPLL_helper(formulaSoFar,truthAssignmentSoFar,variables);
		return solution;

	}
	
	//Helper function of DPLL algorithm
	public static DPLLSolution DPLL_helper(CNF formulaSoFar, ArrayList<Integer> truthAssignmentSoFar, ArrayList<Integer> variables){
		DPLLSolution result = new DPLLSolution();	
		CNF newFormula = UnitPropagation(formulaSoFar,truthAssignmentSoFar).getFormula();
		ArrayList<Integer> newAssignment = UnitPropagation(formulaSoFar,truthAssignmentSoFar).getTruthAssignmentSoFar();

		//check newFormula is empty
		if(newFormula.getClauses().isEmpty()){
			return new DPLLSolution(true, newAssignment);
			
		}		
		//check newFormula contains an empty clause
		if(newFormula.containsEmptyClause()){
			return new DPLLSolution(false);
		}
		
		int xi = 0;
		//Let xi be the first variable that is not assigned in the newAssignment.
		for(int i = 0 ; i < variables.size(); i++){
			int num = variables.get(i);
			if(!newAssignment.contains(num)&&!newAssignment.contains(-num)){
				xi = variables.get(i);
				break;
			}
		}
		newFormula.addClauses(xi);
		CNF formula2 = new CNF(newFormula);

		newAssignment.add(xi);
		ArrayList<Integer> Assignment = new ArrayList<>();
		for(int i = 0;i<newAssignment.size(); i++){
			Assignment.add(newAssignment.get(i));
		}

		result = DPLL_helper(newFormula, newAssignment, variables);
		
		if(result.isSATISFIABLE()){
			return new DPLLSolution(true,newAssignment);
		}
		else{
			formula2.replaceClause(xi);
			for(int i = 0; i < Assignment.size(); i++){
				if(Assignment.get(i) == xi){
					Assignment.set(i, -xi);
				}
			}
			
			return DPLL_helper(formula2, Assignment, variables);
		}
		
	}
	
	//Unit propagation algorithm.
	public static TruthAssignmentFormula UnitPropagation(CNF formula, ArrayList<Integer> truthAssignmentSoFar){
		while (formula.hasUnitClause() && formula.getClauses().size() != 0){
			int xj = formula.getUnitClause().getLiterals().get(0).getLiterals();		
			if(xj > 0){
				if(!truthAssignmentSoFar.contains(xj)){
					truthAssignmentSoFar.add(xj);
				}
				//Remove every clause that contains xj from formula
				formula.removeClauses(xj);
				//Remove xj' from every clauses in formula containing xj'
				formula.removeLiterals(-xj);		
			}
			else{
				if(!truthAssignmentSoFar.contains(xj)){
					truthAssignmentSoFar.add(xj);
				}
				formula.removeClauses(xj);
				formula.removeLiterals(-xj);
			}
		}

		return new TruthAssignmentFormula(formula, truthAssignmentSoFar);
		
	}
	
	// 7/8 Aprroximation algorithm
	public static ArrayList<Integer> ApproxMax3SAT(CNF formula){
		//Get all the literals in formula
		ArrayList<Integer> variables = new ArrayList();		
		for(int i = 0; i<formula.getClauses().size(); i++){
			for(int j = 0; j<formula.getClauses().get(i).getLiterals().size();j++){
				if(!variables.contains(Math.abs(formula.getClauses().get(i).getLiterals().get(j).getLiterals()))){
					variables.add(Math.abs(formula.getClauses().get(i).getLiterals().get(j).getLiterals()));
				}
			}
		}
		Random randomGenerator = new Random();
		ArrayList<Integer> truthAssignment = new ArrayList<>();
		for(int i = 0; i<variables.size(); i++){
			boolean randomBool = randomGenerator.nextBoolean();
			if(randomBool){
				truthAssignment.add(variables.get(i));
			}
			else{
				truthAssignment.add(-variables.get(i));
			}
		}
		
		return truthAssignment;
		
	}
	
	//GSAT algorithm
	public static ArrayList<Integer> GSAT(CNF formula, int Maxtries, int Maxflips){
		//Get all the literals in formula
		ArrayList<Integer> variables = new ArrayList();		
		for(int i = 0; i<formula.getClauses().size(); i++){
			for(int j = 0; j<formula.getClauses().get(i).getLiterals().size();j++){
				if(!variables.contains(Math.abs(formula.getClauses().get(i).getLiterals().get(j).getLiterals()))){
					variables.add(Math.abs(formula.getClauses().get(i).getLiterals().get(j).getLiterals()));
				}
			}
		}
		
		
		Random randomGenerator = new Random();
		ArrayList<Integer> currentMaxT  = new ArrayList<>();
		int maxNum = 0;
		
		for(int i = 0; i < Maxtries; i++){
			
			// Generate random truth assignments.
			ArrayList<Integer> truthAssignment = new ArrayList<>();
			for(int j = 0; j < variables.size(); j++){
				boolean randomBool = randomGenerator.nextBoolean();
				if(randomBool){
					truthAssignment.add(variables.get(j));
				}
				else{
					truthAssignment.add(-variables.get(j));
				}
			}

			//Flipping variables in the current truth assignments.
			for(int k = 0; k < Maxflips; k++){
				int p = flip(formula,truthAssignment)[1];
				//System.out.println("max SC var: " + p);
				int numC = flip(formula,truthAssignment)[0];
				//System.out.println("num SC: " + numC);
				if(truthAssignment.contains(p)){
					truthAssignment.set(truthAssignment.indexOf(p), -p);
				}
				else{
					truthAssignment.set(truthAssignment.indexOf(-p), p);
				}
				
				if(numC == formula.getClauses().size()){
					return truthAssignment;
				}
				else{
					if(numC > maxNum){
						maxNum = numC;
						for(int z = 0; z<truthAssignment.size();z++){
							currentMaxT.add(truthAssignment.get(z));
						}
					}
				}
				
			}

		}
		return currentMaxT;
	}
	
	//Helper function of GSAT
	public static int [] flip(CNF formula, ArrayList<Integer> truthAssignment ){
		int numofClause = 0;
		ArrayList <Integer> candidates = new ArrayList<>();
		for(int i =0; i < truthAssignment.size(); i++){
			truthAssignment.set(i, -truthAssignment.get(i));
			if(getNumSC(formula,truthAssignment)>numofClause){
				numofClause = getNumSC(formula,truthAssignment);
			}
			truthAssignment.set(i, -truthAssignment.get(i));
		}
		//System.out.print("maxClause:" + numofClause);
	
		for(int i = 0; i < truthAssignment.size(); i++){
			//System.out.println("variable before: "+truthAssignment.get(i));
			truthAssignment.set(i, -truthAssignment.get(i));
			if(getNumSC(formula,truthAssignment)==numofClause){
				candidates.add(Math.abs(truthAssignment.get(i)));
			}
			truthAssignment.set(i, -truthAssignment.get(i));
			//System.out.println("variable after: "+truthAssignment.get(i));
		}
		

		int r = (int) (Math.random() * (candidates.size() - 0)) + 0;
		//System.out.println(r);
		int result[] = new int[2];
		result[0] = numofClause;
		result[1] = candidates.get(r);
		return result;
		
	}
	
	//Helper function of GSAT
	public static int getNumSC(CNF formula, ArrayList<Integer> truthAssignment){
		int numSC = formula.getClauses().size();
		CNF currentFormula = new CNF(formula);
		for(int i = 0; i < truthAssignment.size() ; i++){
			for(int j = 0; j<currentFormula.getClauses().size(); j++){
				if(currentFormula.getClauses().get(j).containsInt(truthAssignment.get(i))){
					currentFormula.removeClauses(truthAssignment.get(i));
				}
				
			}
		}
		return numSC - currentFormula.getClauses().size();
	}

	
	
//	public static void main(String... args) throws CloneNotSupportedException {
//		ArrayList<Literals> a1 = new ArrayList();
//		a1.add(new Literals(1));a1.add(new Literals(2));a1.add(new Literals(3));
//		ArrayList<Literals> a2 = new ArrayList();
//		a2.add(new Literals(1));a2.add(new Literals(2));a2.add(new Literals(-3));
//		ArrayList<Literals> a3 = new ArrayList();
//		a3.add(new Literals(1));a3.add(new Literals(-2));a3.add(new Literals(3));
//		ArrayList<Literals> a4 = new ArrayList();
//		a4.add(new Literals(1));a4.add(new Literals(-2));a4.add(new Literals(-3));
//		ArrayList<Literals> a5 = new ArrayList();
//		a5.add(new Literals(-1));a5.add(new Literals(2));a5.add(new Literals(3));
//		ArrayList<Literals> a6 = new ArrayList();
//		a6.add(new Literals(-1));a6.add(new Literals(2));a6.add(new Literals(-3));
//		ArrayList<Literals> a7 = new ArrayList();
//		a7.add(new Literals(-1));a7.add(new Literals(-2));a7.add(new Literals(3));
//		ArrayList<Literals> a8 = new ArrayList();
//		a8.add(new Literals(-1));a8.add(new Literals(-2));a8.add(new Literals(-3));
//		Clause clauses1 = new Clause(a1);
//		Clause clauses2 = new Clause(a2);
//		Clause clauses3 = new Clause(a3);
//		Clause clauses4 = new Clause(a4);
//		Clause clauses5 = new Clause(a5);
//		Clause clauses6 = new Clause(a6);
//		Clause clauses7 = new Clause(a7);
//		Clause clauses8 = new Clause(a8);
//		ArrayList<Clause> list1 = new ArrayList<>();
//		list1.add(clauses1);list1.add(clauses2);list1.add(clauses3);list1.add(clauses4);
//		list1.add(clauses5);list1.add(clauses6);list1.add(clauses7);list1.add(clauses8);
//
//		CNF formula = new CNF(list1);
//		//System.out.println(formula.toString());
//		//formula.replaceClause(1);
//		//System.out.println(GSAT(formula,10,10).toString());
//		//System.out.println(formula.toString());
//		
//		//System.out.println(cost(formula, -1));
//
//		ArrayList<Integer> truthAssignmentSoFar = new ArrayList();
//		//System.out.println("UnitPropagation: " + UnitPropagation(formula, truthAssignmentSoFar).toString());
//		//System.out.println(UnitPropagation(formula, truthAssignmentSoFar).getFormula().toString());
//		
//		//System.out.println(DPLL(formula, truthAssignmentSoFar).toString());
//		
//		
//		ArrayList<Clause> l2 = new ArrayList<>();
//		ArrayList<Literals> b1 = new ArrayList();
//		b1.add(new Literals(4));b1.add(new Literals(2));b1.add(new Literals(5));
//		ArrayList<Literals> b2 = new ArrayList();
//		b2.add(new Literals(-1));b2.add(new Literals(5));b2.add(new Literals(-4));
//		ArrayList<Literals> b3 = new ArrayList();
//		b3.add(new Literals(-2));b3.add(new Literals(-5));b3.add(new Literals(-4));
//		ArrayList<Literals> b4 = new ArrayList();
//		b4.add(new Literals(4));b4.add(new Literals(-2));b4.add(new Literals(1));
//		ArrayList<Literals> b5 = new ArrayList();
//		b5.add(new Literals(4));b5.add(new Literals(5));b5.add(new Literals(2));
//		
//		Clause c = new Clause(b1);
//		Clause c1 = new Clause(b2);
//		Clause c2 = new Clause(b3);
//		Clause c3 = new Clause(b4);
//		Clause c4 = new Clause(b5);
//		l2.add(c);l2.add(c1);l2.add(c2);l2.add(c3);l2.add(c4);
////		ArrayList<Integer> t1 = new ArrayList();
////		t1.add(-1);t1.add(-2);t1.add(3);
//		CNF formula3 = new CNF(l2);
//		//truthAssignmentSoFar.add(-1);truthAssignmentSoFar.add(2);truthAssignmentSoFar.add(3);truthAssignmentSoFar.add(4);truthAssignmentSoFar.add(-5);
//		DPLL(formula,truthAssignmentSoFar);
//		//System.out.println(UnitPropagation(formula,truthAssignmentSoFar).getFormula().toString());
//		//System.out.println(getNumSC(formula3,t1));
//		//ArrayList<Integer> can = new ArrayList();
//		//can = flip(formula3,t1);
//		//System.out.println("Index: "+flip(formula3,t1));
//		//System.out.print(GSAT(formula3,10,10).toString());
//		
//	}
	

}


