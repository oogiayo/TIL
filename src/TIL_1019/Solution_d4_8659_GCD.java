package TIL_1019;
import java.util.*;

public class Solution_d4_8659_GCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int K = sc.nextInt();
			int a = 1;
			L: while(true) {
				for(int b=0; b<a; b++) {
					int n = GCD(a, b, 0);
					if(n==K) {
						System.out.println("#" + t + " " + a + " " + b);
						break L;
					}
				}
				a++;
			}
		}
	}
	
	private static int GCD(int a, int b, int n) {
		if(b==0) {
			return n;
		}
		else {
			return GCD(b, a%b, n+1);
		}
	}
}
