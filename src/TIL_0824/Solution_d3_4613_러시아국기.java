package TIL_0824;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_d3_4613_러시아국기 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		for(int t=1; t<=T; t++) {			
			String[] NM = bf.readLine().split(" ");
			int N = Integer.valueOf(NM[0]);
			int M = Integer.valueOf(NM[1]);
			char[][] map = new char[N][M];
			for(int r=0; r<N; r++) {
				char[] line = bf.readLine().toCharArray();
				for(int c=0; c<M; c++) {
					map[r][c] = line[c];
				}
			}
			int min_paint = 2500;
			for(int w=1; w<N-1; w++) {
				for(int b=1; b<N-w; b++) {
					int sum_paint = 0;
					for(int i=0; i<w; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j]=='W') continue;
							else sum_paint++;
						}
					}
					for(int i=w; i<w+b; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j]=='B') continue;
							else sum_paint++;
						}
					}
					for(int i=w+b; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j]=='R') continue;
							else sum_paint++;
						}
					}
					if(sum_paint < min_paint) {
						min_paint = sum_paint;
					}
				}
			}
			System.out.println("#" + t + " " + min_paint);
		}//end of tc
		
	}	
}
