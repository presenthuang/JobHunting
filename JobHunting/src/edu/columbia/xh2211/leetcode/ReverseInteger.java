package edu.columbia.xh2211.leetcode;

public class ReverseInteger {
//	Reverse digits of an integer.
//
//	Example1: x = 123, return 321
//	Example2: x = -123, return -321
	
    public int reverse(int x) {
        long input = x;
        long reversed = 0;
        
        if(input == 0)
        	return x;
        
        while(input != 0){
        	reversed = reversed * 10 + input % 10;
        	input = input / 10;
        }
        return (int)reversed;
    }
}
