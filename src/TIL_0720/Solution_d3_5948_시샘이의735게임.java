package TIL_0720;
import java.util.*;

public class Solution_d3_5948_시샘이의735게임 {
	static int[] arr = new int[7];
	static int[] case_arr = new int[35];
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			for(int i=0; i<7; i++) {
				arr[i] = sc.nextInt();
			}
			cnt = 0;
			System.out.print("#" + t);
			Combination(new int[3], 0, 0);
			Arrays.sort(case_arr);
			int check = 0;
			for(int i=34; i>0; i--) {
				if(case_arr[i]>case_arr[i-1]) {
					check++;
				}
				if(check==5) {
					System.out.print(" " + case_arr[i]);
					break;
				}
			}
			System.out.println();
		}//end of tc
	}//end of main
	
	private static void Combination(int[] ans, int idx, int r) {
		if(r==ans.length) {
			int sum = 0;
			for(int i=0; i<ans.length; i++) {
				sum += ans[i];
			}
			case_arr[cnt] = sum;
			cnt++;
			return;
		}
		if(idx==arr.length) {
			return;
		}
		Combination(ans, idx+1, r);
		ans[r] = arr[idx];
		Combination(ans, idx+1, r+1);
	}
	
}//end of class
