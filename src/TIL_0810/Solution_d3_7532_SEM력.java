package TIL_0810;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_7532_SEM력 {
	public static void main(String[] args) throws IOException { 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1; t<=T; t++) {
			String[] line = bf.readLine().split(" ");
			int S = Integer.parseInt(line[0]);
			int E = Integer.parseInt(line[1]);
			int M = Integer.parseInt(line[2]);
			while(S!=E || S!=M || E!=M) {
				if(S < E && S < M) {
					S += 365;
				}
				else {
					if(E <= M) {
						E += 24;
					}
					else {
						M += 29;
					}
				}
			}			
			System.out.println("#" + t + " " + S);
		}
	}//end of main
}//end of class
