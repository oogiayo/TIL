package TIL_1202;
import java.util.Scanner;

public class Solution_d3_2112_보호필름 {
	static int D, W, K;	// 깊이, 너비, 필요 통과기준
	static int[][] film; // 보호필름의 상태 저장 배열
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			for(int r=0; r<D; r++) {
				for(int c=0; c<W; c++) {
					film[r][c] = sc.nextInt();
				}
			}
			ans = 987654321;
			solve(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// 상태공간트리의 상태는, 몇 번째 행을 주입여부 결정중이며, 지금까지 주입한 횟수는 몇인지
	static void solve(int row, int cnt) {
		if (isOk()) {
			ans = Math.min(ans, cnt);
			return;
		}
		// 발견된 최소 횟수 넘어갔으므로 볼 것도 없음
		if (ans < cnt) return;
		// 마지막 행까지 검사 완료
		if (row==D) return;
		
		// 그냥 가기
		solve(row+1, cnt);
		// 원래 필름의 상태 백업
		int[] tmp = new int[W];
		for(int c=0; c<W; c++) {
			tmp[c] = film[row][c];
		}
		// A 주입하고 가기
		for(int c=0; c<W; c++) {
			film[row][c] = 0;
		}
		solve(row+1, cnt+1);
		// B 주입하고 가기
		for(int c=0; c<W; c++) {
			film[row][c] = 1;
		}
		solve(row+1, cnt+1);
		// 원래 필름의 상태로 원상복구
		for(int c=0; c<W; c++) {
			film[row][c] = tmp[c];
		}
	}
	
	// 셀 합격 검사 메서드
	static boolean isOk() {
		// 모든 열을 검사
		for(int c=0; c<W; c++) {
			// 연속한 셀의 개수
			boolean colOk = false;
			int cnt = 1;
			// 1번 행부터 => 이전행==현재행 검사
			for(int r=1; r<D; r++) {
				if (film[r][c] != film[r-1][c]) cnt = 1;
				else cnt++;
				if (cnt==K) {
					colOk = true;
					break;
				}
			}
			// 검사를 마친 열이 기준 미달 => 전체 셀도 불합격(false)
			if (!colOk) {
				return false;
			}
		}
		// 모든 열이 합격이므로 전체 셀도 합격(true)
		return true;
	}
}
