package com.qa.opencart.pages;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter string");
		String s = sc.nextLine();
		//String s = "Karthick";
		int length = s.length();
		System.out.println("Reverse string");
		for(int i=length; i >0; --i) {
			
			
			System.out.print(s.charAt(i-1));
			
		}
		

	}

}
