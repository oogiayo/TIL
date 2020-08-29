package TIL_0829;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2293_동전1 {
	static int[] m, coin;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		m = new int[k+1];
		coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.valueOf(bf.readLine());
		}
		for(int i=n-1; i>=0; i--) {
			for(int j=1; j<=k; j++) {
				if(j==coin[i]) m[j] += 1;
				else if(j>coin[i]) m[j] += m[j-coin[i]];
			}
		}
		System.out.println(m[k]);
	}
}
