package TIL_0806;
import java.util.*;

public class Main_bj_3190_¹ì {
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pair {
		int r; int c; int direct; int head; int time;
		public Pair(int r, int c, int direct, int head, int time) {
			this.r = r;
			this.c = c;
			this.direct = direct;
			this.head = head;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[N][N];
		arr[0][0] = 1; // snake
		for(int i=0; i<K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			arr[r][c] = 2; // apple
		}
		int L = sc.nextInt();
		String[] rotate = new String[10001];
		for(int i=0; i<L; i++) {
			int X = sc.nextInt();
			rotate[X] = sc.next();
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 3, 1, 0));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int nr = p.r + dr[p.direct];
			int nc = p.c + dc[p.direct];

			if(0<=nr && nr<N && 0<=nc && nc<N) {
				if(arr[nr][nc]==1) {
					System.out.println(p.time+1);
					break;
				}
				if(arr[nr][nc]==2) {
					arr[nr][nc] = 1;
					q.add(new Pair(nr, nc, p.direct, 1, p.time + 1));
					q.add(new Pair(p.r, p.c, p.direct, 0, p.time + 1));
				}
				else if(arr[nr][nc]==0) {
					arr[nr][nc] = 1;
					arr[p.r][p.c] = 0;
					q.add(new Pair(nr, nc, p.direct, 1, p.time + 1));
				}
				else if(arr[nr][nc]==1 && p.head==0) {
					q.add(new Pair(p.r, p.c, p.direct, 0, p.time + 1));
				}
			}
			else if(nr==0 || nr==N || nc==0 || nc==N){
				System.out.println(p.time+1);
				break;
			}
		}
		
		
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(arr[r]));
		}	
		
		
		
		
	}//end of main
}//end of class
