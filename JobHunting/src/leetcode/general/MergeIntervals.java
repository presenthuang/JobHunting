package leetcode.general;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
//	Given a collection of intervals, merge all overlapping intervals.
//
//	For example,
//	Given [1,3],[2,6],[8,10],[15,18],
//	return [1,6],[8,10],[15,18].
	
	//N^2 solution, not so good.
	
//	No need to sort also could work out a solution, but n^2, should sort at first
	 public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	 }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<Interval>();
        boolean nocommon = true;
        for(int i = 0; i < intervals.size(); ++i){//require that this intervals are in a increasing order? No.
        	Interval cur = intervals.get(i);
        	nocommon = true;
        	for(int j = i+1; j < intervals.size(); ++j){
        		Interval inlist = intervals.get(j);
        		if(overlapped(cur,inlist)){
        			Interval temp = new Interval(Math.min(cur.start, inlist.start), Math.max(cur.end, inlist.end));
        			intervals.set(j, temp);
        			nocommon = false;
        			break;
        		}
        	}
        	if(nocommon){
        		result.add(cur);
        	}
        }
        return result;
    }
	private boolean overlapped(Interval inter1, Interval inter2) {
		if(inter1.start > inter2.end || inter1.end < inter2.start)
			return false;
		return true;
	}
}
