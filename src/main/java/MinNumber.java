import java.util.Arrays;

public class MinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {5,4,8,44,1,-2};
		minimum1(arr);
		minimum2(arr);
	}

	private static void minimum2(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		System.out.println(arr[0]);
		System.out.println(arr[arr.length-1]);
		System.out.println(arr);
		
		
		
	}

	private static void minimum1(int[] arr) {
		// TODO Auto-generated method stub
		int n=arr.length;
		int min=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<min)
				min=arr[i];
			
		}
		System.out.println("The min num is "+min);
	}
	

}
