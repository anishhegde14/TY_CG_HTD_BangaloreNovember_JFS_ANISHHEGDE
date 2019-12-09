package com.capgemini.map.treemap;

import java.util.Comparator;

public class SortingAge implements Comparator<Student2> {

	@Override
	public int compare(Student2 o1, Student2 o2) {
		if(o1.age>o2.age)
			return 1;
		else if(o1.age<o2.age)
			return -1;
		else		
			return 0;
	}

	@Override
	public String toString() {
		return "SortingAge []";
	}
	

}
