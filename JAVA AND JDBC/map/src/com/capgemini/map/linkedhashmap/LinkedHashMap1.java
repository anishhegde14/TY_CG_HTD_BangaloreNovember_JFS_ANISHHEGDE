package com.capgemini.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap1 {
	
	public static void main(String[] args) {
		
		LinkedHashMap<String, Integer> l=new LinkedHashMap<String, Integer>();
		
		l.put("BTM", 560076);
		l.put("Btr", 560074);
		l.put("rajainagar", 560079);
		l.put(null, null);
		l.put(null, 5434345);
		
		l.remove("Btr");
		
		Set<Map.Entry<String, Integer>> s=l.entrySet();
		
		for (Map.Entry<String, Integer> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("-------------");
			
		}
		System.out.println(l.isEmpty());
		System.out.println(l.containsValue(560076));
		System.out.println(l.containsKey("BTM"));
		System.out.println(l.size());
	}

}
