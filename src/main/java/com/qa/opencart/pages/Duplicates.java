package com.qa.opencart.pages;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  String name = "cognizant";
	       
	        // Function call
	        removeDuplicates(name);

	}

	private static void removeDuplicates(String name) {
		// TODO Auto-generated method stub
		
		Set<Character> set= new HashSet<>();
		StringBuilder buf = new StringBuilder();
		char chars[] = name.toCharArray();
    // adding elements to LinkedHashSet
 for(char ch : chars) {
	 
    	if(set.add(ch))
    	{
    	buf.append(ch);
    	}
    	
    	}
 System.out.print(buf.toString());
	}

}
