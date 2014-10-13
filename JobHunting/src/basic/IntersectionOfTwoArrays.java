package basic;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
	public void printIntersection(int arr1[], int arr2[]) {
		int i = 0, j = 0;
		int m = arr1.length;
		int n = arr2.length;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr1[i])
				j++;
			else /* if arr1[i] == arr2[j] */
			{
				System.out.println(arr2[j++]);
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array1 = {4, 2, 73, 11, -5};
		int[] array2 = {-5, 73, -1, 9, 9, 4, 7};
		IntersectionOfTwoArrays instance = new IntersectionOfTwoArrays();
		instance.printIntersection(array1, array2);
	}
}
