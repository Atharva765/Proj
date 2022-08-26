package collectionsframework;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo1 {
	public static void main(String[] args) {
		
		Queue<String> queue =  new PriorityQueue<>();
		queue.add("lmn");
		queue.add("abc");
		queue.add("pqr");
		
		System.out.println(queue);  //abc lmn pqr
		System.out.println("PEEK ---first element of the queue------------");
		System.out.println(queue.peek());
		System.out.println("POLL ---print and remove first element of the queue------------");
		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println("REMOVE AN ELEMENT FROM QUEUE");
		queue.remove("lmn");
		System.out.println(queue);
		
		System.out.println("-----SEARCHING----------");
		boolean status = queue.contains("abc");
		System.out.println(status? "FOUND": "NOT FOUND");
		
		queue.forEach(System.out::println);
		System.out.println("----------REMOVING ALL ELEMENTS------------");
		queue.clear();//[]
		System.out.println(queue);
		
	}
}

