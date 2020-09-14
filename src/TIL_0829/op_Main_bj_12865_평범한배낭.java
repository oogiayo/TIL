package TIL_0829;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class op_Main_bj_12865_평범한배낭 {
	static int[] m;
	static int[][] things;
	static int max_weight, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		things = new int[N][2];
		int[] ans = new int[K+1];
		m = new int[K+1];
		boolean[][] used = new boolean[N][K+1];
		max_weight = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			things[i][0] = Integer.valueOf(st2.nextToken());
			things[i][1] = Integer.valueOf(st2.nextToken());
			if(things[i][0] > max_weight) max_weight = things[i][0];
		}
//		for(int i=1; i<=K; i++) {
//			for(int j=1; j<=max_weight; j++) {
//				for(int k=0; k<N; k++) {
//					int temp = 0;
//					if(i>=things[k][0] && used[k][i-things[k][0]]==false && things[k][0]<=j) {
//						used[k][i-things[k][0]] = true;
//						temp = ans[i-things[k][0]] + things[k][1];
//						used[k][i-things[k][0]] = false;
//					}
//					if(temp > ans[i]) ans[i] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(ans));
//		System.out.println();
//		for(int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(used[r]));
//		}
//		System.out.println(ans[K]);
	}
	
//	private static int dp(int x) {
//		if(m[x] > 0) return m[x];
//		else {
//			for(int i=1; i<=max_weight; i++) {
//				for(int j=0; j<N; j++) {
//					if(i >= things[j][0]) {
//						
//					}
//				}
//			}
//			
//		}
//		
//	}
}
