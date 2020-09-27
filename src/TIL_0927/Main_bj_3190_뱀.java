package TIL_0927;
import java.util.*;

public class Main_bj_3190_뱀 {
	static int[][] map, dirc;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	// 상우하좌 순서
	
	static class Pair {
		int r; int c; int head; int t;
		public Pair(int r, int c, int head, int t) {
			this.r = r;
			this.c = c;
			this.head = head;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][N];
		dirc = new int[N][N];
		dirc[0][0] = 1; // 최초 방향(0~3)
		map[0][0] = 1; // head 위치
		
		for(int i=0; i<K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r-1][c-1] = 2; // apple
		}
		int L = sc.nextInt();
		String[] rotate_time = new String[10001];
		for(int i=0; i<L; i++) {
			int X = sc.nextInt();
			rotate_time[X] = sc.next();
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.head==1) {
				System.out.println("현재 경과시간은" + p.t + "입니다.");
				for(int r=0; r<N; r++) {
					System.out.println(Arrays.toString(map[r]));
				}	
//				System.out.println("방향");
//				for(int r=0; r<N; r++) {
//					System.out.println(Arrays.toString(dirc[r]));
//				}	
				System.out.println();
			}
			
			int k = dirc[p.r][p.c];
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];
			if(p.head==1) {
				if(0<=nr && nr<N && 0<=nc && nc<N) {
					if(map[nr][nc]==1) {
						System.out.println("몸에 부딪혀서 게임종료");
						System.out.println(p.t+1);
						// 자기 몸에 부딪히면 게임 종료
						break;
					}
					if(rotate_time[p.t+1]==null) {
						// 다음위치의 방향 그대로
						dirc[nr][nc] = dirc[p.r][p.c];
					}
					else {
						// 회전해야하는 시간이 되면 다음위치의 방향을 돌려준다.
						if(rotate_time[p.t+1].equals("D")) {
							 int next_dirc = dirc[p.r][p.c] + 1;
							 if(next_dirc==4) next_dirc = 0;
							 dirc[nr][nc] = next_dirc;
						}
						else {
							int next_dirc = dirc[p.r][p.c] - 1; 
							if(next_dirc==-1) next_dirc = 3;
							dirc[nr][nc] = next_dirc; 
						}
					}
					
					if(map[nr][nc]==0) {
						map[p.r][p.c] = 0;
						map[nr][nc] = 1;
						q.add(new Pair(nr, nc, 1, p.t + 1));
					}
					else if(map[nr][nc]==2) {
						map[p.r][p.c] = 1;
						map[nr][nc] = 1;
						q.add(new Pair(nr, nc, 1, p.t + 1));
						q.add(new Pair(p.r, p.c, 0, 0));
					}
				}
				else {
					// 벽에 부딪히면 게임 종료
					System.out.println("벽에 부딪혀서 게임 종료");
					System.out.println(p.t+1);
					break;
				}
			}
			// body일 경우(p.head==false)
			else {
				if(map[nr][nc]==0) {
					map[p.r][p.c] = 0;
					map[nr][nc] = 1;
					q.add(new Pair(nr, nc, 0, 0));
				}
				else if(map[nr][nc]==1) {
					q.add(new Pair(p.r, p.c, 0, 0)); 
				}
			}
		}
		
		
	}//end of main
}//end of class
