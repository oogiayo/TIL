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
		int[] val_of_w = new int[100001];
		int[] weights = new int[N];
		int[] m = new int[100001];
		for(int i=0; i<N; i++) {
			StringTokenizer bag = new StringTokenizer(bf.readLine());
			int weight = Integer.valueOf(bag.nextToken());
			int val = Integer.valueOf(bag.nextToken());
			weights[i] = weight;
			val_of_w[weight] = val;
//			m[weight] = val;
		}
		
		for(int i=0; i<K; i++) {
			boolean[] visited = new boolean[100001];
			for(int weight: weights) {
				if(i >= weight && !visited[weight]) {
					m[i] = m[i-weight] + val_of_w[weight];
				}
			}
		}
		System.out.println(m[K]);
	}
}
