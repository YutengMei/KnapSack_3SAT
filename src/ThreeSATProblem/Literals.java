package ThreeSATProblem;

public class Literals {
	private int literals;
	
	public Literals(){
		
	}
	
	public Literals(Literals source){
		literals = source.literals;
	}
	
	public Literals(int i){
		this.literals = i;
	}

	/**
	 * @return the literals
	 */
	public int getLiterals() {
		return literals;
	}

	/**
	 * @param literals the literals to set
	 */
	public void setLiterals(int literals) {
		this.literals = literals;
	}

	public boolean contains(int l) {
		// TODO Auto-generated method stub
		if(this.literals == l){
			return true;
		}
		return false;
	}
	

	
	
}
