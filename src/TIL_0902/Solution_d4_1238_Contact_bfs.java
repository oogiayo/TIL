package TIL_0902;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_1238_Contact_bfs {
	
	static class Position {
		int now; int cnt;
		public Position(int now, int cnt) {
			this.now = now;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int p0 = sc.nextInt();
			
			Queue<Position> q = new LinkedList<>();
			int[][] network = new int[101][101];
			boolean[] visited = new boolean[101];
			visited[p0] = true;
			
			for(int i=0; i<N/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				network[a][b] = 1;
				
				if(a==p0) {
					q.add(new Position(b, 1));
					visited[b] = true;
				}
			}
			int max_num = 0;
			int max_cnt = 0;
			while(!q.isEmpty()) {
				Position p = q.poll();
				for(int next=1; next<=100; next++) {
					if(network[p.now][next]==1 && visited[next]==false) {
						visited[next] = true;
						q.add(new Position(next, p.cnt+1));
					}
				}
				if(p.cnt > max_cnt) {
					max_cnt = p.cnt;
					max_num = p.now;
				}
				else if(p.cnt==max_cnt && p.now > max_num) max_num = p.now;
			}
			System.out.println("#" + t + " " + max_num);
		}
		
	}//end of main
}//end of class
