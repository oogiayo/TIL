package TIL_0902;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d4_1226_미로1 {
	static int[] dr = {-1,1,0,0,};
	static int[] dc = {0,0,-1,1};
	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t=1; t<=T; t++) {
			bf.readLine();
			int[][] maze = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			Queue<Pair> q = new LinkedList<>();
			
			for(int r=0; r<16; r++) {
				String line = bf.readLine();
				for(int c=0; c<16; c++) {
					maze[r][c] = Integer.valueOf(line.substring(c, c+1));
					if(maze[r][c]==2) q.add(new Pair(r, c));
				}
			}
			int ans = 0;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					
					if(0<=nr && nr<16 && 0<=nc && nc<16 && visited[nr][nc]==false) {
						if(maze[nr][nc]==3) {
							ans = 1;
							break;
						}
						else if(maze[nr][nc]==0) {
							visited[nr][nc] = true;
							q.add(new Pair(nr, nc));
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}//end of tc
		
	}//end of main
}//end of class