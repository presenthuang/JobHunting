package interviewQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMaxHeap {
//	You are given an array. You make 2 heaps out of it, 
//	one minheap and the other max heap. Now find the median 
//	of the array using these 2 provided heaps in O(nlog n) time.
    private int count;
    private PriorityQueue<Integer> highs, lows;

    public MinMaxHeap() {
        highs = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override            
        	public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        });
        lows = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1.compareTo(arg0);
            }
        });
    }

    private int getMedian() {
        if (count == 0)
            return 0;
        if (lows.size() == highs.size()) {
            return (lows.peek() + highs.peek()) / 2;
        } else if (lows.size() < highs.size()) {
            return highs.peek();
        }
        return lows.peek();
    }

    private void swap(){
        int h = highs.poll();
        int l = lows.poll();
        highs.add(l);
        lows.add(h);
    }

    public int updateMedian(int n) {
        count++;
        if (count == 1)
            lows.add(n);
        else if (count==2) {
            highs.add(n);
            if(highs.peek()<lows.peek()) {
                swap(); // O(log n)
            }
        }else {
            if (n > highs.peek()) {
                lows.add(highs.poll()); // O(log n)
                highs.add(n); // O(log n)
            } else {
                highs.add(lows.poll()); // O(log n)
                lows.add(n); // O(log n)
            }
            if(highs.peek()<lows.peek()) {
                swap(); // O(log n)
            }
        }
        // if we added an even # of items,
        // the heaps must be exactly the same size,
        // otherwise we tolerate a 1-off difference
        if (Math.abs(lows.size() - highs.size()) > (count % 2)) {
            if (lows.size() < highs.size()) {
                lows.add(highs.poll()); // O(log n)
            } else {
                highs.add(lows.poll()); // O(log n)
            }
        }
        return getMedian(); // O(1)
    }
}
