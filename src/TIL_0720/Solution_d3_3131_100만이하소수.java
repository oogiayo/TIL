package TIL_0720;
import java.util.*;

public class Solution_d3_3131_100만이하소수 {
	public static void main(String[] args) {
		boolean[] visited = new boolean[1000002];
		visited[1] = true;
		for(int i=2; i<=1000000; i++) {
			if(visited[i]==false) {
				System.out.print(i + " ");
				int j = 2;
				while(true) {
					if(i*j>1000000) {
						break;
					}
					visited[i*j] = true;
					j++;
				}
			}
		}
	}//end of main
}//end of class
