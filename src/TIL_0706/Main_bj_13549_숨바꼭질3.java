package TIL_0706;
import java.util.*;

public class Main_bj_13549_숨바꼭질3 {
	static int[] dx = {0,-1,1};
	static boolean[] visited = new boolean[100001];
	
	static class Pair {
		int x; int sec;
		public Pair(int x, int sec) {
			this.x = x;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(N, 0));
		visited[N] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.x==K) {
				System.out.println(p.sec);
				break;
			}
			for(int k=0; k<3; k++) {
				int nx = p.x + dx[k];
				if(k==0) nx = p.x*2;
				if(0<=nx && nx<=100000 && visited[nx]==false) {
					visited[nx]=true;
					if(k==0) q.addFirst(new Pair(nx, p.sec));
					else q.addLast(new Pair(nx, p.sec+1));
				}
			}
		}//end of Deque BFS
		
	}//end of main
}//end of class
