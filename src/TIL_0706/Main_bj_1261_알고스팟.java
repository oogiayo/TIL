package TIL_0706;
import java.util.*;

public class Main_bj_1261_알고스팟 {
	static int[][] maze;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pair {
		int r; int c; int brk;
		public Pair(int r, int c, int brk) {
			this.r = r;
			this.c = c;
			this.brk = brk;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		maze = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<M; c++) {
				maze[r][c] = str.charAt(c)-'0';
			}
		}//end of input
		
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, 0, 0));
		maze[0][0] = 2;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr<N && 0<=nc && nc<M && maze[nr][nc]==0) {
					maze[nr][nc] = 2;
					q.addFirst(new Pair(nr, nc, p.brk));
				}
				if(0<=nr && nr<N && 0<=nc && nc<M && maze[nr][nc]==1) {
					maze[nr][nc] = 2;
					q.addLast(new Pair(nr, nc, p.brk+1));
				}
			}
			if(maze[N-1][M-1]==2) {
				System.out.println(p.brk);
				break;
			}
		}//end of BFS
	}//end of main
	
}//end of class
