from collections import deque
from copy import deepcopy

def bfs(rR, cR, rB, cB, board, visited, cnt):
    global ans

    visited[rR][cR][0] = True
    visited[rB][cB][1] = True

    q.append((rR, cR, rB, cB, board, visited, cnt))
    while q:
        rR, cR, rB, cB, board, visited, cnt = q.popleft()
        if cnt==10:
            return
        for k in range(0, 4):
            if visited[rR + dr[k]][cR + dc[k]][0]==False or visited[rB + dr[k]][cB + dc[k]][1]==False:#board[rR + dr[k]][cR + dc[k]] != '#' and board[rR +dr[k]][cR + dc[k]] != 'B':#and visited[rR + dr[k]][cR + dc[k]][0]==False:
                visited[rR + dr[k]][cR + dc[k]][0] = True
                visited[rB + dr[k]][cB + dc[k]][1] = True
                
                tilt(rR, cR, rB, cB, k, deepcopy(board), deepcopy(visited), cnt)
                if ans != -1:
                    return


def tilt(rR, cR, rB, cB, k, board, visited, cnt):
    global ans
    # print(f'#{cnt+1}')
    # for row in range(0, N):
    #     print(board[row])
    # print()
    q_ball = deque()

    if isBlueFirst(rR, cR, rB, cB, k):
        q_ball.append((rB, cB, 'B'))
        q_ball.append((rR, cR, 'R'))
    else:
        q_ball.append((rR, cR, 'R'))
        q_ball.append((rB, cB, 'B'))
    
    while q_ball:
        r, c, ball = q_ball.popleft()

        if board[r + dr[k]][c + dc[k]] == 'O':

            if ball=='R':
                # print('일단 골인!')
                board[r][c] = '.'
                ans = cnt + 1
                continue
            else:
                # print('파란색 골인....ㅠㅠ')
                ans = -1
                break
                # return
        
        if board[r + dr[k]][c + dc[k]] != '.':
            if ball=='R':
                rR = r
                cR = c
            else:
                rB = r
                cB = c
            continue

        board[r + dr[k]][c + dc[k]] = ball
        board[r][c] = '.'
        r += dr[k]
        c += dc[k]

        if ball=='R':
            visited[r][c][0] = True
        else:
            visited[r][c][1] = True

        q_ball.append((r, c, ball))

    q.append((rR, cR, rB, cB, board, visited, cnt+1))
    return


def isBlueFirst(rR, cR, rB, cB, k):
    # print(cR, cB)
    if abs(rR-rR)==1 and abs(cR-cB)==1:
        return False

    if rR == rB + 1 and k==0:
        return True
    elif rR == rB - 1 and k==1:
        return True
    elif cR == cB + 1 and k==2:
        return True
    elif cR == cB - 1 and k==3:
        return True
    else:
        return False


# 상, 하, 좌, 우 (빨간공 위주)
dr = [-1,1,0,0]
dc = [0,0,-1,1]

N, M = map(int, input().split())
board = [['' for c in range(0, M)] for r in range(0, N)]
visited = [[[False, False] for c in range(0, M)] for r in range(0, N)]

# 빨간공 위치 선언
rR = 0
cR = 0
# 파란공 위치 선언
rB = 0
cB = 0  
for r in range(0, N):
    row = input()
    for c in range(0, M):
        board[r][c] = row[c]
        # 빨간공 초기 위치
        if row[c]=='R':
            rR = r
            cR = c
            # visited[r][c][0] = True
        # 파란공 초기 위치
        elif row[c]=='B':
            rB = r
            cB = c
            # visited[r][c][1] = True

q = deque()

ans = -1

bfs(rR, cR, rB, cB, board, visited, 0)
print(ans)

