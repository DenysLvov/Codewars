package codewar_tasks;

import java.util.Arrays;

public class HighestAndLowest {

	static String s1 ="1 2 3 4 5"; // return "5 1"
	static String s2 = "1 2 -3 4 5"; // return "5 -3"
	static String s3 = "1 9 3 4 -5"; // return "9 -5"
	static String s4 = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
	
	public static void main(String[] args) {
		System.out.println(highAndLow(s4));
	}
	
	public static String highAndLow(String numbers) {
		String s[] = numbers.split(" ");
		int intArr[] = new int[s.length];
		int i=0;
			for(String str:s){
				intArr[i] = Integer.valueOf(str);
				i++;				
			}
			Arrays.sort(intArr);
			String output = ""+intArr[intArr.length-1] + " "+ intArr[0]; 			
		    return output;
		  }
}
