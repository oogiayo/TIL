package TIL_0719;
import java.util.*;

public class Solution_d3_5603_건초더미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int mean = sum/N;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				while(arr[i]!=mean) {
					if(arr[i]<mean) {
						arr[i]++;
						cnt++;
					}
					else {
						arr[i]--;
						cnt++;
					}
				}
			}
			System.out.println("#" + t + " " + cnt/2);
		}
	}//end of main
}//end of class
