package TIL_0805;
import java.util.*;

public class java_subset {
	static int[] arr = {1, 2, 3};
	static boolean[] isSelected = new boolean[arr.length];
	static int totalCnt;
	
	public static void main(String[] args) {
		totalCnt = 0;
		System.out.println("[Subset]");
		subset(0);
		System.out.println("Total :" + totalCnt);
	}//end of main
		
	private static void subset(int idx) {
		if(idx==arr.length) {
			totalCnt++;
			for(int i=0; i<idx; i++) {
				System.out.print(isSelected[i]? arr[i] : "-");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		isSelected[idx] = true;
		subset(idx+1);
		isSelected[idx] = false;
		subset(idx+1);
		
	}
}//end of class
