package ThreeSATProblem;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CNF {
	
	private ArrayList<Clause> clauses = new ArrayList<Clause>();
	
	//private int numOfVar;
	
	public CNF() {

	}
	
	public CNF(CNF otherFormula){
		for(int i = 0 ; i< otherFormula.getClauses().size(); i++){
			Clause newC = otherFormula.getClauses().get(i);
			//System.out.println("CNF copy");
			clauses.add(new Clause(newC));
			//System.out.println("CNF copy");
		}
		
	}
	


	/**
	 * @param clauses
	 * @param numOfVar
	 */
	public CNF(ArrayList<Clause> clauses) {
		this.clauses = clauses;
		//this.numOfVar = numOfVar;
	}

	public void replaceClause(int xi){
		
		for(int i = 0 ; i < clauses.size() ; i++){
			if(clauses.get(i).getLiterals().size() == 1 && clauses.get(i).getLiterals().get(0).getLiterals() == xi){
				clauses.get(i).getLiterals().set(0, new Literals(-xi));
			}
		}
		
	}
	public boolean hasUnitClause(){
		
		for(int i = 0; i< this.clauses.size();i++){
			if (clauses.get(i).getLiterals().size()==1){
				return true;
			}
		}
		return false;
		
	}
	
	public Clause getUnitClause(){
		
		for(int i = 0; i< this.clauses.size();i++){
			if (clauses.get(i).getLiterals().size()==1){
				return clauses.get(i);
			}
		}
		
		return null;
		
	}
	
	public void removeClauses(int xj){
		Predicate<Clause> predicate = p -> p.containsInt(xj);
		clauses.removeIf(predicate);
	}
	
	public void removeLiterals(int xj){
		
		for(int i = 0 ; i< clauses.size(); i++){
			if (clauses.get(i).containsInt(xj)){
				clauses.get(i).getLiterals().remove(clauses.get(i).getIdx(xj));
			}
		}
	}
	
	public boolean containsEmptyClause(){
		
		for (int i =  0 ; i<clauses.size(); i++){
			if(clauses.get(i).getLiterals().isEmpty()){
				return true;
			}
		}
		return false;
	}
	
//	public int getNumOfVar() {
//		return numOfVar;
//	}
//
//	public void setNumOfVar(int numOfVar) {
//		this.numOfVar = numOfVar;
//	}

	public ArrayList<Clause> getClauses() {
		return clauses;
	}

	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
	
	
	
	public void addClauses(int xj){
		//System.out.println("Enter addClauses fucntion: ");
		ArrayList<Literals> literals = new ArrayList();
		literals.add(new Literals(xj));
		//System.out.println("number to cluase: " + literals.toString());
		Clause newClause= new Clause(literals);
		//System.out.println("new cluase: " + newClause.toString());
		clauses.add(0, newClause);
		//System.out.println(this.clauses.toString());
	}
	
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < clauses.size(); i++){
			str += clauses.get(i).toString() + "\n";
		}
		return str;
	}






}
