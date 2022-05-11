package com.max.automation.maxAutomation;

public class RecursionTest1 {

	public static void main(String[] args) {
		
		recursion(10);
		//recursion2(10);
	
	}
	public static void recursion(int N) {
		//Print N to 1 Using recursion 
		if(N>0) {
		System.out.println(N);
		recursion(N-1);
	}
	
	}
	public static void recursion2(int N) {
		//Print 1 to N Using recursion
		if (N>0) {
		System.out.println(10 -(N-1));
		recursion2( N-1);
		}
	}
}
