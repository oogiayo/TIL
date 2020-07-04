package TIL_0704;
import java.util.*;

public class Solution_d3_9480_알파벳공부 {
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			String[] knew = new String[N];
			visited = new boolean[N];
			cnt = 0;
			for(int i=0; i<N; i++) {
				String str = sc.next();
				knew[i] = str;
			}
			
			Subset(knew, 0);
			System.out.println("#" + t + " " + cnt);
		}//end of tc
	}//end of main
	
	private static void Subset(String[] list, int idx) {
		if(idx==list.length) {
			boolean[] alphabet = new boolean[26];
			for(int i=0; i<idx; i++) {
				if(!visited[i]) {
					for(int j=0; j<list[i].length(); j++) {
						int letter = list[i].charAt(j)-'a';
						alphabet[letter] = true;
					}
				}
			}
			int temp = 0;
			for(int i=0; i<26; i++) {
				if(alphabet[i]) temp++;
			}
			if(temp==26) cnt++;
			return;
		}
		visited[idx] = true;
		Subset(list, idx+1);
		visited[idx] = false;
		Subset(list, idx+1);
	}//end of method : Subset
	
}//end of class
