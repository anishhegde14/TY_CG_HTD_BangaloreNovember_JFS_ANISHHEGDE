package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.map.hashmap.Student;

import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	
	public static void main(String[] args) {
		
		TreeMap<Integer, String> t=new TreeMap<Integer, String>();
		
		t.put(156, "divya");
		t.put(56, "shree");
		t.put(67, "anu");
		
		Set<Map.Entry<Integer, String>> s=t.entrySet();
		
		for (Map.Entry<Integer, String> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("----------------");
			
		}
		System.out.println(t.containsKey(34));
		System.out.println(t.containsValue("divya"));
		System.out.println(t.size());
	}

}

