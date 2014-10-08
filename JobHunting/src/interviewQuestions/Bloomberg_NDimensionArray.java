package interviewQuestions;

import java.lang.reflect.Array;

public class Bloomberg_NDimensionArray {
//	Write a function that accepts an n-dimension array and prints its values--For array of any dimension. 
//
//	What is the layout of multi-dimensional array in the memory?
	public static void main(String[] args) {

		System.out.println("String 3D Array");
		String[][][] str3DArray = { { { "a", "b" }, { "c", "d" }, { "e", "f" } },
				{ { "g", "h" }, { "i", "j" }, { "k", "l" } } };

		showArray(str3DArray);

		System.out.println("int 2D Array");
		int[][] int2DArray = { { 0, 1, 2, 3 }, { 3, 2, 1, 0 }, { 3, 5, 6, 1 },
				{ 3, 8, 3, 4 } };
		showArray(int2DArray);

		System.out.println("int 3D Array");
		int[][][] int3DArray = { { { 0, 1 }, { 2, 3 }, { 4, 5 } },
				{ { 6, 7 }, { 8, 9 }, { 10, 11 } } };

		showArray(int3DArray);
		
		System.out.println("int 1D Array");
		int[] int1DArray = { 0, 1, 2, 3 };
		showArray(int1DArray);
		
		System.out.println("float 3D Array");
		float[][][] float3DArray = { { { 0.0f, 1.1f }, { 2.0f, 3.1f }, { 4.0f, 5.1f } },
				{ { 6.0f, 7.1f }, { 8.0f, 9.1f }, { 10.0f, 11.1f } } };

		showArray(float3DArray);
		
		System.out.println("Integer 3D Array");
		Integer[][][] integer3DArray = { { { new Integer(0), 1 }, { new Integer(2), 3 }, { new Integer(4), 5 } },
				{ { new Integer(6), 7 }, { new Integer(8), 9 }, { new Integer(10), 11 } } };

		showArray(integer3DArray);
	}

	public static void showArray(Object objects) {

		Object[] objArr = null;
		if (null != objects && null != objects.getClass()
				&& null != objects.getClass().getComponentType()
				&& objects.getClass().isArray()) {
			objArr = (Object[]) (toObjectArray(objects));
			for (int i = 0; i < objArr.length; i++) {
				showArray(objArr[i]);
				if (objArr[i].getClass().isArray()) {
					System.out.println();
				}
			}
		} else {
			System.out.print(objects);
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object[] toObjectArray(Object source) {
		if (source instanceof Object[]) {
			return (Object[]) source;
		}
		if (source == null) {
			return new Object[0];
		}
		if (!source.getClass().isArray()) {
			throw new IllegalArgumentException("Source is not an array: "
					+ source);
		}
		int length = Array.getLength(source);
		if (length == 0) {
			return new Object[0];
		}
		Class wrapperType = Array.get(source, 0).getClass();
		Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
		for (int i = 0; i < length; i++) {
			newArray[i] = Array.get(source, i);
		}
		return newArray;
	}
}
