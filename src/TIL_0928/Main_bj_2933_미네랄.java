package TIL_0928;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bj_2933_미네랄 {
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	// 상,좌,우  + 하
	
	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int R = sc.nextInt();
		int C = sc.nextInt();
		String[][] map = new String[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = sc.next();
			}
		}
		Queue<Pair> q = new LinkedList<>();
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int h = sc.nextInt();
		}
		 	
		while(!q.isEmpty()) {
			Pair p = q.poll();
			map[p.r][p.c] = ".";
			for(int k=0; k<3; k++) {
				
			}
			
		}
		
	}
}
