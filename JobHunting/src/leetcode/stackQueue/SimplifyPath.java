package leetcode.stackQueue;

import java.util.LinkedList;

public class SimplifyPath {
//	Given an absolute path for a file (Unix-style), simplify it.
//
//	For example,
//	path = "/home/", => "/home"
//	path = "/a/./b/../../c/", => "/c"
//	click to show corner cases.
//
//	Corner Cases:
//	Did you consider the case where path = "/../"?
//	In this case, you should return "/".
//	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//	In this case, you should ignore redundant slashes and return "/home/foo".
	
//	http://blog.csdn.net/fightforyourdream/article/details/16917563
	
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
        	return path;
        LinkedList<String> stack = new LinkedList<>();
        String [] parts = path.split("/");
        for(String s : parts){
        	if(s.length() == 0 || s.equals("."))
        		continue;
        	if(s.equals("..")){
        		if(!stack.isEmpty())
        			stack.pop();
        	}else{
        		stack.push(s);
        	}
        }
        if(stack.isEmpty())
        	stack.push("");
        String ret = "";
        while(!stack.isEmpty()){
        	ret += "/" + stack.removeLast();
        }
        return ret;
    }
}
