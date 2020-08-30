package TIL_0830;
import java.util.Arrays;

class Solution_kakao_p3 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int size = N + M*2 - 2;
        int[][] arr = new int[size][size];
        
        int cnt_lock = 0;
        int cnt;
        for(int r=0; r<N; r++) {
        	for(int c=0; c<N; c++) {
        		arr[M-1+r][M-1+c] = lock[r][c]+1;
        		if(lock[r][c]==0) {
        			cnt_lock++;
        		}
        	}
        }
        
        for(int r=0; r<N+M-1; r++) {
        	for(int c=0; c<N+M-1; c++) {
        		cnt = 0;
        		L:for(int y=0; y<M; y++) {
        			for(int x=0; x<M; x++) {
        				if(arr[r+y][c+x]==1 && arr[r+y][c+x]==key[y][x]) {
        					cnt++;
        				}
        				if(arr[r+y][c+x]==2 && key[y][x]==1) {
        					break L;
        				}
        			}
        		}
        		if(cnt==cnt_lock) {
        			return true;
        		}
        	}
        }
        
        int[][] opener = new int [M][M];
        for(int r=0; r<M; r++) {
        	for(int c=0; c<M; c++) {
        		opener[c][M-1-r] = key[r][c];
        	}
        }
        for(int r=0; r<N+M-1; r++) {
        	for(int c=0; c<N+M-1; c++) {
        		cnt = 0;
        		L:for(int y=0; y<M; y++) {
        			for(int x=0; x<M; x++) {
        				if(arr[r+y][c+x]==1 && arr[r+y][c+x]==opener[y][x]) {
        					cnt++;
        				}
        				if(arr[r+y][c+x]==2 && opener[y][x]==1) {
        					break L;
        				}
        			}
        		}
        		if(cnt==cnt_lock) {
        			return true;
        		}
        	}
        }
        
        
        for(int r=0; r<M; r++) {
        	for(int c=0; c<M; c++) {
        		opener[M-1-r][M-1-c] = key[r][c];
        	}
        }
        for(int r=0; r<N+M-1; r++) {
        	for(int c=0; c<N+M-1; c++) {
        		cnt = 0;
        		L:for(int y=0; y<M; y++) {
        			for(int x=0; x<M; x++) {
        				if(arr[r+y][c+x]==1 && arr[r+y][c+x]==opener[y][x]) {
        					cnt++;
        				}
        				if(arr[r+y][c+x]==2 && opener[y][x]==1) {
        					break L;
        				}
        			}
        		}
        		if(cnt==cnt_lock) {
        			return true;
        		}
        	}
        }
        
        for(int r=0; r<M; r++) {
        	for(int c=0; c<M; c++) {
        		opener[M-1-c][r] = key[r][c];
        	}
        }
        for(int r=0; r<N+M-1; r++) {
        	for(int c=0; c<N+M-1; c++) {
        		cnt = 0;
        		L:for(int y=0; y<M; y++) {
        			for(int x=0; x<M; x++) {
        				if(arr[r+y][c+x]==1 && arr[r+y][c+x]==opener[y][x]) {
        					cnt++;
        				}
        				if(arr[r+y][c+x]==2 && opener[y][x]==1) {
        					break L;
        				}
        			}
        		}
        		if(cnt==cnt_lock) {
        			return true;
        		}
        	}
        }
        return false;
    }
}