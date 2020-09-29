package TIL_0925;
import java.util.*;
	
public class 좋은아침 {
	static char[] arr = {'A', 'B', 'C'};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		System.out.println("<Subset>");
		subset(new boolean[arr.length], 0);
		System.out.println();
		
		System.out.println("<Permutation>");
		permutation(new char[arr.length], 0);
		
	}
	private static void permutation(char[] ans, int idx) {
		if(idx==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				ans[idx] = arr[i];
				visited[i] = true;
				permutation(ans, idx+1);
				visited[i] = false;
			}
		}
	}

	private static void subset(boolean[] ans, int idx) {
		if(idx==ans.length) {
			for(int i=0; i<idx; i++) {
				if(ans[i]) {
				System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		ans[idx] = true;
		subset(ans, idx+1);
		ans[idx] = false;
		subset(ans, idx+1);
	}
}


