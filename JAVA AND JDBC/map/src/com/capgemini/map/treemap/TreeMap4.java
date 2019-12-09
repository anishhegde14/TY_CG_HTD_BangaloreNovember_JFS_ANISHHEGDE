package com.capgemini.map.treemap;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap4 {
	
	public static void main(String[] args) {
		
		ArrayList<Student3> a=new ArrayList<Student3>();
		
		TreeMap<String, ArrayList> t=new TreeMap<String, ArrayList>();
		
		a.add(new Student3(23,"vivek"));
		a.add(new Student3(25,"aniket"));
		a.add(new Student3(30,"abhi"));
		
		t.put("1st year engg", a);
		
		Set<Entry<String, ArrayList>> s1=t.entrySet();
		
		for (Entry<String, ArrayList> e : s1) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("----------------");
		}
	}

}
