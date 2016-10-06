public class SelectionSort {

	private static void sort(int[] arr) {
		if(arr == null)
			return;
		if(arr.length == 0)
			return;
		System.out.println("********* Comparisons *******");
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (i != min)
				swap(i, min, arr);
			printArray(arr);
		}
		System.out.println("*******************************");
	}

	private static void swap(int i, int j, int[] arr) {
		if(arr == null)
			throw new RuntimeException("Array is null, please create array.");
		if(arr.length == 0)
			throw new RuntimeException("Array is empty, please initialse the array.");
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		if(arr == null)
			return;
		if(arr.length == 0)
			return;
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] unSortedArr = { 9, 1, 8, 3, 2, 5, 7, 6, 4 };
		System.out.println("++++++++++ Selection Sort +++++++++");
		System.out.println("Before Sorting:");
		printArray(unSortedArr);
		sort(unSortedArr);
		System.out.println("After Sorting:");
		printArray(unSortedArr);
	}
}
