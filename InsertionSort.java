public class InsertionSort {

	private static void sort(int[] arr) {
		if(arr == null)
			return;
		if(arr.length == 0)
			return;
		System.out.println("********* Comparisons *******");
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			int val = arr[i];
			while (arr[j - 1] > val) {
				arr[j] = arr[j - 1];
				j--;
				if (j < 1)
					break;
			}
			arr[j] = val;
			printArray(arr);
		}
		System.out.println("*******************************");
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
		System.out.println("++++++++++ Insertion Sort +++++++++");
		System.out.println("Before Sorting:");
		printArray(unSortedArr);
		sort(unSortedArr);
		System.out.println("After Sorting:");
		printArray(unSortedArr);
	}
}
