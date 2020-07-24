package TIL_0723;
import java.util.*;

public class Solution_d3_6485_버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] busstop = new int[5001];
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a; j<b+1; j++) {
					busstop[j]++;
				}
			}
			int P = sc.nextInt();
			System.out.print("#" + t + " ");
			for(int i=0; i<P; i++) {
				int cj = sc.nextInt();
				System.out.print(busstop[cj] + " ");
			}
			System.out.println();
		}//end of tc
	}//end of main
}//end of class