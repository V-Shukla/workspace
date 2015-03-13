/**
 * 
 */
package Math;

import java.util.ArrayList;

/**
 * @author rus733
 *
 */
public class EularProblem12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long triangularNumber = 1;
		ArrayList<Long> divisor = new ArrayList<Long>();
		//factors.add(1l);
		
		//find triangular number
		for (long i = 2; i<2000; i++){
			triangularNumber+=i;
			divisor.add(triangularNumber);
			System.out.print(" i "+i+" triangularNumber "+triangularNumber);	
			//find factors
			long j=(triangularNumber/2)+1;
			while(j>0){
				if(triangularNumber%j == 0){
					divisor.add(j);
				}
				
				j--;
			}//end while loop
			//System.out.println(" i "+i+" factors length "+divisor.size());	
			System.out.println(" factors "+divisor+" factors length "+divisor.size());	
			divisor.clear();
			int length = divisor.size();
			if(length>=500){
				break;
			}
		}//end for loop
		
		
		for (int j = 0; j<20; j++){
			
		}
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" estimatedTime in milisec "+estimatedTime);
	}

}
