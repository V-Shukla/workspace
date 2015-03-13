/**
 * 
 */
package bootCampPractice;

import java.util.HashMap;

/**
 * @author rus733
 *
 */
public class HashPRactice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] test1 = {1,1,2,3,2,2,4,4,1,0,0,2,3};
	int[] test2 = {'z',1,2,4,2,1,2,2,1,3,3,3};
	int[] test3 = {2,3,1,4,1,1,1,4,'Z'};
	
	sortData(test1);
	sortData(test2);
	sortData(test3);
	
	
	}//end main
	
	public static void sortData (int[] test){
		Integer x;
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int testLength = test.length;
		int addValue; 
		System.out.println("test length"+testLength);
		
		for (int i=0;i<testLength;i++){
			
			if (hashMap.get(test[i])==null){
				hashMap.put(test[i],0);
			}
			//addValue = (hashMap.get(test[i]))+1;
			//System.out.println("addValue"+addValue);
			hashMap.put(test[i],(hashMap.get(test[i]))+1);	
			//System.out.println("hashMap"+hashMap);
		}//end for loop for i
		System.out.println("hashMap"+hashMap);
	}//end of method sortData
	
}//end class
