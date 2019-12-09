package com.capgemini.datastructure.sorting;

import java.time.Duration;
import java.time.Instant;

public class Bubble {
	
	static int[] bubbleSort(int[] arr) {
		int temp=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
		
	}
}
