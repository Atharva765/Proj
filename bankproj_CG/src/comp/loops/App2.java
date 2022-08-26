package comp.loops;

public class App2 {
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,5,6,7};
		
		/*
		 * Traditional For LOOP
		 */
		
		for(int i =0; i <arr.length ; i++) {
			System.out.println(arr[i] + " ");
			
		}
		
		System.out.println("\n **************\n");
//		reverse of array
		
		for(int i=arr.length-1; i>=0;i--) {
			System.out.println(arr[i] + " ");
		}
		
		
		/*
		 * For -each : cannot print reverse:
		 */
		
		System.out.println("\n **************\n");
		
		for(int temp : arr) {
			System.out.println(temp + " ");
		}
		
		/*
		 * break & continue
		 * break :  terminate the loop
		 * continue : goes to the loop statement again
		 */
		
		System.out.println("\n **************\n");
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]%2 == 0) {
				System.out.println(arr[i]+ " ");
				continue;
			}
			if(arr[i] == 5) {
				break;
			}
		}
		
		/*
		 * WHILE LOOP
		 */
		
		System.out.println("\n **************\n");
		int i=0;
		while(i<arr.length) {
			System.out.println(arr[i]+ " ");
			i++;
		}
		System.out.println("\n**************\n");
		
		//REVERSE USING WHILE
		
		int j=arr.length-1;
		while(j== 0) {
			System.out.println(arr[j]+ " ");
			j--;
		}
		
		
		
	}
}















