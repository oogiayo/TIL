package TIL_0720;
import java.util.*;

public class Solution_d3_2806_퀸 {
	static int[][] map;
	static int[] dr = {-1,-1,-1};
	static int[] dc = {-1,0,1};
	static int N, sum, cnt;
	
	static class Pair {	
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			sum= 0;
			cnt = 0;
			Permutation(map, 0);
			System.out.println("#" + t + " " + sum);
//			
		}
	}//end of main
	
	private static void Permutation(int[][] ans, int idx) {
		if(idx==N) {
			sum++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			boolean check = true;
			if(ans[idx][c]==0) {
				for(int k=0; k<3; k++) {
					int nr = idx + dr[k];
					int nc = c + dc[k];
					if(0<=nr && nr<N && 0<=nc && nc<N && ans[nr][nc]==1) {
						check = false;
					}
				}
				if(check==true) {
					ans[idx][c] = 1;
					int num = 1;
					for(int i=idx+1; i<N; i++) {
						ans[i][c]+=2;
						int[] dx = {-num, num};
						for(int k=0; k<2; k++) {
							int n_c = c + dx[k];
							if(0<=n_c && n_c<N) {
								ans[i][n_c]+=2;
							}
						}
						num++;
					}
					cnt++;
					Permutation(ans, idx+1);
					ans[idx][c] = 0;
					num = 1;
					for(int i=idx+1; i<N; i++) {
						ans[i][c]-=2;
						int[] dx = {-num, num};
						for(int k=0; k<2; k++) {
							int n_c = c + dx[k];
							if(0<=n_c && n_c<N) {
								ans[i][n_c]-=2;
							}
						}
						num++;
					}
					cnt--;
				}
			}
		}
		
	}//end of method : Permutation
	
}//end of class
