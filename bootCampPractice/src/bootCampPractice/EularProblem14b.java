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
public class EularProblem14b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Long> holdAllNumbers = new ArrayList<Long>();
		long startTime = System.currentTimeMillis();
		long maxNum = 20;
		long number = 1;
		long terms = 1;
		long maxTerm = 0;
		long Seednumber = 0;
		//long i=0;
		long powerOf2Terms = 1;


		//HashMap<Long, Long> hashMap = new HashMap<>();
		HashMap <Long, Boolean> hashDontExecute = new HashMap<>();
		HashMap <Long, Long> hashMultipleOf2 = new HashMap<>();


		for (long j=maxNum; j>0; j--){
			holdAllNumbers.add(j);
					System.out.print("j = "+j);
		}
		System.out.println("holdAllNumbers = "+holdAllNumbers);
		holdAllNumbers.remove(19);
		
		for (long i : holdAllNumbers){

			terms = 1;

			number=i;
			System.out.print("Series = "+number);

				while (number!=1){
					
					if (number%2==0){

						number/=2;

					}else{

						number = 3*number+1;

					}
					System.out.print(" -> "+number);
					terms++;
				}//end while loop
				System.out.println(" terms "+terms);
				//			if (hashMap.get(i)==null){
				//				hashMap.put(i,terms);
				//				System.out.println(" Add number to hashmap "+hashMap);
				//			}

				if (terms > maxTerm){
					maxTerm = terms;
					Seednumber = i;
					//System.out.println("*****Seed number = "+i+" terms "+terms+" *****");
				}
			
		}//end for loop
		System.out.println("*****Starting Number = "+Seednumber+" maxTerm "+maxTerm+" *****");

		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" estimatedTime in milisec "+estimatedTime);

	}//end main

}//end class
