public class QuickSort {

	private static void sort(int[] arr) {
		if (arr == null)
			return;
		if (arr.length < 1)
			return;
		System.out.println("********* Comparisons *******");
		quickSort(0, arr.length - 1, arr);
		System.out.println("*******************************");
	}

	private static void quickSort(int i, int j, int[] arr) {
		if (i > j)
			return;
		int pIndex = getPartionIndex(i, j, arr);
		printArray(arr);
		quickSort(i, pIndex - 1, arr);
		quickSort(pIndex + 1, j, arr);
	}

	private static int getPartionIndex(int i, int j, int[] arr) {
		int pivot = arr[j];
		int pIndex = i;
		for (int k = i; k < j; k++) {
			if (arr[k] <= pivot) {
				swap(k, pIndex, arr);
				pIndex++;
			}
		}
		swap(pIndex, j, arr);
		return pIndex;
	}

	private static void swap(int i, int j, int[] arr) {
		if (arr == null)
			throw new RuntimeException("Array is null, please create array.");
		if (arr.length == 0)
			throw new RuntimeException(
					"Array is empty, please initialse the array.");
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		if (arr == null)
			return;
		if (arr.length == 0)
			return;
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] unSortedArr = { 9, 1, 8, 3, 2, 5, 7, 6, 4 };
		System.out.println("++++++++++ Quick Sort +++++++++");
		System.out.println("Before Sorting:");
		printArray(unSortedArr);
		sort(unSortedArr);
		System.out.println("After Sorting:");
		printArray(unSortedArr);
	}
}
