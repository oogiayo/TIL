package bj;
import java.util.*;

public class Main_bj_7569_토마토2_미완성 {
	static int[][][] box;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] dz = {0,-1,1};
	
	static class Pair {
		int r; int c; int z; int date;
		public Pair(int r, int c, int z, int date) {
			this.r = r;
			this.c = c;
			this.z = z;
			this.date = date;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		box = new int[N][M][H];
		int ans = -1;
		int cnt = 0;
		int unripe = 0;
		Queue<Pair> q = new LinkedList<>();
		for(int z=0; z<H; z++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
						box[r][c][z] = sc.nextInt();
						if(box[r][c][z] != 0) {
							cnt++;
							if(box[r][c][z] == 1) q.add(new Pair(r, c, z, 0));
						}
						else unripe++;
				}
			}
		}//end of input
		if(cnt==N*M*H) {
			ans = 0;
		}
		else {
			while(!q.isEmpty()) {
				Pair p = q.poll();
				ans = p.date;
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<N && 0<=nc && nc<M && box[nr][nc][p.z]==0) {
						box[nr][nc][p.z] = 1;
						q.add(new Pair(nr, nc, p.z, p.date+1));
						unripe--;
					}
				}
				for(int l=0; l<2; l++) {
					int nz = p.z + dz[l];
					if(0<=nz && nz<H && box[p.r][p.c][nz]==0) {
						box[p.r][p.c][nz] = 1;
						q.add(new Pair(p.r, p.c, nz, p.date+1));
						unripe--;
					}
				}
			}
			if(unripe!=0) ans = -1;
		}
		System.out.println(ans);
	}//end of main
	
}//end of class
