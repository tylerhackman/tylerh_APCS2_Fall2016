
public class Calculate {
	
	public static int square(int number) {
		return(number * number);
	}	
	public static int cube(int number) {
		return(number * number * number);
	}
	public static double average(double number, double number2) {
		return ((number + number2)/2);
	}
	public static double average(double number, double number2, double number3) {
		return ((number + number2 + number3)/3);
	}
	public static double toDegrees(double number) {
		return ((number * 180)/3.14159);
	}
	public static double toRadians(double number) {
		return ((number * 3.14159)/180);
	}
	public static double discriminant(double a, double b, double c) {
		return ((b * b)-(4 * a * c));
	}
	public static String toImproperFrac(int number, int number2, int number3) {
		 
		return "" + ((number * number3) + number2) + "/" + number3;
		
	}
	public static String toMixedNum(int number, int number2) {
		return "" + (number/number2) + "_" + (number%number2) +"/" + number2;
	}
	public static String foil(int number, int number2, int number3, int number4, String variable) {
		return "" + (number3 * number) + variable + "^2 + "  + (number * number) + variable + " - " + (number4 * number2);
	}
	public static boolean isDivisibleBy(int number, int number2) {
		
		if ((number%number2) == 0) {
			return true;
		}
			else {
			return false;
		 }		
	}
	public static double absValue(double number) {
		if (number < 0) {
			return (number * -1);
		}
		else { 
			return (number);
		}
	}
    public static int max(int number, int number2) {
    	if (number > number2) {
    		return (number);
    	}
    	else {
    		return (number2);	
    	}
    }
    public static int min(int number, int number2) {
    	if (number < number2) {
    		return (number);
    	}
    	else {
    		return (number2);	
    	}
    }
    public static int max(int number, int number2, int number3) {
    	if ((number > number2) && (number > number3)) {
    		return (number);
    	}
    	else {
    		if ((number2 > number) && (number2 > number3)) {		
    			return (number2);
    		}
    		else {
    			return (number3);
    		}
    	}
    }
    public static double round2(double number) {
    	
    	double x = (number*100);
    	int y = (int) x;
    	double ans = (double) y/100;
    	return ans;

    }
}

