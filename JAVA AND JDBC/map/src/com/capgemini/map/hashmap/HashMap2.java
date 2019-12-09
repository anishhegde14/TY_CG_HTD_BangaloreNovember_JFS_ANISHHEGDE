package com.capgemini.map.hashmap;

import java.util.Collection;
import java.util.HashMap;

public class HashMap2 {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Student> h1=new HashMap<Integer, Student>();
		
		h1.put(34, new Student(23, "Divya"));
		h1.put(54, new Student(24, "Ramesh"));
		h1.put(null, null);
		h1.put(null, new Student(23, "Divya"));
		
		
		Collection<Integer> s=h1.keySet();
		
		for(Integer s2:s) {
			System.out.println(s2);
		}
		
		System.out.println(h1.containsKey(34));
		System.out.println(h1.containsValue(new Student(23, "Divya")));
		System.out.println(h1.size());
	}

}
