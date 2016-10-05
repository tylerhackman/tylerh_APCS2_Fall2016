// Calculate.java Tyler Hackman
public class Calculate {
 
	// squares an integer
	public static int square(int number) {
		return(number * number);
	}	
	// cubes an integer
	public static int cube(int number) {
		return(number * number * number);
	}
	// finds the average of two doubles
	public static double average(double number, double number2) {
		return ((number + number2)/2);
	}
	// finds the average of three doubles
	public static double average(double number, double number2, double number3) {
		return ((number + number2 + number3)/3);
	}
	// converts a double from radians to degrees
	public static double toDegrees(double radians) {
		return ((radians * 180)/3.14159);
	}
	// converts a double from degrees to radians
	public static double toRadians(double number) {
		return ((number * 3.14159)/180);
	}
	// returns the value of the discriminant of three doubles given in standard form (a, b, c)
	public static double discriminant(double a, double b, double c) {
		return ((b * b)-(4 * a * c));
	}
	// converts a mixed number to an improper fraction 
	public static String toImproperFrac(int wholenumber, int numerator, int denominator) {
		return "" + ((wholenumber * denominator) + numerator) + "/" + denominator;
	}
	// converts an improper fraction to a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		return "" + (numerator/denominator) + "_" + (numerator%denominator) +"/" + denominator;
	}
	// multiplies two binomials and returns a quadratic equation in the form ax^2 + bx + c
	public static String foil(int number, int number2, int number3, int number4, String variable) {
		return "" + (number3 * number) + variable + "^2 + "  + (number * number) + variable + " - " + (number4 * number2);
	}
	// tests if an integer is divisible by another integer
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if (numerator == 0 || denominator == 0) {
			throw new IllegalArgumentException("numbers != 0");
		}
		if ((numerator%denominator) == 0) {
			return true;
		}
			else {
			return false;
		 }		
	}
	// returns the absolute value of a given double
	public static double absValue(double number) {
		if (number < 0) {
			return (number * -1);
		}
		else { 
			return (number);
		}
	}
	// calculates and returns the maximum of two integers
    public static int max(int number, int number2) {
    	if (number > number2) {
    		return (number);
    	}
    	else {
    		return (number2);	
    	}
    }
    // calculates and returns the minimum of two integers
    public static int min(int number, int number2) {
    	if (number < number2) {
    		return (number);
    	}
    	else {
    		return (number2);	
    	}
    }
    // calculates and returns the maximum of three integers
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
    // returns a double rounded to two decimal places
    public static double round2(double number) {
    	
    	double x = (number*100);
    	int y = (int) x;
    	double ans = (double) y/100;
    	return ans;

    }
    // calculates and returns the value of a given number put to a given power
    public static double exponent(double base, int exponent) {
    	if (exponent < 0) {
			throw new IllegalArgumentException("exponent must be > 0");
		}
    	double x = 1;
		for (int i = 1; i <= exponent; i++) {
			x = x * base;
		}
		return x;
	}
    // calculates and returns the factorial of a given integer
	public static int factorial(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("number must be >= 0");
		}
		int product = 1;
		for (int i = 2; i <= x; i++) {
			product = product * i;
		}	
		return product;
	}
	// determines if an integer is a prime number
	public static boolean isPrime(int x) {
		for(int i = 2; i < x; i++){
			if(Calculate.isDivisibleBy(x, i) == true) {
				return false;
			}
		}
		return true;
	}
	// finds and returns the greatest common factor of two integers
	public static int gcf(int number, int number2) {
		int y = 1;
		int x = Calculate.max(number, number2);
		for(int i = 1; i < x; i++) {
			if(Calculate.isDivisibleBy(number, i) == true && Calculate.isDivisibleBy(number2, i) == true) {
				y = i;
			}
		}
			return y;
	}
	// returns an approximation of the square root of a given double, rounded to two decimal places
	public static double sqrt(double number) {
		 if (number < 0) {
	        	throw new IllegalArgumentException("number must be >= 0");
		 }
			double x;
			double sqrt = number / 2;
			do {
				x = sqrt;
				sqrt = (x + (number / x)) / 2;
			} while ((x - sqrt) != 0);
			return Calculate.round2(sqrt);
		}
	// uses the coefficients of a given quadratic equation in standard form and uses the quadratic 
	// formula to approximate the real roots, if any
	public static String quadForm(int a, int b, int c) {
		 double ax =a;
		 double bx = b;
		 double cx = c;
		 double dx = 0;
		 double x = Calculate.discriminant(ax, bx, cx);
				 if (x < 0) {
					 return "no real roots";
				 }
				 else {
					 if (x == 0) { 
						 dx = Calculate.round2((-b/(2*a)));
						 return "" + dx;
					 }
				     else {
				    	double firstroot = Calculate.round2(( - b + Calculate.sqrt(x))/(2*a));
				        double secondroot = Calculate.round2((-b - Calculate.sqrt(x))/(2*a)); 
				        if (firstroot < secondroot){
				        return "roots = " + firstroot + " " + secondroot;
						 }
				        else {
				        	return "roots = " + secondroot + " and " + firstroot;
				        }
					 }
	}
}
}