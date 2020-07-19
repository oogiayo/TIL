package TIL_0708;
import java.util.*;

public class Solution_d3_10059_유효기간 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int AB = N/100;
			int CD = N%100;
			String ans = "";
			if(0<AB && AB<13 && 0<CD && CD<13) {
				ans = "AMBIGUOUS";
			}
			else if(0<AB && AB<13) {
				ans = "MMYY";
			}
			else if(0<CD && CD<13) {
				ans = "YYMM";
			}
			else {
				ans = "NA";
			}
			System.out.println("#" + t + " " + ans);
		}//end of tc
		
	}//end of main

}//end of class
