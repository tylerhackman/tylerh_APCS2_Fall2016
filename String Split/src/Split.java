import java.util.Arrays;

public class Split {

	public static void main(String[] args) {
		// String.split();
		// It's a method that acts on a string, <StringName>.split(<String sp>);
		// Where sp is the string where the string splits
		// And it returns an array
		// Example: "I like apples!".split(" ");
		// it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		// it will split at the word "really" and return an array of ["I ","
		// like "," apples!"]

		// play around with String.split! what happens if you "I reallyreally
		// like apples".split("really") ?

		// Your task:
		/*
		 * Write a method that take in a string like
		 * "applespineapplesbreadlettucetomatobaconmayohambreadcheese"
		 * describing a sandwich use String.split to split up the sandwich by
		 * the word "bread" and return what's in the middle of the sandwich and
		 * ignores what's on the outside What if it's a fancy sandwich with
		 * multiple pieces of bread?
		 */

		// Not a sandwich
		//sandwichSplit("breadbreadbreadbreadbreadbreadbread");
		//sandwichSplit("bread");
		//sandwichSplit("cheesebreadbread");
		//sandwichSplit("");
		
		// Sandwiches
		//sandwichSplit("applespineapplesbreadlettucetomatobaconmayohambreadcheese");
		//sandwichSplit("breadcheesebread");
		sandwichSplit("ham");

		// Your task pt 2:
		/*
		 * Write a method that take in a string like
		 * "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
		 * describing a sandwich use String.split to split up the sandwich at
		 * the spaces, " ", and return what's in the middle of the sandwich and
		 * ignores what's on the outside Again, what if it's a fancy sandwich
		 * with multiple pieces of bread?
		 */

		// Not a sandwich
		 //sandwichSplitBySpaces("bread bread");
		// sandwichSplitBySpaces("bread ");
		// sandwichSplitBySpaces("");
		// sandwichSplitBySpaces(" ");
		// sandwichSplitBySpaces("cheese bread bread");
		 
		// Sandwiches
		// sandwichSplitBySpaces("apples pineapples bread lettuce tomato bacon mayo ham bread cheese");
		 //sandwichSplitBySpaces("bread cheese bread");
		 //sandwichSplitBySpaces("bacon bread cheese bread");
		 sandwichSplitBySpaces("bread bread cheese bread bread");
		 //sandwichSplitBySpaces("bread cheese bread bacon");

	}

	public static void sandwichSplit(String x) {
		if (x.indexOf("bread") >= 0) {
			if (x.lastIndexOf("bread") != x.indexOf("bread") + 5) {
				if (x.lastIndexOf("bread") != x.indexOf("bread")) {
					String y = x.substring(x.indexOf("bread") + 5, x.lastIndexOf("bread"));
					System.out.println(y);
					String[] s = y.split("bread");
					if (s.length > 0) {
					   System.out.println(Arrays.toString(s));
					}
					else {
					   System.out.println("This is not a sandwich");
					}
				}
				else {
					System.out.println("This is not a sandwich");
				}
			}
			else {
				System.out.println("This is not a sandwich");
			}
		}
		else {
		System.out.println("This is not a sandwich");
		}
	}
	

	public static void sandwichSplitBySpaces(String x) {
		if (x.indexOf("bread") >= 0) {
			if (x.lastIndexOf("bread") != x.indexOf("bread") + 6) {
				if (x.lastIndexOf("bread") != x.indexOf("bread")) {
					String y = x.substring(x.indexOf("bread") + 6, x.lastIndexOf("bread"));
					String[] s = y.split(" ");
					System.out.println(y);
					if (s.length > 0) {
					   System.out.println(Arrays.toString(s));
					}
					else {
					   System.out.println("This is not a sandwich");
					}
				}
				else {
					System.out.println("This is not a sandwich");
				}
			}
			else {
				System.out.println("This is not a sandwich");
			}
		}
		else {
		System.out.println("This is not a sandwich");
		}
	}
}
