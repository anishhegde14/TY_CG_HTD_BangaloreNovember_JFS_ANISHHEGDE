package com.capgemini.map.linkedhashmap;

import java.util.*;
import java.util.Map.Entry;

public class LinkedHashMap2 {
	
	public static void main(String[] args) {
		
		LinkedHashMap<Integer, Employee> l=new LinkedHashMap<Integer, Employee>();
		
		l.put(34, new Employee(2300, "Ramesh"));
		l.put(36, new Employee(4300, "Ramesh"));
		l.put(39, new Employee(6780, "Ramesh"));
		
		System.out.println(l.get(2300));
		
		Set<Entry<Integer, Employee>> s=l.entrySet();
		
		for (Entry<Integer, Employee> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			
		}
		System.out.println(l.containsKey(36));
		System.out.println(l.containsValue(new Employee(2300,"Ramesh")));
		
	}

}
