package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Google_EvenIterator implements Iterator<Integer> {
	//Implement the iterator to find the next iterator
	private Iterator<Integer> iter;
	private Integer nextEven = null;

	public Google_EvenIterator(Iterator<Integer> iter) {
		this.iter = iter;
		advance();
	}

	@Override
	public boolean hasNext() {
		return nextEven != null;
	}

	@Override
	public Integer next() {
		if (nextEven != null) {
			Integer res = nextEven;
			advance();
			return res;
		} else
			throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	private void advance() {
		while (iter.hasNext()) {
			Integer cur = iter.next();
			if (cur % 2 == 0) {
				nextEven = cur;
				return;
			} else {
				nextEven = null;
			}
		}
		nextEven = null; // if no further even number
	}

	public static void main(String[] args) {
		// even number: 2 6
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7,11,13,15,17,19,21,22));
		Google_EvenIterator evenIterator = new Google_EvenIterator(list.iterator());
		
		while (evenIterator.hasNext()) {
			System.out.println(evenIterator.next());
		}
	}
}
