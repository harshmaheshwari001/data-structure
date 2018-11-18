package algorithm;

import java.util.Random;

/**
 * Searching Algorithm implementation
 * 
 * @author Harsh Maheshwari
 *
 */
public class SearchingAlgorithm {

	public static int linerSearch(int[] a, int find) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == find) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] a, int low, int high, int find) {
		if (a.length == 0 || low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (find == a[mid]) {
			return mid;
		} else if (find < a[mid]) {
			return binarySearch(a, low, mid - 1, find);
		} else if (find > a[mid]) {
			return binarySearch(a, mid + 1, high, find);
		}
		return -1;
	}

	public static void main(String args[]) {
		int a[] = new int[100000];
		for (int i = 0; i < 100000; i++) {
			a[i] = i + 1;
		}
		Random r = new Random();
		int find = r.nextInt(100000);
		System.out.printf("\n finding for = %s ", find);

		int i = binarySearch(a, 0, a.length - 1, find);
		if (i < 0) {
			System.out.println("Can't find in array");

		} else {
			System.out.printf("\n Element = %s, found at =[%s] ", find, i + 1);
		}
		System.out.println("\n********************* Using Linear Search **************************");
		i = linerSearch(a, find);
		if (i < 0) {
			System.out.println("Can't find in array");

		} else {
			System.out.printf("\n Element = %s, found at =[%s] ", find, i + 1);
		}
	}

}
