package com.qa.opencart.pages;

public class CopyArray {

	int a[]= {20,30,40};
	int b[];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyArray cp = new CopyArray();
		cp.way1();
		cp.way2();
	}


	private void way2() {
		b= a.clone();
		System.out.print( " The cloned b is");
		for (int i=0; i<b.length; i++) {
			System.out.print( b[i]+ " ");
		}
		
	}


	private void way1() {
		b = new int[a.length];
		for (int i=0; i<a.length; i++) {
			b[i]=a[i];
			System.out.print( b[i]+ " ");
		}
		
	}

}
