package TIL_0905;
import java.util.*;
public class kakao_04_fail {
	public static void main(String[] args) {
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		
		System.out.println(solution(words, queries));
	}
    
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
        return answer;
    }
}

class Trie {
	int count;
	Trie[] childList = new Trie[26];
	
	Trie() {
		childList = new Trie[26];
	}
}