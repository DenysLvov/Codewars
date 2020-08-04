package codewar_tasks;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciTest {

	/*
	 * Fibonacci numbers:
	 * User enters length of Fibonacci sequence
	 * Application generates random range in this sequence (start\end elements),
	 * and culculates sum of all elements in this range
	 */

	public static void main(String[] args) {
		Operationable<Integer> rangedArray = (array, range)  -> {
			// increase second parameter due to it's not excluded in border (copyOfRange() specific)
			int[] newArray = Arrays.copyOfRange(array,range[0], ++range[1]);
			return newArray;
		};

		int sqnceLength = readN();
		int [] fibonacciNum = fillArray(sqnceLength);
		int [] range = generateRange(sqnceLength);
		int sum = findSum(rangedArray.calculate(fibonacciNum, range));
		String s = String.format("\nSum of all digits in range is %s", sum);
		System.out.println(s);
	}

	/**
	 * Reads user input
	 * 
	 * @return length of sequence
	 */
	static int readN() {
		String input = null;
		int num;
		System.out.println("Enter lenght of sequence: ");
		try {
			@SuppressWarnings("resource")
			Scanner keyb = new Scanner(System.in);
			input = keyb.next();
		} catch (Exception e) {
			System.err.println("Error in readNumber: " + e);
		}
		// check input for non digit and min available value
		try {
			num = Integer.parseInt(input);
			if (num < 2 || num > 100) {
				System.out.println("Incorrect input. Value should be > 2 and < 100");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage() + "\n Incorrect input. Expected input - digit");
			System.exit(1);
		}
		return Integer.parseInt(input);
	}

	/**
	 * Creates array with length = sqnceLength
	 * 
	 * @param sqnceLength
	 * @return array of double from 0 to sqnceLength
	 */
	static int[] fillArray(int sqnceLength) {
		int[] arr = new int[sqnceLength];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i < sqnceLength; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		System.out.println("Fibonacci row is: ");
		System.out.println(Arrays.toString(arr));
		return arr;

	}

	/**
	 * Generates range from X to Y
	 * 
	 * @param sqnceLength
	 * @return array with two indexes: start\end of range
	 */
	static int[] generateRange(int sqnceLength) {
		int x = 0;
		int y = 0;
		Random randomGenerator = new Random();
		while (x == y) { // generates two values from range n
			x = randomGenerator.nextInt(sqnceLength);
			y = randomGenerator.nextInt(sqnceLength);
		}
		int[] range  = {x, y};
		Arrays.sort(range);
		System.out.println(String.format("\nRange for calculation: from %s element to %s element",range[0], range[1]));
		return  range;
	}

	/**
	 * 
	 * @param rangedArray
	 *            - sequence of numbers
	 * @return sum of elements from X, to Y
	 */
	static int findSum(int[] rangedArray) {
		return IntStream.of(rangedArray).sum();
	}

	/**
	 *
	 * @param rangedArray
	 *            - sequence of numbers
	 * @return multiplication of elements from X, to Y
	 */
	static int findMultipl(int[] rangedArray) {

		Stream<Integer> numbers = rangedArray.stream();

		Optional<Integer> result = numbers.reduce((x,y) -> y * x);
		return result.get();
	}
}
