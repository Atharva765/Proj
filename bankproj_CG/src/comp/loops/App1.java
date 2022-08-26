package comp.loops;

public class App1 {
	public static void main(String[] args) {
		
		//Type 1 :
		int [][] arry = new int [2][3];
		System.out.println(arry); //memory location
		System.out.println(arry[0]); //memory location
		System.out.println(arry[1]); //memory location
		
		arry[0][0] = 4;
		//arry[0][1] ;
		arry[0][2] = 2;
		//arry[1][0] ;
		arry[1][1] = 1;
		//arry[1][2];
		
		for(int [] a : arry) {
			for(int temp : a) {
				System.out.println(temp + " ");
			}
		}
		
		System.out.println("\n******************\\n");
		
		
		//Type 2 : Variable size 
		
		int [][] arr = new int[2][];
		
		arr[0] = new int[] {1,2,3};
		arr[1] = new int[] {1,2};
		
		for(int[] a : arr) {
			for(int temp : a ) {
				System.out.println(temp + " ");

			}
		}
		
		//Type 3 : Anonymous
		
		int [][] arr1 = new int[][] {{1,2},{3,4},{5,6}};
		System.out.println(arr1[1][1]);   //4
		
		
		}		
}

