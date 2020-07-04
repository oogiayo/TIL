package TIL_0704;
import java.util.*;

public class Main_bj_1463_1만들기 {
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1];
		DP(N);
	}//end of main
	
	private static void DP(int n) {
		for(int i=2; i<=n; i++) {
			memo[i] = memo[i-1]+1;
			if(i%2==0 && memo[i]>memo[i/2]+1) {
				memo[i] = memo[i/2]+1;
			}
			if(i%3==0 && memo[i]>memo[i/3]+1) {
				memo[i] = memo[i/3]+1;
			}
		}
		System.out.println(memo[n]);
	}//end of method : DP
	
}//end of class
