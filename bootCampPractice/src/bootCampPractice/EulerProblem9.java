package bootCampPractice;

import java.util.Scanner;

public class EulerProblem9 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int a = 1, b; 
		int sum = 999; 
		boolean found = false; 
		int calNum =0;
		for (int c = 999; c>0; c--){
			a=1;
			b=999;
			System.out.println("--------------------------------------------------------");
			System.out.println("--------------------------------------------------------");
			//found =true;
			while(a<b){
				b=1000-c-a;
				calNum++;
				if (((a*a+b*b)-(c*c))==0){
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					System.out.println("a*a ="+a*a+" b*b = "+b*b+" c*c = "+c*c);
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					found =true;
					break;
				}//end if statement
				System.out.println("a ="+a+" b = "+b+" c = "+c);
				System.out.println("a*a + b*b - c*c =  "+((a*a+b*b)-(c*c)));
				if (found==true){
					System.out.println("found is true, break ");
					break;
				}		
				a++;
			}//end while statement

			if (found==true){
				System.out.println("found is true, break ");
				System.out.println("a ="+a+" b = "+b+" c = "+c+" calNum = "+calNum);
				System.out.println("ans ="+a*b*c);
				
				break;
			}
			
			
//			Scanner keyboard = new Scanner(System.in);
//			System.out.println("enter an integer");
//			int myint = keyboard.nextInt();
		}//end for loop for c
	
	}//end main

}//end EulerProblem9 class
