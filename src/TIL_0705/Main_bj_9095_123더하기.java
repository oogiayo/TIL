package TIL_0705;
import java.util.*;

public class Main_bj_9095_123더하기 {
	static int[] m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			m = new int[n+1];
			m[1] = 1;
			if(n>=2) m[2] = 2;
			if(n>=3) m[3] = 4;
			System.out.println(Topdown(n));
		}//end of tc
	}//end of main
	
	private static int Topdown(int n) {
		if(m[n]==0) {
			m[n] = Topdown(n-3) + Topdown(n-2) + Topdown(n-1);
		}
		return m[n];
	}
	
}//end of class
