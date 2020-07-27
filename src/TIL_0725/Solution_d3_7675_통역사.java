package TIL_0725;
import java.util.*;

public class Solution_d3_7675_통역사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			System.out.print("#" + t + " ");

			int check = 0;
			int isSentence = 0;
			int cnt = 0;
			while(check<N) {
				String word = sc.next();
				System.out.println(word);
				if(word.length()==1) {
					if(65<=Integer.parseInt(word) && Integer.parseInt(word)<=90) {
						cnt++;
					}
				}
				else {
					String l_end = word.substring(word.length()-1);
					if(l_end.equals(".") || l_end.equals("!") || l_end.equals("?")) {
						isSentence = 1;
						check += 1;
					}
					if(65<=(byte)word.charAt(0) && (byte)word.charAt(0)<=90) {
						cnt++;
						for(int i=1; i<word.length(); i++) {
							if(i==word.length()-1) {
								if(l_end.equals(".") || l_end.equals("!") || l_end.equals("?") || (97<=(byte)word.charAt(i) && (byte)word.charAt(i)<=122)) {
									continue;
								}
								else {
									cnt--;
									continue;
								}
							}
							if(97<=(byte)word.charAt(i) && (byte)word.charAt(i)<=122) {
								continue;
							}
							else {
								cnt--;
								break;
							}
						}
					}
				}
				if(isSentence==1) {
					System.out.print(cnt + " ");
					isSentence = 0;
					cnt = 0;
				}
			}
			System.out.println();
		}//end of tc
	}//end of main
}//end of class
