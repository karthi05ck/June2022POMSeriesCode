package com.qa.opencart.pages;

import java.util.Arrays;

public class MissedNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {-1, -2};
		int n = arr.length;
		smallNumber(arr,n);

	}

	private static void smallNumber(int[] arr, int n) {
		// TODO Auto-generated method stub
		 Arrays.sort(arr);
		 System.out.print("The sorted array is :");
		for(int i=0; i<n; i++) {
			
			System.out.print( arr[i] + " ");
		}
		System.out.println();
		System.out.println("The modified aray printed directly" +Arrays.toString(arr));
		int min = 1;
		for(int i=0; i<n; i++) {
		if(arr[i] == min){
			min++;
		}
	}
		System.out.println("The small number is"+ min);
		
}

	
}
