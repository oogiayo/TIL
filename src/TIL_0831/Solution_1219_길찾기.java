package TIL_0831;
import java.util.*;

public class Solution_1219_길찾기 {
	static int[][] way;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1; t<=T; t++) {
			sc.nextInt();
			int N = sc.nextInt();
			way = new int[2][100];
			for(int i=0; i<N; i++) {
				int node = sc.nextInt();
				if(way[0][node]==0) {
					way[0][node] = sc.nextInt();
				}
				else {
					way[1][node] = sc.nextInt();
				}
			}
			ans = 0;
			find(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void find(int now) {
		if(now==99) {
			ans = 1;
			return;
		}
		if(way[0][now]==0 && way[1][now]==0) return;
		if(way[0][now]!=0) {
			find(way[0][now]);
			way[0][now] = 0;
		}
		if(way[1][now]!=0) {
			find(way[1][now]);
			way[0][now] = 0;
		}
	}
}
