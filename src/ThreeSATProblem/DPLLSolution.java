package ThreeSATProblem;

import java.util.ArrayList;

public class DPLLSolution {
	
	
	
	private boolean SATISFIABLE;
	private ArrayList<Integer> truthAssignmentSoFar;
	
	public DPLLSolution() {

	}
	
	/**
	 * @param sATISFIABLE
	 * @param truthAssignmentSoFar
	 */
	public DPLLSolution(boolean SATISFIABLE, ArrayList<Integer> truthAssignmentSoFar) {
		this.SATISFIABLE = SATISFIABLE;
		this.truthAssignmentSoFar = truthAssignmentSoFar;
	}
	
	public DPLLSolution(boolean SATISFIABLE) {
		this.SATISFIABLE = SATISFIABLE;
		this.truthAssignmentSoFar = new ArrayList();
	}


	/**
	 * @return the sATISFIABLE
	 */
	public boolean isSATISFIABLE() {
		return SATISFIABLE;
	}

	/**
	 * @param sATISFIABLE the sATISFIABLE to set
	 */
	public void setSATISFIABLE(boolean sATISFIABLE) {
		SATISFIABLE = sATISFIABLE;
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
		String result = "SATISFIABLE = ";
		result = result + this.SATISFIABLE + " TruthAssignment:";
		for (int i = 0 ; i < truthAssignmentSoFar.size(); i++){
			result = result + " "+ truthAssignmentSoFar.get(i);
		}
		return result;
		
	}
	
	
	
}
