package TIL_0910;
import java.util.Arrays;

public class Kakao05_fail {
	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		System.out.println(solution(n, build_frame1));
		
		int[][] build_frame2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		System.out.println(solution(n, build_frame2));
	}
    public static int[][] solution(int n, int[][] build_frame) {
        
        int[] dr = {1, 0, 0, 1};
        int[] dc = {0, -1, 1, 1};
        int[][] map = new int[n+1][n+1];
        int cnt = 0;
        
        for(int[] command : build_frame) {
        	int x = command[0], y = command[1];
        	int isBeam = command[2];
        	// 생성
        	if(command[3]==1) {
        		cnt ++;
        		for(int k=0; k<2; k++) {
        			int nr = n-y + dr[k];
        			int nc = x + dc[k];
        			
        			if(0<=nr && nr<=n && 0<=nc && nc<=n) {
        				if(map[nr][nc]==0) {
        					continue;
        				}
        				else if(k==0) {
        					if(map[nr][nc] != 2) {
            					map[n-y][x] += isBeam+1;
            					break;
        					}
        				}
        				else if(k==1) {
        					if(map[nr][nc] != 1) {
        						map[n-y][x] += isBeam+1;
            					break;
        					}
        				}
        			}
        			
        			else if(isBeam==0 && y==0) {
        				map[n-y][x] += 1;
        				// 기둥
    					break;
        			}
        			
        			else {
        				// 실패
        				cnt--;
        				continue;
        			}
        		}
        		if(isBeam==1 && map[n-y][x]<2) {
            		for(int k=2; k<4; k++) {
            			int nr = n-y + dr[k];
            			int nc = x + dc[k];
            			
            			if(0<=nr && nr<=n && 0<=nc && nc<=n) {
            				if(k==2 && map[nr][nc]!=0) {
            					map[n-y][x] += 2;
            				}
            				else if(k==3) {
            					if(map[nr][nc]==1 || map[nr][nc]==3) {
            						map[n-y][x] += 2;
            					}
            				}
            			}
            		}
        		}
        	}
        	// 삭제
        	else {
        		cnt--;
    			int l = x-1;
    			int r = x+1;
    			int up = y+1;
    			int down = y-1;
    			if(map[n-y][x] < isBeam+1) {
    				cnt++;
    			}
    			else if(isBeam==0) {

        			if(l>=0 && up<=n && map[n-y][l]==0 && map[n-up][l]==2 && map[n-up][x]!=2) {
        				cnt++;
        			}
        			else if(r<=n && up<=n && map[n-y][r]==0 && map[n-up][r]==2) {
        				if(l>=0 && map[n-up][l]==2) {
        					map[n-y][x] -= 1;
        				}
        				cnt++;
        			}
        			else {
        				map[n-y][x] -= 1;
        			}
        		}
        		else {
        			
        			if(down>=0 && map[n-down][x]%2==0) {
        				cnt--;
        			}
        			else if(down>=0 & r<=n && map[n-down][r]%2==0) {
        				cnt--;
        			}
        			else {
        				map[n-y][x] -= 2;
        			}
        			
        		}
        		
        	}
        }
        for(int r=0; r<=n; r++) {
        	System.out.println(Arrays.toString(map[r]));
        }
        
        int[][] answer = new int[cnt][3];
        System.out.println(cnt);
        cnt = 0;
        for(int c=0; c<=n; c++) {
        	for(int r=n; r>=0; r--) {
        		if(map[r][c]==3) {
        			for(int i=0; i<2; i++) {
            			answer[cnt][0] = c;
            			answer[cnt][1] = n-r;
            			answer[cnt][2] = 1-i;
            			cnt++;
        			}
        		}
        		else if(map[r][c]==1 || map[r][c]==2) {
        			answer[cnt][0] = c;
        			answer[cnt][1] = n-r;
        			answer[cnt][2] = map[r][c]-1;
        			cnt++;
        		}
        	}
        }
        System.out.println(Arrays.deepToString(answer));
        
        return answer;
    }
}