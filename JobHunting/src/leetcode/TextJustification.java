package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
//	Given an array of words and a length L, 
//	format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//	You should pack your words in a greedy approach; 
//	that is, pack as many words as you can in each line. 
//	Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//	Extra spaces between words should be distributed as evenly as possible. 
//	If the number of spaces on a line do not divide evenly between words, 
//	the empty slots on the left will be assigned more spaces than the slots on the right.
//
//	For the last line of text, it should be left justified and no extra space is inserted between words.
//
//	For example,
//	words: ["This", "is", "an", "example", "of", "text", "justification."]
//	L: 16.
//
//	Return the formatted lines as:
//	[
//	   "This    is    an",
//	   "example  of text",
//	   "justification.  "
//	]
//	Note: Each word is guaranteed not to exceed L in length.
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0)
        	return result;
        ArrayList<String> bags = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < words.length; ++i){
        	if(count + bags.size() + words[i].length() > L){//exceed the length of one line
        		StringBuilder item = new StringBuilder();
        		if(bags.size() == 1){
        			item.append(bags.get(0));
        			int length = item.length();
        			for(int k = 0; k < L-length; ++k){
            			item.append(" ");
            		}
        		}else{
	        		int space = (L-count)/(bags.size() - 1);//number of extra spaces for every word evenly
	        		int extra = (L-count)%(bags.size() - 1);//extra spaces unevenly
	        		for(String word : bags){
	        			if(item.length() != 0){
	        				for(int k = 0; k < space; ++k){
	        					item.append(" ");
	        				}
	        				if(extra != 0){
	        					item.append(" ");
	        					extra--;
	        				}
	        			}
	        			item.append(word);
	        		}
        		}
        		result.add(item.toString());
        		
        		count = words[i].length();
        		bags.clear();
        		bags.add(words[i]);
        	}else{//not exceed one line length, just add new words.
        		count+=words[i].length();
        		bags.add(words[i]);
        	}
        }
        
        if(bags.size() != 0){//last line
        	StringBuilder item = new StringBuilder();
    		if(bags.size() == 1){
    			item.append(bags.get(0));
    			int length = item.length();
    			for(int k = 0; k < L-length; ++k){
        			item.append(" ");
        		}
    		}else{
        		for(String word : bags){
        			if(item.length() != 0){
        				item.append(" ");
        			}
        			item.append(word);
        		}
        		int length = item.length();
        		for(int k = 0; k < L-length; ++k){
        			item.append(" ");
        		}
    		}
    		result.add(item.toString());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
 		List<String> result = t.fullJustify(words, 16);
 		for(String tsString : result){
 			System.out.println(tsString + tsString.length());
 		}
	}
}
