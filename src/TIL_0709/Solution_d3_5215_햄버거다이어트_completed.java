package TIL_0709;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트_completed {
	static int[] taste, cal;
	static int M, L, sum_t, sum_c, max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			M = sc.nextInt();
			L = sc.nextInt();
			taste = new int[M];
			cal = new int[M];
			for(int i=0; i<M; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			max = 0;
			Subset(new boolean[M], 0);
			System.out.println("#" + t + " " + max);

		}
	}//end of main
	
	private static void Subset(boolean[] ans, int idx) {
		if(idx==ans.length) {
			sum_t = 0;
			sum_c = 0;
			for(int i=0; i<ans.length; i++) {
				if(!ans[i]) {
					sum_t += taste[i];
					sum_c += cal[i];
					
				}
			}
			if(sum_c<L && sum_t>=max) {
				max = sum_t;
			}
			return;
		}
		ans[idx] = true;
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}//end of method : Subset

}//end of class