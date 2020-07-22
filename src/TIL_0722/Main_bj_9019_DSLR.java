package TIL_0722;
import java.util.*;

public class Main_bj_9019_DSLR {
	static int[] visited;
	
	static class Pair {
		int n; String cmd;
		public Pair(int n, String cmd) {
			this.n = n;
			this.cmd = cmd;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			Queue<Pair> q = new LinkedList<>();
			visited = new int[10000];
			q.add(new Pair(A, ""));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.n == B) {
					System.out.println(p.cmd);
					break;
				}
				else {
					int A_D = D(p.n);
					if(visited[A_D]==0 || visited[A_D]>p.cmd.length()+1) {
						q.add(new Pair(A_D, p.cmd + "D"));
						visited[A_D] = p.cmd.length()+1;
					}
					int A_S = S(p.n);
					if(visited[A_S]==0 || visited[A_S]>p.cmd.length()+1) {
						q.add(new Pair(A_S, p.cmd + "S"));
						visited[A_S] = p.cmd.length()+1;
					}
					int A_L = L(p.n);
					if(visited[A_L]==0 || visited[A_L]>p.cmd.length()+1) {
						q.add(new Pair(A_L, p.cmd + "L"));
						visited[A_L] = p.cmd.length()+1;
					}
					int A_R = R(p.n);
					if(visited[A_R]==0 || visited[A_R]>p.cmd.length()+1) {
						q.add(new Pair(A_R, p.cmd + "R"));
						visited[A_R] = p.cmd.length()+1;
					}
				}
			}
			
		}//end of tc
	}//end of main
	
	private static int D(int n) {
		n *= 2;
		if(n > 9999) {
			n %= 10000;
		}
		return n;
	}
	
	private static int S(int n) {
		n--;
		if(n==-1) n = 9999;
		return n;
	}

	private static int L(int n) {
		return n%1000*10 + n/1000;
	}

	private static int R(int n) {
		return n%10*1000 + n/10;
	}
	
}//end of class
