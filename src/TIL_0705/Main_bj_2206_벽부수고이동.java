package TIL_0705;
import java.util.*;

public class Main_bj_2206_벽부수고이동 {
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][][] dist;
	
	static class Pair {
		int r; int c; int stone;
		public Pair(int r, int c, int stone) {
			this.r = r;
			this.c = c;
			this.stone = stone;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M][2];
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<str.length(); c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}//end of input
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		dist[0][0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==0 && dist[nr][nc][p.stone]==0) {
					dist[nr][nc][p.stone] = dist[p.r][p.c][p.stone] + 1;
					q.add(new Pair(nr, nc, p.stone));
				}
				if(p.stone==0 && 0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==1 && dist[nr][nc][p.stone+1]==0) {
					dist[nr][nc][p.stone+1] = dist[p.r][p.c][p.stone] + 1;
					q.add(new Pair(nr, nc, p.stone+1));
				}
			}
		}
		if(dist[N-1][M-1][0]!=0 && dist[N-1][M-1][1]!=0) {
			System.out.println(Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]));
		}
		else if(dist[N-1][M-1][0] == 0 && dist[N-1][M-1][1]==0) {
			System.out.println(-1);
		}
		else System.out.println(Math.max(dist[N-1][M-1][0], dist[N-1][M-1][1]));
		
	}//end of main
}//end of class
