package ThreeSATProblem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Class that generate 100 random 3SAT instances into a txt file.
 */
public class Generate3SATInstances {

	public static void main(String[] args) throws IOException {
		String fileName = "ThreeSatInstances.txt";
		int numOfLiterals = 10;
		int numOfClauses = 5;
		FileWriter file = new FileWriter(new File(fileName));
		for(int z = 1; z<101; z++){
			
			file.write("Instance"+" "+z);
			for(int i = 1; i<numOfClauses+1; i++){
				int[] literalsList = new int[3];
				literalsList[0] =(int)Math.floor(Math.random()*numOfLiterals+1) ;
				literalsList[1] = (int)Math.floor(Math.random()*numOfLiterals+1) ;
				while(literalsList[0] == literalsList[1]){
					literalsList[1] = (int)Math.floor(Math.random()*numOfLiterals+1) ;
				}
				literalsList[2] = (int)Math.floor(Math.random()*numOfLiterals+1) ;
				while(literalsList[2]==literalsList[0] || literalsList[2]==literalsList[1]){
					literalsList[2] = (int)Math.floor(Math.random()*numOfLiterals+1) ;
				}
				
				for(int j=0; j<3; j++){
					double rd = Math.random();
					if(rd >0.5){
						literalsList[j]=literalsList[j]*-1;
					}
				}
				file.write("\n" + literalsList[0] + "," + literalsList[1] + "," + literalsList[2]);
			}
			file.write("\n");
		}
	
		file.close();
	}

}
