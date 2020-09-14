package TIL_0902;
import java.util.Scanner;

public class OP_Solution_d4_1238_Contact_dfs {
	static int[][] network;
	static boolean[] visited;
	static int max_cnt, max_num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int p0 = sc.nextInt();
			
			network = new int[101][101];
			visited = new boolean[101];
			visited[p0] = true;
			
			max_num = 0;
			max_cnt = 0;
			for(int i=0; i<N/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				network[a][b] = 1;
			}
			
			for(int c=1; c<=100; c++) {
				if(network[p0][c]==1 && c!=p0) {
					visited[c] = true;
					dfs(c, 1);
				}
			}
			
			System.out.println("#" + t + " " + max_num);
		}//end of tc
	}//end of main
	
	private static void dfs(int now, int cnt) {
		for(int next=1; next<=100; next++) {
			if(network[now][next]==1 && visited[next]==false) {
				visited[next] = true;
				dfs(next, cnt+1);
			}
		}
		if(cnt > max_cnt) {
			max_cnt = cnt;
			max_num = now;
		}
		else if(cnt==max_cnt && now > max_num) max_num = now;
		return;
	}
}
