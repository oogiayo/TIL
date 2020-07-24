package TIL_0723;
import java.util.*;

public class Solution_d3_5986_세소수합 {
	static boolean[] visited = new boolean[1000];
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			for(int i=2; i<N; i++) {	// N-4 까지 찾아도 되지만 편의상 N까지 탐색한다.
				if(!visited[i]) {
					int temp = i + i;
					while (temp<N) {
						visited[temp] = true;
						temp += i;
					}
				}
			}
			Recombination(new int[3], 2, 0);
		}
	}//end of main
	
	private static void Recombination(int[] ans, int idx, int r) {
		if(r==ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx==N) {	// N-4까지 찾아도 되지만 편의상 N으로 둔다.
			return;
		}
		if(!visited[idx]) {
			ans[r] = idx;
		}
		else return;
		Recombination(ans, idx, r+1);
		Recombination(ans, idx+1, r);
	}
}//end of class


//T = int(input())
//
//def Recombination(ans, idx, r):
//    if r==3:
//        sum_of_3 = sum(ans)
//        if sum_of_3==N:
//            tot_list[0] += 1
//        return
//    if idx==len(prime_list):
//        return
//    if ans[0] > N/3:
//        return
//    ans[r] = prime_list[idx]
//    Recombination(ans, idx, r+1)
//    Recombination(ans, idx+1, r)
//
//for tc in range(1, T+1):
//    N = int(input())
//
//    prime_list = []
//    for num in range(2, N):
//        check_num = True    # initial value
//        for i in range(2, int(num**2/2)):
//            if num%i==0 and num!=i:
//                check_num = False   # is not prime number
//                break
//        if check_num:
//            prime_list.append(num)
//    
//    tot_list = [0]
//    Recombination([0]*3, 0, 0)
//    print(f'#{tc} {tot_list[0]}')