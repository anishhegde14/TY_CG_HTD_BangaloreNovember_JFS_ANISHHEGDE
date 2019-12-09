package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2 {
	
	public static void main(String[] args) {
		
		TreeMap<Student, String> t=new TreeMap<Student, String>();
		
		t.put(new Student(2,"vivek"), "1st student");
		t.put(new Student(13,"aniket"), "8th student");
		t.put(new Student(3,"ramesh"), "2nd student");
		
		System.out.println(t.get(new Student(2,"vivek")));
		
		Set<Map.Entry<Student, String>> s=t.entrySet();
		
		for (Entry<Student, String> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("------------------");
			
		}
	}

}
