package TIL_0705;
import java.util.*;

public class Main_bj_11052_카드구매 {
	static int[] card, value;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		card = new int[N+1];
		value = new int[N+1];
		for(int i=1; i<=N; i++) card[i] = sc.nextInt();
		int max = 0;		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				value[i] = Math.max(value[i], value[i-j] + card[j]);
			}
		}
		System.out.println(value[N]);
	}//end of main

}//end of class
