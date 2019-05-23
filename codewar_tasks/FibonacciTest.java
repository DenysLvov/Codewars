package codewar_tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FibonacciTest {

	/*
	 * Получить от пользователя на вход число N Записать в массив ряд Фибоначчи
	 * длиной N Сгенерировать 2 случайных числа (X, Y) в пределах N Посчитать
	 * сумму всех чисел из сохраненного массива, имеющие индекс от X до Y
	 * (включительно)
	 */

	public static void main(String[] args) {
		int sqnceLength = readN();
		double[] arrOfNumbers = fillArray(sqnceLength);
		int[] range = generateRange(sqnceLength);
		double sum = findSum(range, arrOfNumbers);
		System.out.println("\nSum of all digits from position " + range[0] + " to " + range[1] + " is: " + sum);
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
	static double[] fillArray(int sqnceLength) {
		double[] arr = new double[sqnceLength];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < sqnceLength; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		System.out.println("Fibonacci row is: ");
		arrayToString(arr);
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
		int[] range = { x, y };
		Arrays.sort(range); // sorts values ascending
		System.out.print("\nRandom generated numbers are: ");
		arrayToString(range);
		return range;
	}

	/**
	 * 
	 * @param range
	 *            - X,Y
	 * @param arrOfNumbers
	 *            - sequence of numbers
	 * @return sum of elements from X, to Y
	 */
	static double findSum(int[] range, double[] arrOfNumbers) {
		//correct first and last index to start count from 1
		int indX = range[0]-1;
		int indY = range[1]-1;
		
		double sum = arrOfNumbers[indX] + arrOfNumbers[indX + 1];
		indX++;
		for (; indX < indY; indX++) {
			sum = sum + arrOfNumbers[indX + 1];
		}
		return sum;
	}
	
	/**
	 * Prints Fibonacci sequence
	 * @param arr
	 */
	static void arrayToString(double[] arr) {
		System.out.println();
		for (double i : arr) {
			System.out.print(i + " ");
		}
	} 
	
	/**
	 *	Prints X, Y. 
	 * @param arr
	 */
	static void arrayToString(int[] arr) {
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
