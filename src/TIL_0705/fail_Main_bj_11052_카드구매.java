package TIL_0705;
import java.util.*;

public class fail_Main_bj_11052_카드구매 {
	static int[] card, num;
	static float[] value;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		card = new int[N+1];
		value = new float[N+1];
		num = new int[N+1];
		for(int i=1; i<=N; i++) {
			card[i] = sc.nextInt();
			value[i] = card[i]/(float)i;
			num[i] = i;
		}

		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				if(value[i]<value[j]) {
					float temp1 = value[i];
					int temp2 = num[i];
					value[i] = value[j];
					num[i] = num[j];
					value[j] = temp1;
					num[j] = temp2;
				}
			}
		}
		
		int ans = 0;
		int n = N;
		for(int k=1; k<=N; k++) {
			
		}
		for(int i=1; i<=N; i++) {
			if(n/num[i]>0) {
				ans += n/num[i] * card[num[i]];
				n = n%num[i];
			}
			if(n==0) {
				break;
			}
		}
		System.out.println((int)ans);
		
	}

}
