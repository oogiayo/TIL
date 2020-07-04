package bj;
import java.util.*;

public class Main_bj_11726_2xn타일링 {
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		Pibonacci(n);
		System.out.println(memo[n]);
		
	}//end of main
	
	private static void Pibonacci(int n) {
		for(int i=1; i<=n; i++) {
			if(i<=3) {
				memo[i] = i;
			}
			else {
				memo[i] = (memo[i-1] + memo[i-2])%10007;				
			}
		}
	}//end of method : Pibonacci
	
}//end of class
