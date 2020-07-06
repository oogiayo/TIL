package TIL_0706;
import java.util.*;

public class TIL_0706_좋은아침 {
	static char[] arr = {'A', 'B', 'C'};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		System.out.println("Subset");
		Subset(new boolean[arr.length], 0);
		
		System.out.println("Permutation");
		Permutation(new char[arr.length], 0);
		
		System.out.println("Repermutation");
		Repermutation(new char[arr.length], 0);
		
		System.out.println("Combination");
		Combination(new char[arr.length-1], 0, 0);
		
		System.out.println("Recombination");
		Recombination(new char[arr.length-1], 0, 0);
	}//end of main
	
	private static void Recombination(char[] ans, int idx, int r) {
		if(r==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx==arr.length) return;
		ans[r] = arr[idx];
		Recombination(ans, idx, r+1);
		ans[r] = arr[idx];
		Recombination(ans, idx+1, r);
	}//end of method : Recombination
	
	private static void Combination(char[] ans, int idx, int r) {
		if(r==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx==arr.length) return;
		ans[r] = arr[idx];
		Combination(ans, idx+1, r+1);
		ans[r] = arr[idx];
		Combination(ans, idx+1, r);
	}//end of method : Combination
	
	private static void Repermutation(char[] ans, int idx) {
		if(idx==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			ans[idx] = arr[i];
			Repermutation(ans, idx+1);
		}
	}//end of method : Repermutation

	private static void Permutation(char[] ans, int idx) {
		if(idx==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[idx] = arr[i];
				Permutation(ans, idx+1);
				visited[i] = false;
			}
		}
	}//end of method : Permutation
	
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
	}//end of method : Subset
	
}//end of class
