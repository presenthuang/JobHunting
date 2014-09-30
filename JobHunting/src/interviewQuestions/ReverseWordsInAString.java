package interviewQuestions;

public class ReverseWordsInAString {

	/**
	 * Leetcode's version
	 */
	public static String reverseWords(String s) {

		if (s == null || s.length() == 0)
			return s;

		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String str : arr) {
			if (!str.equals("")) {
				sb.insert(0, str);
				sb.insert(0, " ");
			}
		}
		return sb.toString().trim(); // 
	}

	/**
	 * Bloomberg's version
	 */
	public static String reverseWords2(String s) {

		if (s == null || s.length() == 0)
			return s;
		char[] arr = s.trim().toCharArray();
		reverse(arr, 0, arr.length - 1); // first pass of reversing

		int i = 0;
		while (i < arr.length) {
			int start = i;
			while (i + 1 < arr.length && arr[i + 1] != ' ')
				i++;
			int end = i;
			reverse(arr, start, end);
			i = end + 1;
			while (i < arr.length && arr[i] == ' ')
				i++;
		}
		return new String(arr); // EX: arr.toString() is totally wrong !!!
	}

	private static void reverse(char[] arr, int start, int end) {

		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("  a  b c   d ")); // Leetcode's
		System.out.println(reverseWords2("  a  b c   d ")); // Bloomberg's
	}
}
