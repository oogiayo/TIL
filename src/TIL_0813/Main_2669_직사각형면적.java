package TIL_0813;
import java.util.*;

public class Main_2669_직사각형면적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		int x_max = 0;
		int y_max = 0;
		for(int i=0; i<4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			if(x2>x_max) {
				x_max = x2;
			}
			if(y2>y_max) {
				y_max = y2;
			}
			for(int r=y1; r<y2; r++) {
				for(int c=x1; c<x2; c++) {
					arr[r][c] = 1;
				}
			}
		}
		int cnt = 0;
		for(int r=1; r<y_max; r++) {
			for(int c=1; c<x_max; c++) {
				if(arr[r][c]==1) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}//end of main
}//end of class
