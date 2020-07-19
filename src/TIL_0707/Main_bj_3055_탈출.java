package TIL_0707;
import java.util.*;

public class Main_bj_3055_탈출 {
	static String[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pair {
		int r; int c; int sec;
		public Pair(int r, int c, int sec) {
			this.r = r;
			this.c = c;
			this.sec = sec;
		}
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		map = new String[R][C];
		int r0 = 0; int c0 = 0;
		int rF = 0; int cF = 0;
		Queue<Pair> q_Water = new LinkedList<>();
		for(int r=0; r<R; r++) {
			String str = sc.next();
			for(int c=0; c<C; c++) {
				map[r][c] = str.split("")[c];
				if(map[r][c]=="S") r0 = r; c0 = c;
				if(map[r][c]=="D") rF = r; cF = c;
				if(map[r][c]=="*") q_Water.add(new Pair(r, c, 0));
			}
		}//end of input
		
		String ans = "KAKTUS";
		
		Queue<Pair> q_S = new LinkedList<>();
		q_S.add(new Pair(r0, c0, 0));
		map[r0][c0] = "P";
		while(!q_S.isEmpty()) {
			Pair p = new Pair(0, 0, 0);
			for(int i=0; i<2; i++) {
				Pair p_Water = q_Water.poll();
				Pair p_S = q_S.poll();
				if(i==0) p = p_Water;
				else p = p_S;
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<R && 0<=nc && nc<C) {
						if(i==0 && (map[nr][nc]=="." || map[nr][nc]=="S")) {
							map[nr][nc] = "*";
							q_Water.add(new Pair(nr, nc, p.sec+1));
						}
						if(i==1 && (map[nr][nc]=="." || map[nr][nc]=="D")) {
							map[nr][nc] = "S";
							q_S.add(new Pair(nr, nc, p.sec+1));
						}
					}
				}
				if(map[rF][cF]=="S") {
					ans = Integer.toString(p.sec+1);
					break;
				}
			}
		}//end of BFS
		System.out.println(ans);
	}//end of main
	
}//end of class
