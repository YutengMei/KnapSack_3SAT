package ThreeSATProblem;

import java.util.ArrayList;

public class Clause {
	
	private ArrayList<Literals> literal = new ArrayList<Literals>();
	/**
	 * @param literals
	 */
	public Clause(ArrayList<Literals> literals) {
		this.literal = literals;
	}
	
	public Clause(Clause Clause){
		for(Literals i: Clause.literal){
			//System.out.println("Clause copy");
			this.literal.add(new Literals(i));
			
		}
	}
	/**
	 * @return the literals
	 */
	public ArrayList<Literals> getLiterals() {
		return literal;
	}
	
	public boolean containsInt(int  input){
		for(int i = 0 ; i < literal.size(); i++){
			if(literal.get(i).contains(input)){
				return true;
			}
		}
		return false;
		
	}
	
	public int getIdx (int input){
		for(int i = 0; i < literal.size(); i++){
			if(literal.get(i).getLiterals() == input){
				return i;
			}
		}
		return -1;
	}
	/**
	 * @param literals the literals to set
	 */
	public void setLiterals(ArrayList<Literals> literals) {
		this.literal = literals;
	}
	

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i<literal.size(); i++){
			result = result+ " "+ literal.get(i).getLiterals();
		}
		return result;
	}

	
}
