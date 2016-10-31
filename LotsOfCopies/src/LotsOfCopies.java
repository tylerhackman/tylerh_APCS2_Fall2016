import java.util.Arrays;
public class LotsOfCopies {
	
	public static void main (String [] args){
	int num = 7;
	String strMain = "APCS";
	int [] arrMain = {1, 2, 3, 4, 5};
	
	int num2 = num;
	String strMain2 = strMain;
	int [] arrMain2 = arrMain;
	
	num = 8;
	strMain = "APCS2";
	for(int i = 0; i < arrMain.length; i++) {
		arrMain[i] = i + 2;
	}
	System.out.println(num2 + " " + strMain2 + " " + Arrays.toString(arrMain2));
	/*
	System.out.println("Old Values In Main: " + num + " " + strMain + " " + Arrays.toString(arrMain));
	changeMe(num, strMain, arrMain);
	System.out.println("New Values In Main: " + num + " " + strMain + " " + Arrays.toString(arrMain));
	*/
	}
	public static void changeMe (int x, String str, int [] arr) {
		x++;
		str = "APCS2";
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 2;
		}
		System.out.println("Changed: " + x + " " + str + " " + Arrays.toString(arr));
	}
}