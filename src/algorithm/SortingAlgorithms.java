package algorithm;
/**
 * 
 * @author Harsh Maheshwari
 *
 */
public class SortingAlgorithms extends AbstractUtils {

	/**
	 * Selection Sort picks first item in Array and compare & Swap with all the
	 * elements after first iteration minimum element in the array will be on
	 * first position after second iteration second-minimum element in the array
	 * will be on the second position and so on.. Worst Case Time complexity
	 * 0(n^2)
	 * 
	 * @param a
	 * @return
	 */
	public static int[] selectionSort(final int a[]) {
		// Worst Case 0(n^2)
		itrCount = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				++itrCount;
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		return a;
	}

	/**
	 * Bubble Sort compares each adjacent pair with each other from beginning of
	 * the array in every pass Pass-1 ->
	 * Compares&Swap(first,second),Compare&Swap(second,third) and so on...
	 * Pass-2 -> Compares&Swap(first,second),Compare&Swap(second,third) and so
	 * on... After the completion of all the pass array is sorted. Worst Case
	 * Time complexity 0(n^2)
	 * 
	 * Bubble sort is highly Time complex algorithm
	 * 
	 * @param a
	 * @return
	 */
	
	// 4,3,2,1 
	//[0] 3,4,2,1 3,2,4,1  3,2,1,4
	//[1] 2,3,1,4 2,1,3,4 2,1,3,4
	//[2] 1,2,3,4 1,2,3,4 1,2,3,4
	//[3] 1,2,3,4 1,2,3,4 1,2,3,4
	public static int[] bubbleSort(final int a[]) {
		// Worst Case complexity 0(n^2)
		itrCount = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				++itrCount;
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	/**
	 * Insertion sort picks element and Compares&Swap(previous) element. process
	 * of Compare&Swap repeats with all previous elements once comparison over
	 * element is inserted at right place
	 *
	 * 
	 * Time Complexity 0(n^2)
	 * 
	 * @param a
	 * @return
	 */
	public static int[] insertionSort(int a[]) {
		itrCount = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			max = a[i];
			// printArray(a);
			for (int j = i - 1; j >= 0; j--) {
				itrCount++;
				if (max < a[j]) {
					int temp = a[j];
					a[j] = max;
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
	/**
	 * 
	 * WorstCase Complexity 0(nlogn). 
	 * 
	 * @param a
	 * @return
	 */
	public static int[] mergeSort(int[] a) {

		// WorstCase Complexity O(nlogn)
		if (a.length == 1) {
			return a;
		}
		int leftarraylenght = a.length / 2;
		int rightArraylenght = a.length - (a.length / 2);

		int[] leftArray = new int[leftarraylenght];
		int[] rightArray = new int[rightArraylenght];
		for (int i = 0; i < leftarraylenght; i++) {
			leftArray[i] = a[i];
		}
		for (int i = 0; i < rightArraylenght; i++) {
			rightArray[i] = a[i + leftarraylenght];
		}
		return mergeArray(mergeSort(leftArray), mergeSort(rightArray));
		// printArray(mergeArray(leftArray, rightArray), "Merge Sort=");
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] mergeArray(int a[], int b[]) {
		int i = 0, j = 0, index = -1;
		int m[] = new int[a.length + b.length];
		for (; i < a.length && j < b.length;) {
			if (a[i] <= b[j]) {
				m[++index] = a[i++];
			} else {
				m[++index] = b[j++];
			}
		}

		for (; i < a.length;) {
			m[++index] = a[i++];
		}
		for (; j < b.length;) {
			m[++index] = b[j++];
		}
		return m;
	}

	public void redixSort() {

	}

	public void quickSort() {

	}

	public static void main(String arg[]) {
		int a[] = new int[] { 13, 5, 2, 4, 6, 9, 121, 7, 1, 0, -1 };
		// int a[] = new int[] {13, 5,4,2, 6 };

		// int a[] = new int[] {-1, 0, 1, 2, 4, 5, 6, 7, 9, 13, 121};
		printArray(selectionSort(a), "Using Selection Sort = ", "Total Itr[", String.valueOf(itrCount), "]");
		printArray(bubbleSort(a), "Using Bubble sort =", "Total Itr[", String.valueOf(itrCount), "]");
		printArray(insertionSort(a), "Using Insertion sort =", "Total Itr[", String.valueOf(itrCount), "]");
		printArray(mergeSort(a), "Using Merge Sort = ");
		// printArray(mergeArray(new int[]{13,5}, new int[]{2, 4, 6}));
	}
}
