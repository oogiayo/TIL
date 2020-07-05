package TIL_0705;
import java.util.*;

public class fail_Main_bj_2206_벽부수고이동 {
	static int[][] map, dist;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
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
		map = new int[N][M];
		dist = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<str.length(); c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		int chance = 1;
		int numbering = 2;
		int finish = 0;
		Queue<Pair> q = new LinkedList<>();
		int cnt = 0;
		for(int i=0; i<2; i++) {
			
			map[(N-1)*i][(M-1)*i] = numbering+i;
			dist[(N-1)*i][(M-1)*i] = cnt+1;

			q.add(new Pair((N-1)*i, (M-1)*i));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.r==(N-1)*(1-i) && p.c==(M-1)*(1-i)) {
					finish++;
					System.out.println(dist[N-1][M-1]);
					break;
				}
				
				for(int k=0; k<4; k++) {
					int check = 0;
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==0) {
						map[nr][nc] = numbering+i;
						dist[nr][nc] = dist[p.r][p.c]+1;
						check++;
						q.add(new Pair(nr, nc));
					}
				}
				if(i==1 && chance==1 && q.isEmpty()) {
					for(int j=0; j<4; j++) {
						int wr = p.r + dr[j];
						int wc = p.c + dc[j];
						if(0<=wr && wr<N && 0<=wc && wc<M && map[wr][wc]==1) {

							
							for(int l=0; l<4; l++) {
								int nnr = wr + dr[l];
								int nnc = wc + dc[l];
								
								if(0<=nnr && nnr<N && 0<=nnc && nnc<M && map[nnr][nnc]==2) {
									finish++;
									map[nnr][nnc] = 3;
									map[wr][wc] = 3;
//									dist[wr][wc] = dist[p.r][p.c]+1;
									chance--;
//									System.out.println(dist[wr][wc]);
									q.add(new Pair(wr, wc));
									break;
								}
							}
						}
					}
				}
				cnt = dist[p.r][p.c];
			}
		}
		if(finish==0) System.out.println(-1);
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
		
	}//end of main
}//end of class
