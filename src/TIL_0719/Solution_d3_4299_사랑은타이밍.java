package TIL_0719;
import java.util.*;

public class Solution_d3_4299_사랑은타이밍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int DD = sc.nextInt();
			int HH = sc.nextInt();
			int MM = sc.nextInt();
			int wd = (DD-11)*24*60;
			int wh = (HH-11)*60;
			int wm = MM-11;
			int ans = wd+wh+wm;
			if(ans<0) ans = -1;
			System.out.println("#" + t + " " + ans);
		}//end of tc
	}//end of main
}//end of class
