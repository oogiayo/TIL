package TIL_0715;
import java.util.*;

public class Solution_d3_8673_토너먼트1 {
	static int K, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			K = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();

			for(int i=0; i<(int)Math.pow(2, K); i++) {
				int Ai = sc.nextInt();
				q.add(Ai);
			}			
			ans = 0;
			while(!q.isEmpty()) {
				if(q.size()==1) {
					System.out.println("#" + t + " " + ans);
					break;
				}
				else {
					int x1 = q.poll();
					int x2 = q.poll();
					ans += Math.abs(x1-x2);
					q.add(Math.max(x1, x2));
				}
			}
		}//end of tc
	}//end of main
}//end of class
