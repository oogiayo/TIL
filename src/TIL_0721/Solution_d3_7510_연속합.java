package TIL_0721;
import java.util.*;

public class Solution_d3_7510_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int cnt = 1;
			for(int i=1; i<N/2+1; i++) {  
				int next = i;
				int n = N - i;
				while(n > 0) {
					next++;
					n -= next;
				}
				if(n == 0) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
				
		}
	}//end of main
}//end of class
