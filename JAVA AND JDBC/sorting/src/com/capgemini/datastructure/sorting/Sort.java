package com.capgemini.datastructure.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Sort {
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
		int result[]=Bubble.bubbleSort(arr);
		for(int i=0;i<result.length;i++) {
			System.out.println(" "+result[i]);
		}
		Instant end=Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("time: "+ seconds + " seconds");
	}
}
