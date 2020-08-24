package TIL_0824;
import java.util.*;

public class op_Main_bj_14499_주사위굴리기 {
	static int[] dc = {1,-1,0,0};
	static int[] dr = {0,0,-1,1};
	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		Queue<Pair> q = new LinkedList<>();
//		q.add(new Pair(x, y));
		for(int i=0; i<K; i++) {
			int k = sc.nextInt();
			
			
			
		}
		
		
		
	}
}
