package leetcode.general;

public class PalindromeNumber {
//	Determine whether an integer is a palindrome. Do this without extra space.
    public boolean isPalindrome(int x) {
        if(x < 0){
        	return false;
        }
        
        int original = x;
        long reverse = 0;
        
        while(original > 0){
        	reverse = reverse * 10 + original % 10;
        	original = original / 10;
        }
        
        if((int)reverse == x){
        	return true;
        }
        return false;
    }
}
