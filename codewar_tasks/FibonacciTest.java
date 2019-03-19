package codewar_tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FibonacciTest {

/*
 * Получить от пользователя на вход число N
 * Записать в массив ряд Фибоначчи длиной N
 * Сгенерировать 2 случайных числа (X, Y) в пределах N
 * Посчитать сумму всех чисел из сохраненного массива, имеющие индекс от X до Y (включительно)
 */
	
	public static void main(String[] args) {
		int sqnceLength = readN();
		double[] arr = fillArray(sqnceLength);
		int[] range = generateRange(sqnceLength);
		double sum = findSum(range, arr);
		System.out.println("\n Sum of all digits from position "+range[0]+" to "+range[1]+" is= "+sum);
	}
	
	
	static int readN(){
		String input=null;
		int num;
		System.out.println("Enter lenght of sequence: "); 
		try{
			@SuppressWarnings("resource")
			Scanner keyb = new Scanner(System.in);
			input = keyb.next();
		}catch(Exception e){
			System.err.println("Error in readNumber: "+e);
		}
		//check input for non digit and min available value
		try{
			num=Integer.parseInt(input);
			if(num<2||num>100){
				System.out.println("Incorrect input. Value should be > 2 and < 100");
				System.exit(1);
			}
		}catch (NumberFormatException e){
			System.out.println(e.getMessage()+ "\n Incorrect input. Expected input - digit");
			System.exit(1);
		}
		return Integer.parseInt(input); 
	}
	
	static double[] fillArray(int n){
		double[] arr = new double[n];
		arr[0]=0;
		arr[1]=1;
		for(int i=2; i<n; i++){
			arr[i] = arr[i-1]+arr[i-2];
			}
		
		System.out.println("Sequence is: ");
		arrayToString(arr);
		return arr;
		
	}
	
	static int[] generateRange(int n){
		int indx1=0;
		int indx2=0;
		Random randomGenerator = new Random();
		while(indx1==indx2){						//generates two values from range n
			indx1 = randomGenerator.nextInt(n);
			indx2 = randomGenerator.nextInt(n);
		}
		int[] range = {indx1,indx2};
		Arrays.sort(range);							//sorts values ascending 
		System.out.print("\nrandom generated values are: ");
		arrayToString(range);
		return range;
	}
		
	static double findSum(int[] range, double[] arr){
		int a1 = range[0];
		int a2 = range[1];
		double sum=arr[a1]+arr[a1+1];
		a1++;
		for(;a1<a2;a1++){
			sum=sum+arr[a1+1];
			}
		return sum;
	}
	
	static void arrayToString(double[] arr){
		System.out.println();
		for(double i:arr){
			System.out.print(i+" ");
		}
	}
	
	static void arrayToString(int[] arr){
		System.out.println();
		for(int i:arr){
			System.out.print(i+" ");
		}
	}
}
