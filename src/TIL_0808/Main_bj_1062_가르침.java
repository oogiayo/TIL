package TIL_0808;
import java.util.*;

public class Main_bj_1062_가르침 {
	static String[] words;
	static char[] chars;
	static int max;
	static HashSet<Character> s = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt()-5;
		words = new String[N];
		max = 0;
		for(int i=0; i<N; i++) {
			String word = sc.next();			
			words[i] = word.substring(4, word.length()-4);
			for(int j=0; j<words[i].length(); j++) {
				char c = words[i].charAt(j);
				if(c=='a' || c=='n'|| c=='t'|| c=='i'|| c=='c') continue;
				s.add(c);
			}
		}
		chars = new char[s.size()];
		int x = 0;
		for(char c : s) {
			chars[x] = c;
			x++;
		}
		if(K < 0) {
			System.out.println(0);
		}
		else if(K > chars.length) {
			System.out.println(N);
		}
		else {
			Combination(new char[K], 0, 0);
			System.out.println(max);
		}

	}//end of main
	
	private static void Combination(char[] ans, int idx, int r) {
		if(r==ans.length) {
			int cnt = 0;
			for(int i=0; i<words.length; i++) {
				boolean[] check = new boolean[words[i].length()];
				for(int j=0; j<words[i].length(); j++) {
					if(words[i].charAt(j)=='a' || words[i].charAt(j)=='n' || words[i].charAt(j)=='t' || words[i].charAt(j)=='i' || words[i].charAt(j)=='c') {
						check[j] = true;
						continue;
					}
					for(int k=0; k<ans.length; k++) {
						if(words[i].charAt(j)==ans[k]) {
							check[j] = true;
							break;
						}
					}
				}
				boolean flag = true;
				for(int l=0; l<check.length; l++) {
					if(!check[l]) {
						flag = false;
						break;
					}
				}
				if(flag==true) {
					cnt ++;
				}
			}
			if(cnt > max) {
				max = cnt;
			}
			return;
		}
		if(idx==s.size()) return;
		ans[r] = chars[idx];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx+1, r);
	}


}//end of class
