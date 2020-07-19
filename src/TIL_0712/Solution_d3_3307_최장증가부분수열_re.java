package TIL_0712;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] ans = new int[N];
			for(int i=0; i<N; i++) {
				ans[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[j]<arr[i] && ans[i]<ans[j]+1) ans[i] = ans[j]+1;
				}
			}
			Arrays.sort(ans);
			System.out.println("#" + t + " " + ans[N-1]);
		}//end of tc
	}//end of main
	
}//end of class
