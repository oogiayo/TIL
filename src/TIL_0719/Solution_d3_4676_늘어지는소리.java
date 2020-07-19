package TIL_0719;
import java.util.*;

public class Solution_d3_4676_늘어지는소리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String str = sc.next();
			String[] arr = new String[str.length()];
			for(int i=0; i<str.length(); i++) {
				arr[i] = str.substring(i, i+1);
			}
			int H = sc.nextInt();
			int[] hyphen = new int[H];
			for(int i=0; i<H; i++) {
				hyphen[i] = sc.nextInt();
			}
			Arrays.sort(hyphen);
			int cnt = 0;
			System.out.print("#" + t + " ");
			for(int i=0; i<=str.length(); i++) {
				while(cnt < hyphen.length && hyphen[cnt]==i) {
					System.out.print('-');
					cnt++;
				}
				if(i<str.length()) System.out.print(arr[i]);
			}
			System.out.println();
		}
	}//end of main
	
}//end of class
