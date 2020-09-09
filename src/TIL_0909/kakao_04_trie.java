package TIL_0909;

public class kakao_04_trie {
	
	public static void main(String[] args) {
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		
		System.out.println(solution(words, queries));
	}
    
	public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        Trie[] tries = new Trie[10001];
        Trie[] rtries = new Trie[10001];
        
        for (String word : words) {
        	int size = word.length();
        	try {
        		tries[size].insert(word.toCharArray());
        	}
        	catch(Exception e){
        		tries[size] = new Trie();
        		tries[size].insert(word.toCharArray());
        	}
        	
        	word = (new StringBuffer(word).reverse().toString());
        	try {
        		rtries[size].insert(word.toCharArray());
        	}
        	catch(Exception e){
        		rtries[size] = new Trie();
        		rtries[size].insert(word.toCharArray());
        	}
        }

        for(int i=0; i<queries.length; i++) {
    		String query = queries[i];
    		if(query.indexOf("?")==0) {
    			try {
    				query = (new StringBuffer(query).reverse().toString());
    				answer[i] = rtries[query.length()].search(query.toCharArray());
    			}
    			catch(Exception e) {
    				continue;
    			}
    		}
    		else {
    			try {
    				answer[i] = tries[query.length()].search(query.toCharArray());
    			}
    			catch(Exception e) {
    				continue;
    			}
    		}
    	}        
        
        return answer;
    }
	
}

class Trie {
	
	int count;
	Trie[] childList;
	
	Trie() {
		childList = new Trie[26];
		count = 0;
	}
	
	void insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			current.count++;
			if(current.childList[no - 'a'] != null){
				current = current.childList[no - 'a'];
			}
			else {
				current.childList[no - 'a'] = new Trie();
				current = current.childList[no - 'a'];
			}
		}
	}
	
	int search(char[] query) {
		Trie current = this;
		for (char no : query) {
			if (no == '?') {
				return current.count;
			}
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a'];
			}
			else {
				return 0;
			}
		}
		return current.count;
		
	}
	
}
