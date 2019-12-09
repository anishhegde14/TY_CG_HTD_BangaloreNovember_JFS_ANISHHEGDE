package com.capgemini.queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueue2 {
	public static void main(String[] args) {
		
		PriorityQueue p1=new PriorityQueue();
		
		p1.offer(new Student(22, "divya"));
		p1.offer(new Student(23, "shree"));
		p1.offer(new Student(22, "divya"));
		
		for (Object object : p1) {
			System.out.println(object);
			
		}
		
	}
	

}
