package TIL_0806;
import java.util.*;

public class op_Main_bj_1525_퍼즐 {
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static class Pair {
		int r; int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[3][3];
		Queue<Pair> q = new LinkedList<>();
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c]==0) {
					q.add(new Pair(r, c));
				}
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}//end of main
}//end of class
