package com.assign3;
import java.util.*;
import java.util.concurrent.*;
class ArrayListOps {

   public ArrayList<Integer>  makeArrayListInt(int n){
	   
	   /*given no. of elements i have to generate a list and 			return it.
	   if n == 4 , i will return [0,0,0,0]
	   if n==7 , i will return [0,0,0,0,0,0,0]
	   */
		ArrayList<Integer> list = new ArrayList<>();
		
		while(n>0){ // if n=4,3,2,1
			list.add(0); // [0,0,0,0] 
			n--;   //n=3,2,1,0
		}

	   return list;
   }

   public ArrayList<Integer> reverseList(ArrayList<Integer> list){

	   Collections.reverse(list);
	   return list;
   
   }

   public ArrayList<Integer> changeList(ArrayList<Integer> list, int m, int n){

	   Collections.replaceAll(list,m,n);
	   return list;

   }

}
public class Source{
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 25, 	33, 28, 10, 12));
		ArrayListOps arr = new ArrayListOps();
		System.out.println(arr.makeArrayListInt(4));

		System.out.println(arr.reverseList(list));
		
		System.out.println(arr.changeList(list,28,20));

		

	}
}