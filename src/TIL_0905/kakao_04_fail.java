package TIL_0905;
import java.util.*;
public class kakao_04 {
	public static void main(String[] args) {
		String[] words = {"frozen"};
		String[] queries = {"fro???"};
	
		System.out.println(solution(words, queries));
	}
    
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
        
        Map<String, Integer> check = new HashMap<String, Integer>();
        
        for(int i=0; i<queries.length; i++) {
        	
        	if(check.get(queries[i])==null) {
        		int idx = 0;
        		
        		boolean left = true;
        		String l = "";
        		String r = "";
        		int mid = 0;
        		
        		if(queries[i].substring(0, 1).equals("?")) {
        			String[] temp = queries[i].split("\\?");
        			r = temp[temp.length-1];
        			mid = queries[i].length() - r.length();
        		}
        		else {
        			String[] temp = queries[i].split("\\?");
        			l = temp[0];
        			left = false;
        			mid = l.length();
        		}

        		int cnt = 0;
        		for(int j=0; j<words.length; j++) {
        			if(queries[i].length()==words[j].length()) {
                        
        				if(left) {
        					if(words[j].substring(mid).equals(r)) {
        						cnt++;
        					}
        				}
        				else {
        					if(words[j].substring(0, mid).equals(l)) {
        						cnt++;
        					}
        				}
        			}
        		}
        		
        		check.put(queries[i], cnt);
        	}
        	
        	answer[i] = check.get(queries[i]);
        }
       
        
        return answer;
    }
}