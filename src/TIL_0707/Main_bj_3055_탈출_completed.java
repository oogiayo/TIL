package TIL_0707;
import java.util.*;

public class Main_bj_3055_탈출_completed {
	static String[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pair {
		int r; int c; int sec; String name;
		public Pair(int r, int c, int sec, String name) {
			this.r = r;
			this.c = c;
			this.sec = sec;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		map = new String[R][C];
		int r0 = 0; int c0 = 0;
		int rF = 0; int cF = 0;
		Queue<Pair> q = new LinkedList<>();
		for(int r=0; r<R; r++) {
			String str = sc.next();
			for(int c=0; c<C; c++) {
				map[r][c] = str.substring(c, c+1);
				if(map[r][c].equals("S")) {
					r0 = r;
					c0 = c;
				}
				else if(map[r][c].equals("D")) {
					rF = r;
					cF = c;
				}
				else if(map[r][c].equals("*")) q.add(new Pair(r, c, 0, "*"));
			}
		}//end of input
		String ans = "KAKTUS";
		q.add(new Pair(r0, c0, 0, "S"));
		map[r0][c0] = "P";
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr<R && 0<=nc && nc<C) {
					if(p.name.equals("*") && (map[nr][nc].equals(".") || map[nr][nc].equals("S"))) {
						map[nr][nc] = "*";
						q.add(new Pair(nr, nc, p.sec+1, "*"));
					}
					if(p.name.equals("S") && (map[nr][nc].equals(".") || map[nr][nc].equals("D"))) {
						map[nr][nc] = "S";
						q.add(new Pair(nr, nc, p.sec+1, "S"));
					}
				}
			}
			if(map[rF][cF].equals("S")) {
				ans = Integer.toString(p.sec+1);
				break;
			}
		}//end of BFS
		System.out.println(ans);
	}//end of main
	
}//end of class
