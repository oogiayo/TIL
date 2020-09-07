package TIL_0907;
import java.util.*;
import java.io.*;

public class Solution_d4_1865_일분배 {
	static int N;
	static double ans;
	static boolean[] visited;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.valueOf(bf.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0; j<N; j++) {
					arr[j][i] = Integer.valueOf(st.nextToken());
				}
			}
			visited = new boolean[N];
			ans = 0;
			backTracking(0, 100);
			System.out.println("#" + t + " " + String.format("%.6f", ans));
			
		}//end of tc
	}//end of main
	
	private static void backTracking(int idx, double prb) {
		if(prb < ans) return;
		if(idx==N) {
			if(prb > ans) ans = prb;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i] && arr[idx][i]!=0) {
				visited[i] = true;
				backTracking(idx+1, prb * arr[idx][i]/100);
				visited[i] = false;
			}
		}
	}
	
}
