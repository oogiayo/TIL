package TIL_0721;
import java.util.*;

public class Solution_d3_4466_최대성적 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] score = new int[N];
            for(int i=0; i<N; i++){
                score[i] = sc.nextInt();
            }
            Arrays.sort(score);
            int sum = 0;            
            for(int i=N-K; i<N; i++){
                sum += score[i];
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
