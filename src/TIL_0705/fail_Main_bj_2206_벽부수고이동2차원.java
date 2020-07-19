package TIL_0705;
import java.util.*;

public class fail_Main_bj_2206_벽부수고이동2차원 {
	static int[][] map, dist;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pair {
		int r; int c; int dist;
		public Pair(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<str.length(); c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		int ans = -1;
		int chance = 1;
		Queue<Pair> q = new LinkedList<>();
		int check = 2;
		for(int i=0; i<2; i++) {
			if(i==0) {
				q.add(new Pair(0, 0, 0));
//				q.add(new Pair(N-1, M-1, 0));
				map[0][0] = 2;
//				map[N-1][M-1] = 2;
			}
			if(i==1) q.add(new Pair(0, 0, 1));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(i==1 && p.r==N-1 && p.c==M-1) {
					ans = p.dist;
					break;
				}
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==0) {
						map[nr][nc] = 2;
						q.add(new Pair(nr, nc, 0));
					}
					if(i==1 && 0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==2) {
						map[nr][nc] = 3;
						q.add(new Pair(nr, nc, p.dist+1));
					}
				}
				if(chance==1 && q.isEmpty()) {
					for(int l=0; l<4; l++) {
						int wr = p.r + dr[l];
						int wc = p.c + dc[l];
						
						if(0<=wr && wr<N && 0<=wc && wc<M && map[wr][wc]==1) {
							for(int m=0; m<4; m++) {
								int nnr = wr + dr[m];
								int nnc = wc + dc[m];
								if(0<=nnr && nnr<N && 0<=nnc && nnc<M && map[nnr][nnc]==0) {
									map[wr][wc] = 2;
									System.out.println("벽부숨");
									q.add(new Pair(wr, wc, p.dist+1));
									chance--;
								}
							}
						}
					}
				}
			}//end of BFS
		}
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println();
		System.out.println(ans);
		
	}//end of main
}//end of class
