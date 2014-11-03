package basic;

public class SearchMaxLessThan {

	public static int searchMaxLessThan(int[] A, int target, int start, int end) {
		// start won't be > than end
		if (start == end) // only one number
			return A[start] < target ? start : start - 1;
		if (start == end - 1) { // only 2 numbers
			if (A[end] < target) {
				return end;
			} else if (A[start] < target) {
				return start;
			} else { // A[end] >= target && A[start] >= target
				return start - 1;
			}
		}

		// modified binary search... (Don't need to handle A[mid] == target: case)
		int mid = (start + end) / 2;
		if (A[mid] >= target)  // A[mid] == target is the same as A[mid] > target
			return searchMaxLessThan(A, target, start, mid - 1);
		else   // A[mid] < target
			return searchMaxLessThan(A, target, mid, end);
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 3, 3, 4, 5 };
		System.out.println(searchMaxLessThan(A, 3, 0, A.length - 1));
	}
}
