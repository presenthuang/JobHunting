package leetcode.array;

public class PlusOne {
//	Given a non-negative number represented as an array of digits, plus one to the number.
//
//	The digits are stored such that the most significant digit is at the head of the list.
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int length = digits.length;
        int pos = length - 1;
        int res = digits[pos] + 1;
        digits[pos] = res % 10;
        carry = res / 10;
        pos--;
        while(pos >= 0){
            res = digits[pos] + carry;
            digits[pos] = res % 10;
            carry = res / 10;
            pos--;
        }
        if(carry > 0){//the last digit is larger than 10 and the length is exceed;
            int[] result = new int[length+1];
            result[0] = carry;
            for(int i = 1; i<result.length; ++i){
                result[i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }
}
