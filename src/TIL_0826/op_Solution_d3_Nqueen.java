package TIL_0826;
import java.util.*;
import java.io.*;

public class op_Solution_d3_Nqueen {
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(bf.readLine());
			int[][] arr = new int[N][N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[j]==false) {
						arr[i][j] = 1;
						visited[j] = true;
					}
				}
			}
		}
	}
//	
//	private static void nQueen(int[][] ans, int r) {
//		for(int c=0; c<N; c++) {
//			if(visited[c]==false) {
//				visited[c] = true;
//				ans[r][c] = 1;
//			}
//		}
//	}
}
