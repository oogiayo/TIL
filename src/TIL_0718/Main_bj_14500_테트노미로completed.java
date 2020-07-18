package TIL_0718;
import java.util.*;

public class Main_bj_14500_테트노미로completed {
	static int N, M, max;
	static int[][] arr;
	
	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		Queue<Pair> q = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				arr[r][c] = sc.nextInt();
				q.add(new Pair(r, c));
			}
		}
		max = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			flat(p);
			square(p);
			T(p);
			L(p);
			zigzag(p);
		}
		System.out.println(max);
	}//end of main
	
	private static void flat(Pair p) {
		int[] dr = {0,1,2,3, 0,0,0,0};
		int[] dc = {0,0,0,0, 0,1,2,3};
		for(int i=0; i<2; i++) {
			int sum = 0;
			int cnt = 0;
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[i*4+k];
				int nc = p.c + dc[i*4+k];
				if(0<=nr && nr<N && 0<=nc && nc<M) {
					sum += arr[nr][nc];
					cnt++;
				}
			}
			if(cnt==4) {
				if(sum>max) max = sum;
			}
		}
	}//end of method1 : flat
	
	private static void square(Pair p) {
		int[] dr = {0,0,1,1};
		int[] dc = {0,1,0,1};
		int sum = 0;
		int cnt = 0;
		for(int k=0; k<4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];
			if(0<=nr && nr<N && 0<=nc && nc<M) {
				sum += arr[nr][nc];
				cnt++;
			}
		}
		if(cnt==4) {
			if(sum>max) max = sum;
		}	
	}//end of method2 : square
	
	private static void T(Pair p) {
		int[] dr = {0,1,1,2,  0,1,1,2, 0,0,1,0, 0,0,-1,0};
		int[] dc = {0,0,-1,0, 0,0,1,0, 0,1,1,2, 0,1,1,2 };
		for(int i=0; i<4; i++) {
			int sum = 0;
			int cnt = 0;
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[i*4+k];
				int nc = p.c + dc[i*4+k];
				if(0<=nr && nr<N && 0<=nc && nc<M) {
					sum += arr[nr][nc];
					cnt++;
				}
			}
			if(cnt==4) {
				if(sum>max) max = sum;
			}
		}
	}//end of method3 : T
	
	private static void L(Pair p) {
		int[] dr = {0,0,0,-1, 0,0,0,1, 1,0,0,0,-1,0,0,0, 0,0,1,2, 0,0,1,2, 0,1,2,2, 0,1,2,2};
		int[] dc = {0,1,2,2,  0,1,2,2, 0,0,1,2, 0,0,1,2, 0,1,0,0, 0,-1,0,0, 0,0,0,1, 0,0,0,-1};
		for(int i=0; i<8; i++) {
			int sum = 0;
			int cnt = 0;
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[i*4+k];
				int nc = p.c + dc[i*4+k];
				if(0<=nr && nr<N && 0<=nc && nc<M) {
					sum += arr[nr][nc];
					cnt++;
				}
			}
			if(cnt==4) {
				if(sum>max) max = sum;
			}
		}
	}//end of method4 : L
	
	private static void zigzag(Pair p) {
		int[] dr = {0,1,1,2, 0,1,1,2,   0,0,-1,-1, 0,0,1,1};
		int[] dc = {0,0,1,1, 0,0,-1,-1, 0,1,1,2,   0,1,1,2 };
		for(int i=0; i<4; i++) {
			int sum = 0;
			int cnt = 0;
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[i*4+k];
				int nc = p.c + dc[i*4+k];
				if(0<=nr && nr<N && 0<=nc && nc<M) {
					sum += arr[nr][nc];
					cnt++;
				}
			}
			if(cnt==4) {
				if(sum>max) max = sum;
			}
		}
	}//end of method5 : zigzag
	
}//end of class
