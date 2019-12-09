package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap3 {
	
	public static void main(String[] args) {
		SortingAge s1=new SortingAge();
		
		
		TreeMap<Student2, String> t=new TreeMap<Student2, String>(s1);
		
		t.put(new Student2(2,"vivek"), "1st student");
		t.put(new Student2(13,"aniket"), "8th student");
		t.put(new Student2(3,"ramesh"), "2nd student");
		
		System.out.println(t.get(new Student2(2,"vivek")));
		
		Set<Map.Entry<Student2, String>> s=t.entrySet();
		
		for (Entry<Student2, String> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("------------------");
			
		}
	}

}
