package TIL_0808;
import java.util.*;

public class op_Main_bj_1062_가르침 {
	static char[] alpha;
	static boolean[] teached;
	static String[] words;
	static int K, cnt_max;
	
	public static void main(String[] args) {
		teached = new boolean[26];
		teached[0] = true;	//a
		teached[2] = true;	//c
		teached[8] = true;	//i
		teached[13] = true;	//n
		teached[19] = true;	//t
//		for(int i=0; i<26; i++) {
//			
//		}
		
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt()-5;
		cnt_max = 0;
		
		words = new String[N];
		for(int i=0; i<N; i++) {
			String word = sc.next();
			word = word.substring(4, word.length()-4);
			words[i] = word;
//			int cnt = 0;
//			for(int j=0; j<word.length(); j++) {
//				if(teached[word.charAt(j)-'a']==false){
//					cnt += 1;
//				}
//			}
		}
		subSet(new boolean[N], teached.clone(), 0);
		System.out.println(cnt_max);
	}
	
	private static void subSet(boolean[] ans, boolean[] teached, int idx) {
		if(idx==ans.length) {
//			System.out.println(Arrays.toString(teached));
			int cnt_alpha = 0;
			int cnt_word = 0;
			for(int i=0; i<idx; i++) {
				if(ans[i]) {
					cnt_word += 1;
					String word = words[i];
					for(int j=0; j<word.length(); j++) {
						if(teached[word.charAt(j)-'a']==false) {
							teached[word.charAt(j)-'a'] = true;
							cnt_alpha += 1;
						}
					}
//						System.out.print(word + " ");
				}
			}
//			System.out.println();
			if(cnt_alpha <= K && cnt_word > cnt_max) {
//				System.out.println(cnt_alpha);
				cnt_max = cnt_word;
			}
			
			return;
		}
		ans[idx] = true;
		subSet(ans, teached.clone(), idx+1);
		ans[idx] = false;
		subSet(ans, teached.clone(), idx+1);
	}
}
