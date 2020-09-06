package TIL_0906;
import java.util.*;

public class Main_bj_12886_돌그룹 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stones = new int[3];
		int sum = 0;
		for(int i=0; i<3; i++) {
			stones[i] = sc.nextInt();
			sum += stones[i];
		}
		int[][] m = new int[1501][1501];
		Arrays.sort(stones);
		
		int ans = 0;
		
		Queue<int[]> q = new LinkedList<>();
		if(stones[0]==stones[1] && stones[1]==stones[2]) ans = 1;
		else if(sum%3==0 && sum%2==0) {
			int num = sum/3;
			q.add(new int[] {num/2, num, num + num/2});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				if(m[temp[0]][temp[1]]==temp[2]) {
					continue;
				}
				m[temp[0]][temp[1]] = temp[2]; 
				
				if(temp[0]==stones[0] && temp[1]==stones[1] && temp[2]==stones[2]) {
					ans = 1;
					break;
				}
				if(temp[0]%2!=0 && temp[1]%2!=0 && temp[2]%2!=0) continue;
				
				if(temp[0]%2==0) {
					int[] next1 = {temp[0]/2, temp[1] + temp[0]/2, temp[2]};
					Arrays.sort(next1);
					q.add(next1);
					int[] next2 = {temp[0]/2, temp[1], temp[2] + temp[0]/2};
					Arrays.sort(next2);
					q.add(next2);
				}
				if(temp[1]%2==0) {
					int[] next1 = {temp[1]/2, temp[0] + temp[1]/2, temp[2]};
					Arrays.sort(next1);
					q.add(next1);
					int[] next2 = {temp[1]/2, temp[0], temp[2] + temp[1]/2};
					Arrays.sort(next2);
					q.add(next2);
				}
				if(temp[2]%2==0) {
					int[] next1 = {temp[2]/2, temp[1] + temp[2]/2, temp[0]};
					Arrays.sort(next1);
					q.add(next1);
					int[] next2 = {temp[2]/2, temp[1], temp[0] + temp[2]/2};
					Arrays.sort(next2);
					q.add(next2);
				}
			}
		}
		else {
			ans = 0;
		}
		System.out.println(ans);
		
	}
}
