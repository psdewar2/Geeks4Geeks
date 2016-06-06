public class Interview {
	public static void main(String[] args) {
		int[] array = {15,18,2,3,5,6,9};
		System.out.println(findInCircularArray(array, 8));

	}

	static int findInCircularArray(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (value == array[mid]) { 
				return mid;
			} else if (array[mid] <= array[high]) { //if true this half is sorted
				if (value > array[mid] && value <= array[high]) { //right half is sorted
					low = mid + 1; //search sorted right half
				} else {
					high = mid - 1; //search left half
				}
			} else if (array[mid] >= array[low]) {
				if (value < array[mid] && value >= array[low]) { //left half is sorted
					high = mid - 1; //search sorted left half
				} else {
					low = mid + 1; //search right half
				}
			}
		}
		return -1;
	} 

	//returns the index of the minimum which is the number of rotations of the sorted array
	static int numRotations(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[low] <= array[high]) return low; //no rotations
			int next = (mid + 1) % array.length;
			int prev = (mid + array.length - 1) % array.length; //length of array is added here to prevent negative
			if (array[mid] <= array[next] && array[mid] <= array[prev]) return mid;
			else if (array[mid] <= array[high]) high = mid - 1;
			else if (array[mid] >= array[low]) low = mid + 1;
		}
		return -1;
	}

	//returns number of times a value occurs in a sorted array
	static int occurrences(int[] array, int value) {
		int count = 0;
		count += findFirstOrLast(array, value, false) - findFirstOrLast(array, value, true) + 1; 
		return count;
	}

	//Returns index of first or last occurence of a number in a sorted array of positive numbers
	//non-recursive
	static int findFirstOrLast(int[] array, int value, boolean findFirst) {

		int low = 0;
		int high = array.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (value == array[mid]) {
				result = mid;
				if (findFirst) {
					high = mid - 1; 
				} else {
					low = mid + 1; 
				}
			} else if (value < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

}

