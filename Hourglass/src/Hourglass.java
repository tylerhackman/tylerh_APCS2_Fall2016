
public class Hourglass {

	public static void main(String[] args) {
		printBase(); //Print the first line
		topHalf(); //Print the top half
		printMiddle(); //Print the middle
		bottomHalf();//Print the bottom half
		printBase();//Print the last line
	}

	public static void topHalf(){
		int colonDecrease = 0;
		for (int i=1; i <=4; i++){//print each line
			//print spaces
			for (int j=1; j<=i; j++){
				System.out.print(" ");
			}
			System.out.print("\\");
			for (int j=4; j> colonDecrease; j--) { 
				System.out.print("::");
			}
			System.out.println("/");
			colonDecrease++;
		}
	}
	public static void printMiddle(){
		System.out.println("     ||");
	}
	public static void printBase(){
		System.out.print("|");
		for (int i = 1; i<=10;i++){
			System.out.print("\"");
		}
		System.out.println("|");
	}
	public static void bottomHalf(){
		int colonIncrease = 4;
		for (int i=4; i >=1; i--){//print each line
			//print spaces
			for (int j=1; j<=i; j++){
				System.out.print(" ");
			}
			System.out.print("/");
			for (int j=4; j >= colonIncrease; j--) { 
				System.out.print("::");
			}
			System.out.println("\\");
			colonIncrease--;
		}
	}
}


