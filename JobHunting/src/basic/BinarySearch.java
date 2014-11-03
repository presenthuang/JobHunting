package basic;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 8, 10 };
		System.out.println(binarySearch(arr, 5));
		System.out.println(bsRecursion(arr, 5));

		int[] array = { 3, 4, 1, 2 };
		System.out.println(bsRotation(array));
		System.out.println(bsRotationRecursion(array, 0, array.length - 1));
	}

	// return the position of the val
	public static int binarySearch(int[] arr, int val) {
		int left = 0;
		int right = arr.length - 1;
		// mid = 0 should be more clear
		int mid = (left + right) / 2;

		// important: must be left <= right !!!!!!!
		// when left == right, we still have to check whether whether
		// this mid is equal to val, if not: return -1
		while (left <= right) {
			mid = (left + right) / 2;

			if (val < arr[mid]) {
				right = mid - 1;
			} else if (arr[mid] < val) {
				left = mid + 1;
			} else { // equal
				return mid;
			}
		}
		// right now: left > right (already out of the while loop)
		return -1;
	}

	// outer interface
	public static int bsRecursion(int[] arr, int val) {
		return bsRecursion(arr, val, 0, arr.length - 1);
	}

	public static int bsRecursion(int[] arr, int val, int left, int right) {
		// Exit: the opposite of left <= right !!!
		if (left > right)
			return -1;

		// left <= right
		int mid = (left + right) / 2;

		if (val > arr[mid]) {
			return bsRecursion(arr, val, mid + 1, right);
		} else if (val < arr[mid]) {
			return bsRecursion(arr, val, left, mid - 1);

		} else { // equal
			return mid;
		}
	}

	/**
	 * 
	 * if the array is a sorted array with rotation, then find the smallest
	 * value of that array.
	 * 
	 * @param arr
	 * @return
	 */
	public static int bsRotation(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2; // can also be mid = 0

		// when left is equal to right, then that should be the value
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {	// arr[mid] <= arr[right])
				right = mid;
			}
		}
		return left;

	}

	// recursive version
	public static int bsRotationRecursion(int[] arr, int left, int right) {

		// EXIT: (if left == right)
		if (left >= right)
			return left;
		
		// left < right
		int mid = (left + right) / 2;

		if (arr[mid] > arr[right])
			return bsRotationRecursion(arr, mid + 1, right);
		else
			return bsRotationRecursion(arr, left, mid);
	}

}