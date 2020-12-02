package TIL_1202;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_d3_2814_최장경로 {
	static int N;	// 정점의 수
	static int M;	// 간선의 수
	static List<Integer>[] adj;	// 인접 리스트
	static boolean[] visited;	// 방문 여부
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new LinkedList[N+1];
			for(int i=1; i<=N; i++) adj[i] = new LinkedList<>();
			visited = new boolean[N+1];
			// 간선 정보 입력(무향그래프)
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			ans = 0;
			for(int i=1; i<=N; i++) {
				visited[i] = true;
				solve(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	// 상태공간트리의 각 상태는 어느 정점에 몇번 밟고 왔는지.
	static void solve(int v, int cnt) {
		ans = Math.max(ans, cnt);
		// v와 연결된 정점 중
		for(int nV : adj[v]) {
			// 방문하지 않았을 때
			if(!visited[nV]) {
				// 방문 체크
				visited[nV] = true;
				// 상태전이 (해당 정점으로 이동)
				solve(nV, cnt + 1);
				// 방문 초기화
				visited[nV] = false;
			}
		}
	}
}
