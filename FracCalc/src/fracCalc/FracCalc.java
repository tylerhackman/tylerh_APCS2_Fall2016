// FracCalc.java Tyler Hackman 12/1/2016
package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	//System.out.println("Enter fraction string.");
    	String input = " ";
    	while (!input.equals("quit")) {
        	System.out.println("Enter fraction string.");
    		input = userInput.nextLine();
    		if (!input.equals("quit")) {
    			System.out.println(produceAnswer(input));
    		}
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
    	
    	//Parse input into firstOperand, operator, and secondOperand.
        String firstOperand = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")+ 1)); 
        String secondOperand = input.substring(input.lastIndexOf(" ") + 1);
        
        //Create integer arrays for the parts of each operand.
        int firstOperandArray [] = parseOperand(firstOperand);
        int secondOperandArray [] = parseOperand(secondOperand);
       
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int [] parseOperand(String operand) {
        int whole = 0;
        int numerator = 0;
        int denominator = 1;
        if (operand.indexOf("_") > 0) {
        	whole = Integer.valueOf(operand.substring(0, operand.indexOf("_")));
        }
        else {
        	if (operand.indexOf("/") < 0) {
        		whole = Integer.valueOf(operand);
        	}
        }
        if (operand.indexOf("/") > 0) {
        	numerator = Integer.valueOf(operand.substring(operand.indexOf("_") + 1, operand.indexOf("/")));
        	denominator = Integer.valueOf(operand.substring(operand.indexOf("/") + 1));
        }
        int operandArray [] = new int [] { whole, numerator, denominator};
        return operandArray;
    }
    
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
    	numerator = ((whole * denominator) + numerator);
    	int returnArray[] = new int [] { numerator, denominator};
    	return returnArray;
    }
    
    public static String addFrac(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	numerator1 *= denominator2;
    	numerator2 *= denominator1;
    	denominator1 *= denominator2;
    	numerator1 += numerator2;
    	whole1 += whole2;
    	return whole1 + "_" + numerator1 + "/" + denominator1;
    }
    
    public static String subtractFrac(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	numerator1 *= denominator2;
    	numerator2 *= denominator1;
    	denominator1 *= denominator2;
    	numerator1 -= numerator2;
    	whole1 -= whole2;
    	return whole1 + "_" + numerator1 + "/" + denominator1;
    }
    
    public static String multiplyFrac(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	//Test if each operand is a mixed number, convert to an improper fraction if it is.
    	int newNumerator;
    	int newDenominator;
    	String returnString = "";
    	if(whole1 != 0 && whole2 != 0) {
    		int [] operand1 = toImproperFrac(whole1, numerator1, denominator1);
        	int [] operand2 = toImproperFrac(whole2, numerator2, denominator2);
        	newNumerator = operand1[0] * operand2[0];
        	newDenominator = operand1[1] * operand2[1];
        	returnString =  newNumerator + "/" + newDenominator;
    	}
    	else {
    		if(whole1 != 0 && whole2 == 0) {
        		int [] operand1 = toImproperFrac(whole1, numerator1, denominator1);
            	newNumerator = operand1[0] * numerator2;
            	newDenominator = operand1[1] * denominator2;
            	returnString =  newNumerator + "/" + newDenominator;
        	}
    		else{
    			if(whole2 != 0 && whole1 == 0) {
            		int [] operand2 = toImproperFrac(whole2, numerator2, denominator2);
                	newNumerator = operand2[0] * numerator1;
                	newDenominator = operand2[1] * denominator1;
                	returnString =  newNumerator + "/" + newDenominator;
            	}
    	}
    	if(whole1 == 0 && whole2 == 0) {
    	newNumerator = numerator1 * numerator2;
    	newDenominator = denominator1 * denominator2;
    	returnString =  newNumerator + "/" + newDenominator;
    	}
    }
    	return returnString;
}
    public static String divideFrac(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	//Test if each operand is a mixed number, convert to an improper fraction if it is.
    	int newNumerator;
    	int newDenominator;
    	String returnString = "";
    	if(whole1 != 0 && whole2 != 0) {
    		int [] operand1 = toImproperFrac(whole1, numerator1, denominator1);
        	int [] operand2 = toImproperFrac(whole2, numerator2, denominator2);
        	newNumerator = operand1[0] * operand2[1];
        	newDenominator = operand1[1] * operand2[0];
        	returnString =  newNumerator + "/" + newDenominator;
    	}
    	else {
    		if(whole1 != 0 && whole2 == 0) {
        		int [] operand1 = toImproperFrac(whole1, numerator1, denominator1);
            	newNumerator = operand1[0] * denominator2;
            	newDenominator = operand1[1] * numerator2;
            	returnString =  newNumerator + "/" + newDenominator;
        	}
    		else{
    			if(whole2 != 0 && whole1 == 0) {
            		int [] operand2 = toImproperFrac(whole2, numerator2, denominator2);
                	newNumerator = operand2[0] * denominator1;
                	newDenominator = operand2[1] * numerator1;
                	returnString =  newNumerator + "/" + newDenominator;
            	}
    	}
    	if(whole1 == 0 && whole2 == 0) {
    	newNumerator = numerator1 * denominator2;
    	newDenominator = denominator1 * numerator2;
    	returnString =  newNumerator + "/" + newDenominator;
    	}
    }
    	return returnString;
}
}

