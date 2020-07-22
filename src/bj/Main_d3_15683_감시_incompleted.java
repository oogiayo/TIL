package bj;
import java.util.*;

public class Main_d3_15683_감시_incompleted {
	static int N, M, cnt, cnt1, cnt2, cnt3, cnt4, max;
	static int[] arr = {0, 1, 2, 3};
	static boolean[] visited = new boolean[4];
	static Queue<Pair> q1 = new LinkedList<>(), q2 = new LinkedList<>(), q3 = new LinkedList<>(), q4 = new LinkedList<>();
	static int[][] map;
	static int[] dr = {-1,0,1,0,  -1,0};
	static int[] dc = {0,1,0,-1,  0,1};   // 북>동>남>서>북>동
	
	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로크기
		M = sc.nextInt(); // 가로크기
		map = new int[N][M];
		cnt1 = 0; cnt2 = 0; cnt3 = 0; cnt4 = 0;	 // cctv 종류별 개수
		max = 0;
		int sum5 = 0;
		
		int ans = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c]==1) {
					q1.add(new Pair(r, c));
					cnt1++;
				}
				else if(map[r][c]==2) {
					q2.add(new Pair(r, c));
					cnt2++;
				}
				else if(map[r][c]==3) {
					q3.add(new Pair(r, c));
					cnt3++;
				}
				else if(map[r][c]==4) {
					q4.add(new Pair(r, c));
					cnt4++;
				}
				else if(map[r][c]==5) {
					sum5 = cctv5(r, c);
				}
				else if(map[r][c]==0) {
					ans++;
				}
			}
		}//end of input
		cnt = cnt1 + cnt2 + cnt3 + cnt4;
		System.out.println("최초 사각지대 = " + ans);
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println();
		System.out.println("cctv5가 찾은 곳 = " + sum5);
		
		Repermutation(new int[cnt], 0, map);
		max += sum5;
		ans -= max;
		if(ans < 0) ans = 0;
		System.out.println(ans);
	}//end of main

	private static void Repermutation(int[] ans, int idx, int[][] map_c) {
		if(idx==ans.length) {
			int sum = 0;
			int[][] map_copied = new int[N][M];
			for(int r=0; r<N; r++){
				System.arraycopy(map[r], 0, map_copied[r], 0, M);
			}
			for(int i=0; i<idx; i++) {
				if(i<cnt1) {
					sum += cctv1(ans[i], map_copied);
				}
				else if(i<cnt1+cnt2) {
					if(ans[i]>1) break;
					sum += cctv2(ans[i], map_copied);					
				}
				else if(i<cnt1+cnt2+cnt3) {
					sum += cctv3(ans[i], map_copied);
				}
				else if(i<cnt) {
					sum += cctv4(ans[i], map_copied);
				}
			}
			if(sum > max) {
				max = sum;
				for(int r=0; r<N; r++) {
					System.out.println(Arrays.toString(map_copied[r]));
				}
				System.out.println();
				System.out.println(sum);
			}
			return;
		}
		for(int i=0; i<4; i++) {
			ans[idx] = arr[i];
			Repermutation(ans, idx+1, map_c);
		}
	}//end of method : Permutation
	
	private static int cctv1(int per, int[][] map_c) {
		int sum = 0;
		Pair p = q1.poll();
		int k=per;
		int nr = p.r + dr[k];
		int nc = p.c + dc[k];
		while(true) {
			if(0<=nr && nr<N && 0<=nc && nc<M && map_c[nr][nc]!=6) {
				if(map_c[nr][nc]==0) {
					map_c[nr][nc] = -1;		 // 감시영역으로 지정 (0)
					sum++;
				}						     // (-1, 1, 2, 3, 4, 5는 변경없이 통과만)
				nr += dr[k];
				nc += dc[k];
			}
			else break;						 // 벽(6)이면 탐색 fin.
		}
		q1.add(p);
		return sum;
		
	}//end of method : cctv1
	
	private static int cctv2(int per, int[][] map_c) {
		int sum = 0;
		Pair p = q2.poll();
		for(int k=per; k<per+3; k+=2) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];
			while(true) {
				if(0<=nr && nr<N && 0<=nc && nc<M && map_c[nr][nc]!=6) {	 
					if(map_c[nr][nc]==0) {
						map_c[nr][nc] = -1;		 // 감시영역으로 지정 (0)
						sum++;
					}						     // (-1, 1, 2, 3, 4, 5는 변경없이 통과만)
					nr += dr[k];
					nc += dc[k];
				}
				else break;						 // 벽(6)이면 탐색 fin.
			}
		}
		q2.add(p);
		return sum;
	}//end of method : cctv2

	private static int cctv3(int per, int[][] map_c) {
		int sum = 0;
		Pair p = q3.poll();
		for(int k=0+per; k<2+per; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];
			while(true) {
				if(0<=nr && nr<N && 0<=nc && nc<M && map_c[nr][nc]!=6) {	 
					if(map_c[nr][nc]==0) {
						map_c[nr][nc] = -1;		 // 감시영역으로 지정 (0)
						sum++;
					}						     // (-1, 1, 2, 3, 4, 5는 변경없이 통과만)
					nr += dr[k];
					nc += dc[k];
				}
				else break;						 // 벽(6)이면 탐색 fin.
			}
		}
		q3.add(p);
		return sum;
	}//end of method : cctv3

	
	private static int cctv4(int per, int map_c[][]) {
		int sum = 0;
		Pair p = q4.poll();
		for(int k=0+per; k<3+per; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];
			while(true) {
				if(0<=nr && nr<N && 0<=nc && nc<M && map_c[nr][nc]!=6) {	 
					if(map_c[nr][nc]==0) {
						map_c[nr][nc] = -1;		 // 감시영역으로 지정 (0)
						sum++;
					}						     // (-1, 1, 2, 3, 4, 5는 변경없이 통과만)
					nr += dr[k];
					nc += dc[k];
				}
				else break;						 // 벽(6)이면 탐색 fin.
			}
		}
		q4.add(p);
		return sum;
	}//end of method : cctv4
	
	private static int cctv5(int r, int c) {
		int sum = 0;
		for(int k=0; k<4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			while(true) {
				if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]!=6) {	 
					if(map[nr][nc]==0) {
						map[nr][nc] = -1;		 // 감시영역으로 지정 (0)
						sum++;
						System.out.println(nr + ", " + nc);
					}						     // (-1, 1, 2, 3, 4, 5는 변경없이 통과만)
					nr += dr[k];
					nc += dc[k];
				}
				else break;						 // 벽(6)이면 탐색 fin.
			}
		}
		System.out.println(sum);
		return sum;
	}//end of method : cctv5
}//end of class
