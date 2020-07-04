package SWEA_d3;
import java.util.*;

public class Solution_d3_9280_주차타워 {
	static int[] rate, weight, space;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			rate = new int[n];
			space = new int[n];
			
			int m = sc.nextInt();
			weight = new int[m+1];

			for(int i=0; i<n; i++) {
				rate[i] = sc.nextInt();
			}
			for(int i=1; i<=m; i++) {
				weight[i] = sc.nextInt();
			}
			int fee = 0;  // 요금의 합
			int cnt = 0;  // cycle 수
			Queue<Integer> q = new LinkedList<>();  // 대기장소
			while(cnt < 2*m) {
				int num = sc.nextInt();  // 자동차 number (입장인지 퇴장인지 모름)
				
				if(num>0) {  // 입장이면
					boolean check = false;  // 주차여부 체크
					for(int k=0; k<n; k++) {
						if(space[k]==0) {
							space[k] = num;
							check = true;
							fee += weight[num]*rate[k];
							break;
						}
					}
					if(!check) {  // 주차 못했으면
						q.add(num);
					}
				}
				else {  // 퇴장이면
					num *= -1;
					int empty = -1;
					
					boolean check = false;  // 출차여부 체크
					for(int k=0; k<n; k++) {
						if(space[k]==num) {
							space[k] = 0;
							check = true;
							empty = k;
							break;
						}
					}
					if(!q.isEmpty() && check) {  // 대기자 有  &  출차했으면
						int num_new = q.poll();
						space[empty] = num_new;
						fee += weight[num_new]*rate[empty];
					}
				}
				cnt++;
			}//end of while
			
			System.out.println("#" + t + " " + fee);
		}//end of tc
		
	}//end of main
	
}//end of class
