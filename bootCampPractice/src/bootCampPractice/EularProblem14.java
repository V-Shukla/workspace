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
public class EularProblem14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long maxNum = 20;
		long number = 1;
		long terms = 1;
		long maxTerm = 0;
		long Seednumber = 0;
		long i=0;
		long powerOf2Terms = 1;
		ArrayList<Long> divisiblePrimesFromMethod;
		
		//HashMap<Long, Long> hashMap = new HashMap<>();
		HashMap <Long, Boolean> hashDontExecute = new HashMap<>();
		HashMap <Long, Long> hashMultipleOf2 = new HashMap<>();
		
		
		for (long j=1; powerOf2Terms<maxNum; j++){
			powerOf2Terms=powerOf2Terms*2;
			hashMultipleOf2.put(powerOf2Terms, j+1);
		}
		System.out.print(" hashMultipleOf2 "+hashMultipleOf2);
		
		for (i=1; i<maxNum; i++){
			
			terms = 1;
			
			number=i;
			System.out.print("Series = "+number);
			
			if(hashDontExecute.get(i)!=null && hashDontExecute.get(i)==true){
				System.out.println(" Already been part of series "+i);
				System.out.print(" hashDontExecute "+hashDontExecute);
				
			}else{
			
			while (number!=1){
				
		
				
				if (number%2==0){
					
					if (hashMultipleOf2.get(number)!=null){
						terms = terms+hashMultipleOf2.get(number)-1;
						//hashMap.put(number,terms);
						//hashMap.remove(number); 
						System.out.print(" Break : ");
						System.out.print(" Power Multiple of 2 found "+ number);
						
						break;
					}
					if (number<maxNum){
					hashDontExecute.put(number, true);
					}
					number/=2;
					
				}else{
					
					if (number<maxNum){
					hashDontExecute.put(number, true);
					}
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
				//System.out.println("*****Seednumber = "+i+" terms "+terms+" *****");
			}
			}//end else
		}//end for loop
		System.out.println("*****Starting Number = "+Seednumber+" maxTerm "+maxTerm+" *****");
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" estimatedTime in milisec "+estimatedTime);
	}//end Main

}//end class
