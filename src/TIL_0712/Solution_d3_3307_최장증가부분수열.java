package TIL_0712;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열 {
	static int N, max;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			max = 0;
			Subset(new boolean[N], 0);
			System.out.println("#" + t + " " + max);
		}//end of tc
	}//end of main
	
	private static void Subset(boolean[] ans, int idx) {
		if(idx==ans.length) {
			int cnt = 0;
			ArrayList<Integer> check = new ArrayList<>();
			for(int i=0; i<idx; i++) {
				if(!ans[i]) { 
					check.add(arr[i]);
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			for(int j=0; j<check.size()-1; j++) {
				if(check.get(j) >= check.get(j+1)) {
					cnt = -1;
					break;
				}
			}
			if(cnt==0) cnt = check.size();
			if(cnt > max) max = cnt;
			return;
			}
		ans[idx] = true;
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}//end of method : Subset
	
}//end of class
