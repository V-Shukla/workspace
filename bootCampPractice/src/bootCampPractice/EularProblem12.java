/**
 * 
 */
package bootCampPractice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rus733
 *
 */
public class EularProblem12 {

	private static long previousMaxPrime=3;
	private static ArrayList<Long> primeNumbers= new ArrayList<>();
	private static ArrayList<Long> divisiblePrimesFromMethod;

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeNumbers.add(0, 3l);
		primeNumbers.add(0, 2l);
		
		divisiblePrimesFromMethod = new ArrayList<Long>();
		//HashMap<Integer, Integer> primeFactors = new HashMap<>();
		long triangularNumber = 0;
		int factorNumber;
		//create triangular number
		
		for (long i = 1l; i<20000; i++){
			triangularNumber +=i;
			System.out.print(" i "+i);
			System.out.print(" triangularNumber "+triangularNumber);
			divisiblePrimesFromMethod=divisiblePrimes(triangularNumber, previousMaxPrime);
			factorNumber=findPrimeFactors(divisiblePrimesFromMethod, triangularNumber);
			
			if (factorNumber>500){
				System.out.println(" triangularNumber with over 500 factors is "+triangularNumber);
				break;
			}
			
			//divisiblePrimesFromMethod.clear();
		}//end for loop for triangular number
	
		
		//divisiblePrimesFromMethod=divisiblePrimes(40);
		//System.out.println(" divisiblePrimesFromMethod "+divisiblePrimesFromMethod);
	} // end of main
	
	//this method finds each prime number under the given number
	public static ArrayList<Long> divisiblePrimes (long Number, long maxPrime){
		long num=Number/2+1;
		//long sum=2; 
		//ArrayList<Long> primeNumbers= new ArrayList<>();
//		primeNumbers.add(0, 2l);
		boolean isPrime = true; 
		
		
		for (long i = previousMaxPrime+2; i<num; i+=2){
			isPrime = true; 
			//System.out.println(" i "+i);
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
				
				
				
				if (i>previousMaxPrime){
					primeNumbers.add(i);
					previousMaxPrime=i;
				}
				
				//System.out.println(" previousMaxPrime "+previousMaxPrime);
				//sum+=i;
				//System.out.println("i ="+i+" primeNumbers "+primeNumbers+" sum "+sum);		
				//System.out.println(" i "+i+" sum "+sum);	
			}
				
		}// end for i loop
		//System.out.println(" primeNumbers "+primeNumbers);
		//System.out.println(" sum "+sum);	
	return primeNumbers;
		
	}//end of IsPrime method 
	
	
    public static int findPrimeFactors(ArrayList<Long> primeNumber, Long x) {
    	ArrayList<Long> primeFactors= new ArrayList<>();
    	int powerFactorMultiplier =1;
    	int numberOfFactors = 1;
    	//double x = 600851475143d; 
    	//System.out.println("Triangular number "+x);
    	for (Long z : primeNumber) {
    		powerFactorMultiplier =1;
    		if (x%z == 0) {
    			while( x%z == 0){
    				primeFactors.add(z);
    				x = x/z;
    				powerFactorMultiplier++;
    				//System.out.println(z + "PRIME FACTOR");
    			}//end while
    			//System.out.println("numberOfFactors "+numberOfFactors+ " powerFactorMultiplier "+powerFactorMultiplier);
    			numberOfFactors *= powerFactorMultiplier;
    		}//end if
    	}// end for loop
    	System.out.println(" *** Total numberOfFactors "+numberOfFactors);
    	//System.out.println("PrimeFactors " +primeFactors);
    	return numberOfFactors;
    }//end of findPrimeFactors
	

}// end of class
