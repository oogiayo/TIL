package TIL_0804;
import java.util.*;

public class op_Main_bj_15661_링크와스타트 {
    static int[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = sc.nextInt();
            }
        }
        for(int r=0; r<N; r++){
	        System.out.println(Arrays.toString(arr[r]));
        }
        subset(new boolean[N], 0);
    }//end of main

    private static void subset(boolean[] ans, int idx) {
        if(idx==ans.length){
        	int[] tempS = new int[N];
        	int[] tempL = new int[N];
            for(int i=0; i<idx; i++){
            	if(!ans[i]) {
            		tempS[i] = i;
            	}
            	if(ans[i]) {
            		tempL[i] = i;
            	}
            }
            System.out.println();
            return;
        }
        ans[idx] = true;
        subset(ans, idx+1);
        ans[idx] = false;
        subset(ans, idx+1);
    }//end of method
    
}//end of class