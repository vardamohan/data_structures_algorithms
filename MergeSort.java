public class MergeSort {

	private static void sort(int[] arr) {
		if (arr == null)
			return;
		if (arr.length < 1)
			return;
		System.out.println("********* Comparisons *******");
		mergeSort(arr);
		System.out.println("*******************************");
	}	

	private static void mergeSort(int[] arr) {
		int len = arr.length;
		if(len < 2)
			return;
		int mid = len/2;
		int[] left = new int[mid];
		int[] right = new int[len-mid];
		for(int i = 0; i < mid; i++)
			left[i] = arr[i];
		for(int i = 0, j = mid; i < len-mid; i++, j++)
			right[i] = arr[j];
		mergeSort(left);
		mergeSort(right);
		merge(left,right,arr);
	}

	private static void merge(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;
		while(j < left.length && k < right.length){
			if( left[j] > right[k]){
				arr[i++] = right[k];
				k++;
			}else{
				arr[i++] = left[j];
				j++;
			}
		}
		while(j < left.length){
			arr[i++] = left[j++];
		}
		while(k < right.length){
			arr[i++] = right[k++];
		}		
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
		System.out.println("++++++++++ Merge Sort +++++++++");
		System.out.println("Before Sorting:");
		printArray(unSortedArr);
		sort(unSortedArr);
		System.out.println("After Sorting:");
		printArray(unSortedArr);
	}
}
