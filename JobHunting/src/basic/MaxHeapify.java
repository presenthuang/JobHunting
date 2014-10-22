package basic;

public class MaxHeapify {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 2, 3, 0, 0, 1 };
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		buildMaxHeap(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void buildMaxHeap(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--)
			maxHeapify(arr, i);
	}

	public static void maxHeapify(int[] arr, int i) {
		int left = 2 * i + 1;//left = 2i + 1   //for a heap, the array must be level order full tree, so 2i+1 would be the left child and 2i+2 would be the right child
		int right = 2 * i + 2;//right = 2i + 2
		int largest = i;//largest = i

		if (left < arr.length && arr[left] > arr[largest])
			largest = left;
		if (right < arr.length && arr[right] > arr[largest])
			largest = right;
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}
	}
}
