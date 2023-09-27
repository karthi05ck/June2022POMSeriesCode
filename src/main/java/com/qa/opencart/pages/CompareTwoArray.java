package com.qa.opencart.pages;

public class CompareTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {20,30,40};
		int b[]= {20,30,40};
		boolean result = compare(a,b);
		if(result==true) System.out.println("Arrays are same");
		else System.out.println("Arrays are NOT same");
	

	}

	private static boolean compare(int[] a, int[] b) {
		
		if(a.length==b.length) {
			for(int i=0; i<a.length;i++) {
				if(a[i]!=b[i]){
					return false;
				}
			}
			
		}
		else {
			return false;
		}
		
		return true;
	}

}
