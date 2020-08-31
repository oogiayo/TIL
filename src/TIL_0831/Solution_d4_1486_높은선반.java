package TIL_0831;
import java.util.Scanner;

public class Solution_d4_1486_높은선반 {
	static int[] height;
	static int N, B, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];
			min = 0;
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
				min += height[i];
			}
			findMin(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	private static void findMin(int idx, int sum) {
		if(sum >= B) {
			if(sum-B < min) {
				min = sum - B;
			}
			return;
		}
		if(idx==N) {
			return;
		}
		findMin(idx+1, sum+height[idx]);
		findMin(idx+1, sum);
	}
}
