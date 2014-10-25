package leetcode.string;

import java.util.HashMap;

public class LongestCommonPrefix {
	// ================================================================== //
	// Longest Common Prefix
	// Write a function to find the longest common prefix string amongst an
	// array of strings.
	// ================================================================== //
//	public String longestCommonPrefix(String[] strs) {
//		if (strs == null || strs.length == 0)
//			return "";
//		String test = strs[0];
//		int index = 0;
//		while (true) {
//			if (index >= test.length())
//				return test;
//			for (String str : strs) {
//				if (str.length() < index + 1
//						|| str.charAt(index) != test.charAt(index))
//					return test.substring(0, index);
//			}
//			index++;
//		}
//	}
//	
	// Trie Node, which stores a character and the children in a HashMap
	class TrieNode {
	    private char value;
	    private HashMap<Character, TrieNode> children;
	    private boolean bIsEnd;
	    public TrieNode(char ch){
	        value = ch;
	        children = new HashMap<>();
	        bIsEnd = false;
	    }
	    public HashMap<Character,TrieNode> getChildren(){   
	    	return children;
	    }
	    public char getValue(){
	    	return value;
	    }
	    public void setIsEnd(boolean val){
	    	bIsEnd = val;
	    }
	    public boolean isEnd(){
	    	return bIsEnd;
	    }
	}
	
	// Method to insert a new word to Trie
    public void insert(TrieNode root, String word)  {
        // Find length of the given word
        int length = word.length();
        TrieNode crawl = root;
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++){
            HashMap<Character,TrieNode> child = crawl.getChildren();            
            char ch = word.charAt(level);
            // If there is already a child for current character of given word 
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else{   // Else create a child              
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }
	
	//Trie Implementation.
	public String longestCommonPrefix(String[] strs) {
		int length = strs.length;
		if(length == 0){
			return "";
		}
		if(length == 1){
			return strs[0];
		}
		TrieNode root = new TrieNode((char)0);
		for(String word: strs){
			insert(root, word);
		}
		StringBuilder sb = new StringBuilder();
		TrieNode crawlNode = root;
		while(!crawlNode.isEnd() && crawlNode.getChildren().size() == 1){
			for(Character ch : crawlNode.getChildren().keySet()){
				sb.append(ch);
				crawlNode = crawlNode.getChildren().get(ch);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = {"abcde", "abcdeeeeee", "abccccde"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}
}
