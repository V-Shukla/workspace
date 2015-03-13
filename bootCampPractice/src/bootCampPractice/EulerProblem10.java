/**
 * 
 */
package bootCampPractice;

import java.util.ArrayList;

/**
 * @author rus733
 *
 */
public class EulerProblem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long num=2000000;
		long sum=2; 
		ArrayList<Long> primeNumbers= new ArrayList<>();
		//primeNumbers.add(0, 2l);
		boolean isPrime = true; 
		
		for (long i = 3l; i<num; i+=2){
			isPrime = true; 
			for (long eachPrime : primeNumbers){
				 if (eachPrime > Math.sqrt(i)) {
		                break;
		            }
								
				if (i%eachPrime==0){
					isPrime = false; 
					break;
				}
				
			}//end for each prime loop
			
			if (isPrime == true){
				primeNumbers.add(i);
				sum+=i;
				//System.out.println("i ="+i+" primeNumbers "+primeNumbers+" sum "+sum);		
				//System.out.println(" i "+i+" sum "+sum);	
			}
				
		}// end for loop
		System.out.println(" primeNumbers "+primeNumbers+" sum "+sum);
		//System.out.println(" sum "+sum);	
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" estimatedTime in milisec "+estimatedTime);

	}//end main

}//end class
