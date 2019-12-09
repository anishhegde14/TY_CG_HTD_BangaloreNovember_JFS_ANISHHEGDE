package com.capgemini.queue.arraydeque;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue1 {
	public static void main(String[] args) {
		
		ArrayDeque<String> a=new ArrayDeque<String>();
		
		a.add("vivek");
		a.addFirst("shree");
		a.addLast("divya");
		a.add("anu");
		a.add("vivek");
		
		
		System.out.println(a);
		
		Iterator itr=a.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-----------------");
		System.out.println(a.getLast()); 
		System.out.println("-------------");
		System.out.println(a.getFirst()); 
		System.out.println("-------------");
		a.removeLast();
		System.out.println(a);
		
		
	}

}
