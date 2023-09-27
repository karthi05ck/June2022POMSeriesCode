package com.qa.opencart.pages;

public class RotateArrayRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArrayRight rotate = new RotateArrayRight();
		int arr[]= {1,2,3,4,5,6};
		int n = arr.length;
		int d = 2; // no.of times
		rotate.rotateBy(arr,d,n);
		rotate.printArray(arr,n);

	}

	

	private  void rotateBy(int[] arr, int d, int n) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<d; i++)
			rightRotateByOne(arr,n);
		
	}

	private void rightRotateByOne(int[] arr, int n) {
		// TODO Auto-generated method stub
		//int arr[]= {1,2,3,4,5,6};
		int i,temp;
		temp=arr[n-1];
//		for(i=0; i<n-1; i++) {
//			arr[n-1+i] = arr[i];}
//		arr[i]=temp;
		for(i=n-1;i>0;i--)
			arr[i]=arr[i-1];
			arr[0]=temp;
	}
	
	private void printArray(int[] arr, int n) {
		// TODO Auto-generated method stub
		for(int i = 0; i<n;i++)
			System.out.print(arr[i] + " ");
		
	}

}
