package TIL_0822;
import java.util.*;
import java.io.*;

public class op_Main_bj_2304_창고다각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		int[] location = new int[N];
		int[] height = new int[N];
		int max_height = 0;
//		int max_idx = 0;
		int check = 0;
		for(int i=0; i<N; i++) {
			String[] line = bf.readLine().split(" ");
			location[i] = Integer.valueOf(line[0]);
			height[i] = Integer.valueOf(line[1]);
			if(height[i] > max_height) {
				max_height = height[i];
				check = 0;
			}
			else if(height[i] == max_height) {
				check++;
			}
			for(int j=0; j<i; j++) {
				if(location[j]>location[i]) {
					int temp_l = location[j];
					location[j] = location[i];
					location[i] = temp_l;
					int temp_h = height[j];
					height[j] = height[i];
					height[i] = temp_h;
//					max_idx = j;
					break;
				}
			}
		}
		int area = 0;
		int idx = 0;
		int l = location[0];
		int h = height[0];
		while(true) {
			idx++;
			if(height[idx] > h) {
				area += (location[idx] - l)*h;
				h = height[idx];
				l = location[idx];
			}
			if(height[idx]==max_height) {
				break;
			}	
		}
		
		while(true) {
			if(check==0) {
				area += max_height * (location[idx]-l+1);
				break;
			}
			else {
				idx++;
				check--;
			}
		}
		
//		idx = N-1;
//		int r = location[N-1];
//		h = location[N-1];
//		while(true) {
//			break;
//		}
		System.out.println(area);
		
	}//end of main
	
}//end of class
