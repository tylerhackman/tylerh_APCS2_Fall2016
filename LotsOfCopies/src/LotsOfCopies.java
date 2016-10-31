import java.util.Arrays;

public class LotsOfCopies {
	public static void main (String[] args) {
		int num = 7;
		String strMain = "APCS";
		int [] arrMain = {1, 2, 3, 4, 5};
		/*int [] arrMain2 =arrMain;
		for (int i = 0; i < arrMain.length; i++){
			arrMain[i] = i+2;
		}
		System.out.println(Arrays.toString(arrMain2));
		System.out.println(Arrays.toString(arrMain));
		*/
		String strMain2 = strMain;
		strMain = "APCS2";
		System.out.println(strMain2);
		System.out.println(strMain);
	}
public static void changeMe(int x, String str, int[] arr){
	
}
}
