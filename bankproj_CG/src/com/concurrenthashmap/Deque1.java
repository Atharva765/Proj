package com.concurrenthashmap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;




public class Deque1 {
	public static void main(String[] args) {
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(4);
		queue.offer(5);
		//queue.offer(null); // throws NPE
		queue.addFirst(2);
		
		System.out.println(queue);
		
		Deque<Integer> q = new LinkedList<>();
		
		q.offer(2);
		q.offer(5);
		q.offer(null); // it take the null value
		
		Deque<Integer> q1 = new ConcurrentLinkedDeque<>();
		q1.offer(5);
		q1.offer(2);
		q1.offer(1);
		q1.offer(10);
		System.out.println(q1);
		
		
		Iterator<Integer> itr =  q1.descendingIterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+ " ");
		}
		
	}
}
