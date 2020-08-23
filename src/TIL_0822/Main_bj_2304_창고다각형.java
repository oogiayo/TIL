package TIL_0822;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2304_창고다각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		int[] location = new int[N];
		int[] height = new int[N];
		int max_height = 0;
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
			if(height[idx]==max_height) {
				break;
			}
			idx++;
			if(height[idx] > h) {
				area += (location[idx]-l)*h;
				h = height[idx];
				l = location[idx];
			}
		}
		
		while(true) {
			if(check==0) {
				area += max_height * (location[idx]-l+1);
				break;
			}
			else {
				idx++;
				if(height[idx]==max_height) {
					check--;					
				}
			}
		}
		
		idx = N-1;
		int r = location[N-1];
		h = height[N-1];
		
		while(height[idx]!=max_height) {
			idx--;
			if(height[idx] > h) {
				area += (r - location[idx])*h;
				h = height[idx];
				r = location[idx];
			}
			if(height[idx]==max_height) {
				break;
			}
		}
		System.out.println(area);
		
	}//end of main
	
}//end of class
