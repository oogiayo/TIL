package TIL_0829;
import java.util.*;
import java.io.*;

public class op_Main_bj_11066_파일합치기 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		for(int t=0; t<T; t++) {
			int K = Integer.valueOf(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] chapter = new int[K];
//			int ans = 10000;
			int[] m = new int[K];
			for(int i=0; i<K; i++) {
				chapter[i] = Integer.valueOf(st.nextToken());
			}
			for(int i=1; i<K-1; i++) {
				for(int j=i; j<K; j++) {
					int sub = Math.min(m[j-1], m[j]);
					for(int k=j-i; k<=j; k++) {
						sub += chapter[k];
					}
				}
			}
		}
	}
}
