package binarySearch;

/**
 * Search algorithm that finds position of a target value in a sorted array.
 * 
 * Worst-case performance O(log n)
 * 
 * @author Adina
 *
 */
public class BinarySearch {

	/**
	 * Search recursively in O(log n) time
	 * 
	 * @param A array to search in
	 * @param x element to search for
	 * @return position of x in A or -1 if not found
	 */
	public static int binarySearchRecursive(int[] A, int x) {
		return binarySearchRecursive(A, 0, A.length - 1, x);
	}

	/**
	 * Search recursively in progressively smaller halves of the array
	 * 
	 * @param A array to search in
	 * @param left left-index in A we're looking past
	 * @param right right-index in A we're looking up to
	 * @param x element to search for
	 * @return position of x in A or -1 if not found
	 */
	private static int binarySearchRecursive(int[] A, int left, int right, int x) {
		// element not found
		if (left > right)
			return -1;

		// middle location
		int mid = (right - left) / 2 + left; // (left + right) / 2

		// found the element in the middle
		if (A[mid] == x)
			return mid;

		// look in first half
		if (A[mid] > x)
			return binarySearchRecursive(A, left, mid - 1, x);

		// look in second half
		if (x > A[mid])
			return binarySearchRecursive(A, mid + 1, right, x);

		// element not found
		return -1;
	}

	/**
	 * Search iteratively in O(log n) time
	 * 
	 * @param A array to search in
	 * @param x element to search for
	 * @return position of x in A or -1 if not found
	 */
	public static int binarySearchIterative(int[] A, int x) {
		int left = 0;
		int right = A.length - 1;

		while (left <= right) {
			// middle element
			int mid = (right - left) / 2 + left; // (left + right) / 2

			// continue looking in the first half
			if (x < A[mid])
				right = mid - 1;

			// continue looking in the second half
			else if (x > A[mid])
				left = mid + 1;

			// found the element in the middle
			else
				return mid;
		}
		return -1;
	}
}
