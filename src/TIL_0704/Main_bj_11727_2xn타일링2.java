package TIL_0704;
import java.util.*;

public class Main_bj_11727_2xn타일링2 {
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		memo[1] = 1;
		if(n>1) memo[2] = 3;
		System.out.println(TopDown(n));
	}//end of main

	private static int TopDown(int n) {
			if(memo[n]==0) {
				memo[n] = (2*TopDown(n-2) + TopDown(n-1))%10007;
			}
			return memo[n];
	}//end of method : TopDown
	
}//end of class
