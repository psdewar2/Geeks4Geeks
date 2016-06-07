
import java.util.Stack;

public class Interview {
	public static void main(String[] args) {
		int[][] array = {{2,4,6,8},{5,9,12,16},{2,11,5,9},{3,2,1,8}};
		System.out.println(balancedParentheses("{(([[]))}"));
	}

	static boolean balancedParentheses(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ')' && stack.peek() != '(' || 
				str.charAt(i) == ']' && stack.peek() != '['|| 
				str.charAt(i) == '}' && stack.peek() != '{') {
				return false;
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	static void stackReverse(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		for (int i = 0; i < str.length(); i++) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	static void printSpiralOrder(int[][] array) {
		int top = 0, left = 0;
		int right = array[0].length - 1, bottom = array.length - 1;
		int d = 0; //d is for direction: 0 right, 1 down, 2 left, 3 up
		while (top <= bottom && left <= right) {
			if (d == 0) {
				for (int i = left; i <= right; i++) {
					System.out.print(array[top][i] + " ");
				}
				top++;
			} else if (d == 1) {
				for (int i = top; i <= bottom; i++) {
					System.out.print(array[i][right] + " ");
				}
				right--;
			} else if (d == 2) {
				for (int i = right; i >= left; i--) {
					System.out.print(array[bottom][i] + " ");
				}
				bottom--;
			} else if (d == 3) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(array[i][left] + " ");
				}
				left++;
			}
			// d++;
			// if (d == 4) d = 0; OR
			d = (d + 1) % 4;
		}
		System.out.println();
	}

	static int findInCircularArray(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (value == array[mid]) { 
				return mid;
			} else if (array[mid] <= array[high]) { //if true right half is sorted
				if (value > array[mid] && value <= array[high]) { //
					low = mid + 1; //search sorted right half
				} else {
					high = mid - 1; //search left half
				}
			} else if (array[mid] >= array[low]) { //if true left half is sorted
				if (value < array[mid] && value >= array[low]) {
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

