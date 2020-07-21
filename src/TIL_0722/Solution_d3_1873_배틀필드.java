package TIL_0722;
import java.util.*;

public class Solution_d3_1873_배틀필드 {
	static String[][] map;
	static int W, H;
	static String[] tank = {"<", ">", "^", "v"};
	static String[] direction = {"L", "R", "U", "D"};
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	static class Pair {
		int r; int c; String direc;
		public Pair(int r, int c, String direc) {
			this.r = r;
			this.c = c;
			this.direc = direc;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new String[H][W];
			Pair p = new Pair(0, 0, "");	// 탱크의 위치정보 및 모양을 나타내는 Pair 선언
			for(int r=0; r<H; r++) {
				String str = sc.next();
				for(int c=0; c<W; c++) {
					map[r][c] = str.substring(c, c+1);
					for(int k=0; k<4; k++) {
						if(map[r][c].equals(tank[k])) {
							p = new Pair(r, c, map[r][c]);	// 탱크의 초기 위치정보 및 모양 입력
						}
					}
				}
			}
			int N = sc.nextInt();
			String commands = sc.next();
			for(int i=0; i<N; i++) {
				String play = commands.substring(i, i+1);
				if(play.equals("S")) {	
					p = attack(p);	// command==S일 경우, attack 메소드 실행 및 command 후의 위치정보 및 모양 return
				}
				else {
					p = go(p, play); // command==L/R/D/U일 경우, go 메소드 실행 및 command 후의 위치정보 및 모양 return
				}
			}
			
			System.out.print("#" + t + " ");
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}
	}//end of main
	
	private static Pair go(Pair p, String key) {
		int idx = -1;
		for(int k=0; k<4; k++) {
			if(key.equals(direction[k])) idx = k;
		}
		String n_direc = tank[idx];	
		map[p.r][p.c]= n_direc; // 입력된 key(L/R/U/D)에 맞게 탱크모양(방향) 변경
		
		int nr = p.r + dr[idx];
		int nc = p.c + dc[idx];
		if(0<=nr && nr<H && 0<=nc && nc<W && map[nr][nc].equals(".")) {
			map[nr][nc] = n_direc;
			map[p.r][p.c] = "."; 
			return new Pair(nr, nc, n_direc);
		}
		else {
			return new Pair(p.r, p.c, n_direc);
		}
	}//end of method "go" : 탱크 위치정보 & 모양(방향) return
	
	
	private static Pair attack(Pair p) {
		int idx = -1;
		for(int k=0; k<4; k++) {
			if(p.direc.equals(tank[k])) idx = k;
		}		
		int cnt = 1;
		while(true) {
			int nr = p.r + dr[idx]*cnt;
			int nc = p.c + dc[idx]*cnt;
			if(0<=nr && nr<H && 0<=nc && nc<W) {
				if(map[nr][nc].equals(".") || map[nr][nc].equals("-")) {	// 땅(.) or 물(-) 만날경우 한 번 더 탐색(cnt++)
					cnt++;
				}
				else if(map[nr][nc].equals("*")) {
					map[nr][nc] = ".";
					break;
				}
				else if(map[nr][nc].equals("#")) {
					break;
				}
			}
			else {
				break;
			}
		}
		return new Pair(p.r, p.c, p.direc);
	}//end of method "attack" : 탱크 위치정보 & 모양(방향) return
	
}//end of class
