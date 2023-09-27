package com.qa.opencart.pages;

public class DesignPatterns {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//patterndesign(5);
		pattern3(4);

	}

	private static void pattern1(int n) {
		for(int row = 1; row<=n; row++) {
			
			int noOfSpaces = n-row;
			for(int spaces=1; spaces<=noOfSpaces; spaces++ ) {
				System.out.print(" ");
				}
		
		for(int col = 1; col<=row; col++) {
			System.out.print("*");
		}
		System.out.println("");
		}
		
	}
	
	private static void pattern1reverse(int n) {
		for(int row = 1; row<=n; row++) {
			
			int noOfSpaces = row-1;
			for(int spaces=1; spaces<=noOfSpaces; spaces++ ) {
				System.out.print(" ");
				}
		
		for(int col = 1; col<=n; col++) {
			System.out.print("*");
		}
		System.out.println("");
		}
		
	}
	
	
	private static void pattern2(int n) {
		for(int row = 1; row<=2*n-1; row++) {
			int totalCols = row>n ?2*n-row : row;
			
			int noOfSpaces = row>n? row-n: n-row;
			for(int spaces=1; spaces<=noOfSpaces; spaces++ ) {
				System.out.print(" ");
				}
		
		for(int col = 1; col<=totalCols; col++) {
			System.out.print("*");
			
		}
//		for(int spaces=1; spaces<=noOfSpaces; spaces++ ) {
//			System.out.print(" ");
//			}
		System.out.println("");
		}
		
	}
	//O/p pattern 2
//		 *
//	    **
//	   ***
//	  ****
//	 *****
//	******
//	 *****
//	  ****
//	   ***
//	    **
//	 	 *

	
	private static void pattern3(int n) {
		for(int row = 1; row<=n; row++) {
			
			for(int spaces=1; spaces<=n-row; spaces++) {
				System.out.print(" ");
			}
			for(int col=1; col<=(2*row)-1;col++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
			
			
}
	static void patterndesign(int n) {
		for(int row=1; row<=2*n-1; row++) {
			int noOfSpaces= row>n ? 2*n-row-1 :row-1;
			int totalCols = row>n ?row-n+1 : n-row+1;
			for(int spaces=1; spaces<=noOfSpaces; spaces++) {
				System.out.print(" ");
			}
			for(int col=1; col<=totalCols; col++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	
	
	
}
