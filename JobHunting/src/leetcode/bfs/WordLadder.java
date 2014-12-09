package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
//	Given two words (start and end), and a dictionary, 
//	find the length of shortest transformation sequence from start to end, such that:
//
//		Only one letter can be changed at a time
//		Each intermediate word must exist in the dictionary
//		For example,
//
//		Given:
//		start = "hit"
//		end = "cog"
//		dict = ["hot","dot","dog","lot","log"]
//		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//		return its length 5.
//
//		Note:
//		Return 0 if there is no such transformation sequence.
//		All words have the same length.
//		All words contain only lowercase alphabetic characters.
	
//	Use bfs and linkedlist to store the information and then calcuate every step
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0)
        	return 0;
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> curLength = new LinkedList<Integer>();
        wordQueue.offer(start);
        curLength.offer(1);
        while(!wordQueue.isEmpty()){
        	String curWord = wordQueue.poll();
        	int curDistince = curLength.poll();
        	if(curWord.equals(end)){
        		return curDistince;
        	}
        	for(int i = 0; i < curWord.length(); ++i){
        		char [] chararray = curWord.toCharArray();
        		for(char c = 'a'; c <= 'z'; ++c){
        			chararray[i] = c;
        			String newWord = new String(chararray);
        			if(dict.contains(newWord)){
        				wordQueue.offer(newWord);
        				curLength.offer(curDistince+1);
        				dict.remove(newWord);
        			}
        		}
        	}
        }
        return 0;
    }
}
