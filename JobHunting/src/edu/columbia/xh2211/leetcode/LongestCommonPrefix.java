package edu.columbia.xh2211.leetcode;

public class LongestCommonPrefix {
	// ================================================================== //
	// Longest Common Prefix
	// Write a function to find the longest common prefix string amongst an
	// array of strings.
	// ================================================================== //
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String test = strs[0];
		int index = 0;
		while (true) {
			if (index >= test.length())
				return test;
			for (String str : strs) {
				if (str.length() < index + 1
						|| str.charAt(index) != test.charAt(index))
					return test.substring(0, index);
			}
			index++;
		}
	}

}
