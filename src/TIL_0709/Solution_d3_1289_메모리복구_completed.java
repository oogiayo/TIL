package TIL_0709;
import java.util.*;

public class Solution_d3_1289_메모리복구_completed {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String N = sc.next();
			int[] arr = new int[N.length()];
			int[] zero = new int[N.length()];
			for(int i=0; i<N.length(); i++) {
				arr[i] = N.charAt(i)-'0';
			}
			int cnt = 0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==1) {
					arr[i] = 0;
					for(int j=i+1; j<arr.length; j++) {
						arr[j] = 1 - arr[j];
					}
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}//end of tc
	}//end of main
}//end of class