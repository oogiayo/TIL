package TIL_0724;
import java.util.Scanner;

public class Solution_d3_3975_승률비교 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			double win_rateA = (double)A/B;
			double win_rateB = (double)C/D;
			
			if(win_rateA > win_rateB) {
				System.out.println("#" + t + " ALICE");
			}
			else if(win_rateA < win_rateB) {
				System.out.println("#" + t + " BOB");
			}
			else {
				System.out.println("#" + t + " DRAW");
			}

		}
	}
}
