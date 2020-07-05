package TIL_0705;
import java.util.*;

public class Subset {
	static char[] arr = {'A', 'B', 'C'};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		System.out.println("Subset");
		Subset(new boolean[arr.length], 0);
	}//end of main

//	private static void 
	
	private static void Subset(boolean[] ans, int idx) {
		if(idx==ans.length) {
			for(int i=0; i<idx; i++) {
				if(!ans[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		ans[idx] = true;
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}//end of method1 : Subset
	
}//end of class
