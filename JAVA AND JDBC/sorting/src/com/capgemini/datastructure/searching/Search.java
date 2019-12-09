package com.capgemini.datastructure.searching;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import com.capgemini.datastructure.sorting.Bubble;

public class Search {
	
	static int [] arr;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length of the array...");
		int n=sc.nextInt();
		 arr= new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the elements...");
			arr[i]=sc.nextInt();
		}
		countingDuration1();
	}
	public static void countingDuration1() {
		Instant start = Instant.now();
		BinarySearch.binarySearch(arr, 0, arr.length-1, 22 );
		Instant end=Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("time: "+ seconds + " seconds");
	}

}
