package com.max.automation.maxAutomation;

public class Palindrome {

	public static void main(String[] args) {
		isPalindrome();

	}
	 static boolean isPalindrome(String str) {
		 
		 int i = 0, j = str.length() - 1;
		 
		 while (i < j) {
			 
	            // If there is a mismatch
	            if (str.charAt(i) != str.charAt(j))
	                return false;
	            System.out.println("Not a Palindrome");
	            i++;
	            j--;
	        }
		 
	        // Given string is a palindrome
	        return true;
	        
		 
	 }
}
