package TIL_0828;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d4_ladder2 {
	static int[] dr = {0,0,-1};
	static int[] dc = {-1,1,0};
	static class Pair {
		int r; int c; int side; int cnt;
		public Pair(int r, int c, int side, int cnt) {
			this.r = r;
			this.c = c;
			this.side = side;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			String trash = bf.readLine();
			int[][] ladder = new int[100][100];
			for(int r=0; r<100; r++) {
//				StringTokenizer st = new StringTokenizer(bf.readLine());
				String[] line = bf.readLine().split(" ");
				for(int c=0; c<100; c++) {
					ladder[r][c] = Integer.parseInt(line[c]);
//					ladder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Pair> q = new LinkedList<>();
			for(int c=0; c<100; c++) {
				if(ladder[99][c]==1) {
					q.add(new Pair(99, c, 0, 0));
				}
			}
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.r==0) {
					System.out.println("#" + t + " " + p.c);
					break;
				}
				for(int k=0; k<3; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<100 && 0<=nc & nc<100 && ladder[nr][nc]==1) {
						if(k==0 || k==1) {
							if(p.side!=-dc[k]) {
								q.add(new Pair(nr, nc, dc[k], p.cnt+1));
								break;
							}
							else {
								continue;
							}
						}
						else {
							q.add(new Pair(nr, nc, 0, p.cnt+1));
							break;
						}
					}
				}
			}
		}//end of tc
	}//end of main
}//end of class
