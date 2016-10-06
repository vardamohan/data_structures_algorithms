public class CocktailSort {

	private static void sort(int[] arr) {
		if(arr == null)
			return;
		if(arr.length == 0)
			return;
		System.out.println("********* Comparisons *******");
		for(int i = arr.length, k = 0; i > 1 && k < arr.length-1; i--,k++){
			boolean isSwaped = false;
			for(int j = 0; j < i-1; j++){
				if(arr[j] > arr[j+1]){
					swap(j, j+1, arr);
					isSwaped = true;
				}
			}
			if(!isSwaped)
				break;
			printArray(arr);
			for(int j = arr.length-1; j > k ; j--){
				if(arr[j] < arr[j-1]){
					swap(j, j-1, arr);
					isSwaped = true;
				}
			}
			if(!isSwaped)
				break;
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
		System.out.println("++++++++++ Cocktail Sort +++++++++");
		System.out.println("Before Sorting:");
		printArray(unSortedArr);
		sort(unSortedArr);
		System.out.println("After Sorting:");
		printArray(unSortedArr);
	}
}
