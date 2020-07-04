package TIL_0703;
import java.util.*;

public class Main_bj_1697_숨바꼭질 {
	static int N, K;
	static boolean[] visited = new boolean[100001];
	static int[] dx;
	
	static class Position {
		int x; int sec;
		public Position(int x, int sec) {
			this.x = x;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(N, 0));
		visited[N] = true;
		while(!q.isEmpty()) {
			Position p = q.poll();
			if(p.x == K) System.out.println(p.sec);
			
			dx = new int[] {-1, 1, p.x};
			for(int k=0; k<3; k++) {
				int nx = p.x + dx[k];
				if(0<=nx && nx<=100000 && visited[nx]==false) {
					visited[nx] = true;
					q.add(new Position(nx, p.sec+1));
				}
			}
		}
		 
	}//end of main
}//end of class
