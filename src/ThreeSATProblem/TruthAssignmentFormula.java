package ThreeSATProblem;

import java.util.ArrayList;
/*
 * Class that hold return values of the unit propagation method. 
 */
public class TruthAssignmentFormula {
	
	CNF formula;
	ArrayList<Integer> truthAssignmentSoFar;
	
	public TruthAssignmentFormula() {

	}
	
	/**
	 * @param formula
	 * @param truthAssignmentSoFar
	 */
	public TruthAssignmentFormula(CNF formula, ArrayList<Integer> truthAssignmentSoFar) {
		
		this.formula = formula;
		this.truthAssignmentSoFar = truthAssignmentSoFar;
	}

	/**
	 * @return the formula
	 */
	public CNF getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(CNF formula) {
		this.formula = formula;
	}

	/**
	 * @return the truthAssignmentSoFar
	 */
	public ArrayList<Integer> getTruthAssignmentSoFar() {
		return truthAssignmentSoFar;
	}

	/**
	 * @param truthAssignmentSoFar the truthAssignmentSoFar to set
	 */
	public void setTruthAssignmentSoFar(ArrayList<Integer> truthAssignmentSoFar) {
		this.truthAssignmentSoFar = truthAssignmentSoFar;
	}
	
	
	@Override
	public String toString() {
		String result = "TruthAssignment: ";
		for (int i = 0; i<truthAssignmentSoFar.size(); i++){
			result = result+ truthAssignmentSoFar.get(i) + "  ";
		}
		return result;
	}
	
}
