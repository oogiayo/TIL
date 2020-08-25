package TIL_0825;
import java.util.*;

public class Main_bj_1890_점프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		long[][] ans = new long[N][N];
		ans[0][0] = 1;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(ans[r][c]!=0 && map[r][c]!=0) {
					int nr = r + map[r][c];
					int nc = c + map[r][c];
					if(nr < N) ans[nr][c] += ans[r][c];
					if(nc < N) ans[r][nc] += ans[r][c];
				}
			}
		}
		System.out.println(ans[N-1][N-1]);
	}
}
	
