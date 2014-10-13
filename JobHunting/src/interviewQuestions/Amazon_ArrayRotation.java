package interviewQuestions;

public class Amazon_ArrayRotation {
//	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	
	void leftRotate(int[] array, int d, int n){
		int index = 0;
		for(int i = 0; i < n; ++i){
			if(array[i] == d){
				index = i;
				break;
			}
		}
		int left = 0;
		int right = index;
		while(left < right){//swap the value from 0 to the end of index
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		left = index+1;
		right = n-1;
		while(left < right){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--; 
		}
		
		left = 0;
		right = n-1;
		while(left < right){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}		
	}
	
	public static void main(String[] args) {
		Amazon_ArrayRotation arr = new Amazon_ArrayRotation();
		int [] array = {1,2,3,4,5};
		arr.leftRotate(array, 3, 5);
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + " ");
	}
}
