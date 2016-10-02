// ProcessingNumbers.java (Collaborative Programming Exercise) Tyler Hackman 9/29/2016
import java.util.*;

public class ProcessingNumbers {
	public static void main(String args []) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many terms will you enter?");
		int terms = userInput.nextInt();
		System.out.println("Enter your " + terms + " integers");
		
		int max = userInput.nextInt();
		int min = max;
		boolean firstEven = true;
		int inputNumber;
		int evenSum = 0;
		int maxEven = 0;
		
		if(min % 2 == 0) {
			evenSum = min;
			maxEven = min;
			firstEven = false;
		}
		for(int i = 1; i < terms; i++) {
			inputNumber = userInput.nextInt();
			if (inputNumber % 2 == 0) {
				if (firstEven == true) {
					maxEven = inputNumber;
					evenSum = inputNumber;
					firstEven = false;
				}
				else {
					if (inputNumber > maxEven) {
						maxEven = inputNumber;
					}
				evenSum += inputNumber;
				}
				if (inputNumber > max) {
				max = inputNumber;
				}
				else {
					if (inputNumber < min) {
					min = inputNumber;
					}
				
				}
			}		
		}
	System.out.println(" ");
	System.out.println("min: " + min + " max: " + max);
	System.out.println("");
	System.out.println("Sum of even numbers: " + evenSum + " Largest even number: " + maxEven);
	userInput.close();	
	}
}


