package interviewQuestions;

public class Amazon_ArrayRotation {
//	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	
	void leftRotate(int[] array, int d, int n){
		int index = 0;
		//first we need to find the pos that the array would start to rotate
		for(int i = 0; i < n; ++i){
			if(array[i] == d){
				index = i;
				break;
			}
		}
		//reverse from 0 to element d
		int left = 0;
		int right = index;
		while(left < right){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		//reverse from element d to end of list.
		left = index+1;
		right = n-1;
		while(left < right){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--; 
		}
		//reverse the whole list
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
		int [] array = {1,2,3,4,5,6,7};
		arr.leftRotate(array, 3, 7);
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + " ");
	}
}
