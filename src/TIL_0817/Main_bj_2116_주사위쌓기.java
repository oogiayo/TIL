package TIL_0817;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2116_주사위쌓기 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		int[][] dices = new int[N][6];
		for(int r=0; r<N; r++) {
			// 0-5, 1-3, 2-4   
			String[] line = bf.readLine().split(" ");
			for(int c=0; c<6; c++) {
				dices[r][c] = Integer.valueOf(line[c]);
			}
		}
		int max_ans = 0;
		// 2,4 -> 4,1 -> 1,6 -> 6,4 -> 4,3
		for(int i=0; i<6; i++) {
			int max_side = 0;
			int idx = 0;
			
			int bot_i = i;
			int bot_n = dices[idx][bot_i];
			int top_i = getTop(bot_i);
			int top_n = dices[idx][top_i];
			
			int temp = 0;
			for(int k=0; k<6; k++) {
				if(k==bot_i || k==top_i) continue;
				else {
					if(dices[idx][k] > temp) temp = dices[idx][k];
				}
			}
			max_side += temp;
			
			while(true) {
				idx++;
				if(idx==N) break;
				
				for(int j=0; j<6; j++) {
					if(dices[idx][j]==top_n) {
						bot_n = top_n;
						bot_i = j;
					}
				}
				top_i = getTop(bot_i);
				top_n = dices[idx][top_i];
				
				temp = 0;
				for(int k=0; k<6; k++) {
					if(k==bot_i || k==top_i) continue;
					else {
						if(dices[idx][k] > temp) temp = dices[idx][k];
					}
				}
				max_side += temp;
			}
			if(max_side > max_ans) {
				max_ans = max_side;
			}
		}
		System.out.println(max_ans);
	}//end of main
	
	private static int getTop(int bottom) {
		int top;
		if(bottom==0 || bottom==5) {
			top = 5 - bottom;
		}
		else if(bottom==1 || bottom==2) {
			top = bottom + 2;
		}
		else {
			top = bottom - 2;
		}
		return top;
	}//end of method: getTop
	
}//end of class
