package string;

public class ImplementstrStr {
//	Implement strStr().
//
//	Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
	
//	http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
	
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
        	return null;
        int haystacklength = haystack.length();
        int needlelength = needle.length();
        if (needlelength == haystacklength && needlelength == 0)
    		return "";
     
    	if (needlelength == 0)
    		return haystack;
    	
    	for (int i = 0; i < haystacklength; i++) {
    		// make sure in boundary of needle
    		if (haystacklength - i + 1 < needlelength)
    			return null;
     
    		int k = i;
    		int j = 0;
     
    		while (j < needlelength && k < haystacklength && needle.charAt(j) == haystack.charAt(k)) {
    			j++;
    			k++;
    			if (j == needlelength)
    				return haystack.substring(i);
    		}
    	}
    	return null;
    }
}
