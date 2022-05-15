package com.max.automation.maxAutomation;

import java.util.Collections;

public class Palindrome {

	public static void main(String[] args) {

		if(checkPalindrome("mom")){
			System.out.println("It is palindrome");
		}else{
			System.out.println("Not a palindrome");
		}

		checkPalindromeStringReverse("madam");

	}
	//Write a program to check if the given string is a palindrome. For example - string “madam” -
	// output is true, string “abcd” - output is false
	//Input -- string
	//function output should be either yes or no
	//function's return type should be boolean

	//METHOD 1
	public static boolean checkPalindrome(String str){
		// str == madam
		// int =str.length/2=2

		int count =0;
		for(int i=0;i<str.length()/2;i++){
//			System.out.println(str.charAt(str.length()-1-i));
//			System.out.println(str.charAt(i));
			if (str.charAt(i)==str.charAt(str.length()-1-i)){
				count=count+1;
			}else {

			}

		}


		if (count==str.length()/2){
			return true;
		}else {
			return false;
		}


	}
	//METHOD 2
	public static void  checkPalindromeStringReverse(String str){
		String s2="";
		for(int i=0;i<str.length();i++){
			s2= s2+str.charAt(str.length()-1-i);
		}
		System.out.println(s2);
		if (str.matches(s2)){
			System.out.println("Palindrome");
		}else{
			System.out.println("not a palindrome");
		}

	}

}
