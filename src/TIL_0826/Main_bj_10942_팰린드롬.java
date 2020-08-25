package TIL_0826;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_10942_팰린드롬 {
	static boolean[][] ans;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		String[] line = bf.readLine().split(" ");
		nums = new int[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.valueOf(line[i-1]);
		}
		int M = Integer.valueOf(bf.readLine());
		
		ans = new boolean[N+1][N+1];
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j<M; j++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
//			String[] SE = bf.readLine().split(" ");
//			int S = Integer.valueOf(SE[0]);
//			int E = Integer.valueOf(SE[1]);
			if(S==E) {
				ans[S][E] = true;
				sb.append("1\n");
				continue;
			}
			else if(E-S==1) {
				if(nums[S]==nums[E]) {
					sb.append("1\n");
					continue;
				}
			}
			for(int i=0; i<=(E-S)/2; i++) {
				if(ans[S+i][E-i]) {
					sb.append("1\n");
					ans[S][E] = true;
					break;
				}
				else {
					if(nums[S+i]==nums[E-i]) {
						if(i==(E-S)/2) {
							for(int k=0; k<=(E-S)/2; k++) {
								if(ans[S+k][E-k]==false) {
									ans[S+k][E-k] = true;
								}
							}
							sb.append("1\n");
						}
					}
					else {
						sb.append("0\n");
						break;
					}
				}
			}
		}
		System.out.print(sb);
	}

}
