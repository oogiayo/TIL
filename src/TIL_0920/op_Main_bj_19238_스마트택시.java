package TIL_0920;
import java.util.*;

public class op_Main_bj_19238_스마트택시 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pair {
		int r; int c; int fuel; boolean passenger; int fare;
		public Pair(int r, int c, int fuel, boolean passenger, int fare) {
			this.r = r;
			this.c = c;
			this.fuel = fuel;
			this.passenger = passenger;
			this.fare = fare;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), fuel0 = sc.nextInt();
		int[][] map = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int people = 0;
		int r0 = sc.nextInt()-1, c0 = sc.nextInt()-1;
		for(int i=0; i<M; i++) {
			int rS = sc.nextInt()-1, cS = sc.nextInt()-1;
			map[rS][cS] = i*2+2;
			// 짝수 => 승객위치
			int rE = sc.nextInt()-1, cE = sc.nextInt()-1;
			map[rE][cE] = i*2+3;
			// 홀수 => 목적지
			people++;
		}
		
//		for(int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(r0, c0, fuel0, false, 0));
		
		int endpoint = 0;
		int fuel_now = 0;
		
		boolean[][] visited = new boolean[N][N];
		visited[r0][c0] = true;
		
		for(int i=0; i<M; i++) {
			boolean isSuccessed = false;
			// 1. 최단거리 탐색을 통해 가장 가까운 승객을 찾는다 (if 짝수)
			while(!q.isEmpty()) {
				Pair p = q.poll();
				System.out.println(p.r + ", " + p.c);
				// Fail : 이동 중 연료 == 0
				if(p.fuel==0) {
					continue;
//					System.out.println("fail");
//					isFailed = true;
//					break L;
				}
				
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc]!=1 && visited[nr][nc]==false) {
						if(p.passenger==false) {
							if(map[nr][nc]==0) {
								visited[nr][nc] = true;
								q.add(new Pair(nr, nc, p.fuel-1, false, 0));
							}
							else if(map[nr][nc]%2==0) {
								endpoint = map[nr][nc] + 1;
								map[nr][nc] = 0;
								
								visited = new boolean[N][N];
								visited[nr][nc] = true;
								q.clear();
								q.add(new Pair(nr, nc, p.fuel-1, true, 0));
							}
						}
						else {
							if(map[nr][nc]==0) {
								visited[nr][nc] = true;
								q.add(new Pair(nr, nc, p.fuel-1, true, p.fare+1));
							}
							else if(map[nr][nc]==endpoint) {
								map[nr][nc] = 0;
								people--;
								isSuccessed = true;
								System.out.println("mission clear");
								
								visited = new boolean[N][N];
								visited[nr][nc] = true;
								
								q.clear();
								q.add(new Pair(nr, nc, p.fuel-1 + p.fare, false, 0));
								fuel_now = p.fuel-1 + p.fare;
								break;
							}
						}
					}
				}
			}
			if(isSuccessed==false) {
				System.out.println("fail");
//				isFailed = true;
				break;
			}
			System.out.println(fuel_now);
		}

		
		// 1-1. 동시에 2명 이상 탐색 시 (r)이 가장 작은 승객 => (c)가 가장 작은 승객

	}
}
