package bootCampPractice;

import static java.lang.System.out;

/**
 * @author RUS733
 *
 */
public class EncryptText {

	private static int[] outputEncrypts;//={0,0,0,0,0,0};
	static char[] alphabet1 = {'a','b','c','d','e','f'};
	static int[] encrypt1 = {71,67,87,48,52,23};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] alphabet1 = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,}
		
		String inputString = "abcfab";
		int stringLength1 = inputString.length();
		outputEncrypts = new int[stringLength1];
		//outputEncrypts = null;
		out.println("Entered Text = "+inputString);
		int[] optext = convert(inputString,stringLength1);
		
		out.print("Encrypeted Text = ");
		for (int i=0; i<stringLength1; i++){
		out.print(optext[i]);
		}// end i loop
	}//end main method
	
	public static int[] convert(String input1, int strln){
		//method body
		
		for (int i=0; i<strln; i++){
			outputEncrypts[i]=0;
			for (int j=0; j<strln; j++){ //total number of alphabets
				if (input1.charAt(i)==alphabet1[j]){
					outputEncrypts[i]=encrypt1[j];
					//out.print(input1.charAt(i));
					//out.print("=");
					//out.println(outputEncrypts[i]);
					break;
					
				}//end if
				else{
					//outputEncrypts[i]=99;
				}
				
				
				//out.println("end if"+"outputEncrypts[" + i +"] = "+outputEncrypts[i]+" , "+j);
			}//end j for loop
			//out.println("end j loop"+"outputEncrypts[" + i +"] = "+outputEncrypts[i]);
			//out.println("outputEncrypts[" + i +"] = "+outputEncrypts[i]);
		}//end i for loop
//		out.println("outputEncrypts[" + 0 +"] = "+outputEncrypts[0]);
//		out.println("outputEncrypts[" + 1 +"] = "+outputEncrypts[1]);
//		out.println("outputEncrypts[" + 2 +"] = "+outputEncrypts[2]);
//		out.println("outputEncrypts[" + 3 +"] = "+outputEncrypts[3]);
//		out.println("outputEncrypts[" + 4 +"] = "+outputEncrypts[4]);
//		out.println("outputEncrypts[" + 5 +"] = "+outputEncrypts[5]);
		return outputEncrypts;
		
	}//end method

}//end class
