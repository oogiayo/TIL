package TIL_0710;
import java.util.*;

public class Solution_d3_8888_시험 {
	static int N, T, P;
	static int[][] arr;
	static int[] pnt, score, got;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); 
		for(int t=1; t<=Tc; t++) {
			N = sc.nextInt(); // 학생 수
			T = sc.nextInt(); // 문제 개수
			P = sc.nextInt(); // 지학이 순서
			got = new int[N]; // 학생별 맞은개수
			score = new int[N]; // 학생별 총점
			pnt = new int[T]; // 문제별 배점
			arr = new int[N][T];
			for(int r=0; r<N; r++) {
				for(int c=0; c<T; c++) {
					arr[r][c] = sc.nextInt();
					if(arr[r][c]==0) {
						pnt[c]++;
					}
				}
			}//end of input
			
			for(int i=0; i<T; i++) {
				for(int j=0; j<N; j++) {
					got[j] += arr[j][i];
					score[j] += arr[j][i] * pnt[i];
				}
			}
			int cnt = 1;
			for(int i=0; i<N; i++) {
				if(score[i]>score[P-1]) cnt++;
				else if(got[i]>got[P-1] && score[i]==score[P-1] && i!=P-1) cnt++;
				else if(i<P-1 && score[i]==score[P-1] && got[i]==got[P-1]) cnt++;
			}
			System.out.println("#" + t + " " + score[P-1] + " " + cnt);
		}//end of tc
	}//end of main
}//end of class
