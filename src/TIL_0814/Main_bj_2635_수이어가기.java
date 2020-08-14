package TIL_0814;
import java.util.*;

public class Main_bj_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N1 = sc.nextInt();
		int max = 0;
		int N2_ans = 0;
		for(int i=0; i<=N1; i++) {
			int N2 = i;
			int n1 = N1, n2 = N2;
			int n = n1-n2;
			int cnt = 3;
			while(true) {
				n1 = n2;
				n2 = n;
				n = n1-n2;
				if(n < 0) break;
				cnt += 1;
				
			}
			if(cnt > max) {
				max = cnt;
				N2_ans = N2;
			}
		}
		System.out.println(max);
		int N1_ans = N1;
		int N_ans = N1_ans - N2_ans;
		System.out.print(N1_ans + " " + N2_ans + " " + N_ans);
		for(int i=2; i<max; i++) {
			N1_ans = N2_ans;
			N2_ans = N_ans;
			N_ans = N1_ans-N2_ans;
			if(N_ans < 0) break;
			System.out.print(" " + N_ans);
		}
	}
}
