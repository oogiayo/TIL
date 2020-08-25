package TIL_0825;
import java.util.Scanner;

public class Main_bj_11048_TopDown {
	static int[][] map, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		ans = new int[N][M];
		ans[0][0] = map[0][0];
//		System.out.println(topDown(N-1, M-1));
	}//end of main


//	private static int topDown(int r, int c) {
//		if(r < 0 || c < 0) return 0;
//		else {
//			if(ans[r][c] > 0) {
//				return ans[r][c];
//			}
//			else {
//				int new_ans = Math.max(topDown(r-1, c), topDown(r, c-1));
//				if(new_ans > ans[r][c])
//				return ans[r][c];
//			}
//		}
//		if(r < 0 || c < 0) return 0;
//		if(r==0 && c==0) {
//			ans[0][0] = map[0][0];
//			return ans[0][0];
//		}
//		if(ans[r][c] > 0) return ans[r][c];
//		else {
//			int max = Math.max(topDown(r-1, c), topDown(r, c-1)) + map[r][c];
//			if(max > ans[r][c]) {
//				ans[r][c] = max;
//				return ans[r][c];
//			}
//			else return 0;
//		}
//	}
}
