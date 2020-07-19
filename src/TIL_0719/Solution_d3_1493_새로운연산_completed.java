package TIL_0719;
import java.util.*;

public class Solution_d3_1493_새로운연산_completed {
	static class Pair {
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			Pair np = xy(p);
			Pair nq = xy(q);
			int nx = np.x + nq.x;
			int ny = np.y + nq.y;
			int size = nx + ny - 1;
			int N = 1;
			int ans = 1;
			while(size > N) {
				N++;
				ans += N;
			}
			System.out.println("#" + t + " " + (ans-size+nx));
		}
	}//end of main
	
	private static Pair xy(int n) {
		Pair[] arr = new Pair[n+1];
		int cnt = 1;
		int temp = 1;
		arr[0] = new Pair(1, 1);
		while(n>temp) {
			cnt++;
			temp += cnt;			
		}
		return(new Pair(cnt-(temp-n), (1+temp-n)));
	}
}
