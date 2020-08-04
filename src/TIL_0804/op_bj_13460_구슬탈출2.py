from collections import deque

class Pair:
    def __init__(self, rR, cR, rB, cB, cnt):
        self.rR = rR
        self.cR = cR
        self.rB = rB
        self.cB = cB
        self.cnt = cnt
        
dr = [-1,1,0,0]
dc = [0,0,-1,1]

N, M = map(int, input().split())
board = [['' for c in range(0, M)] for r in range(0, N)]
visited = [[[False, False] for c in range(0, M)] for r in range(0, N)]

q = deque()    
for r in range(0, N):
    row = input()
    for c in range(0, M):
        board[r][c] = row[c]
        if row[c]=='R':
            rR = r
            cR = c
            visited[r][c][0] = True
        elif row[c]=='B':
            rB = r
            cB = c
            visited[r][c][1] = True

ans = 0
q.appendleft(Pair(rR, cR, rB, cB, 0))
while len(q):
    p = q.popleft()
    if ans > 0:
        break
    if p.cnt > 10:
        ans = -1
        break

    for k in range(0, 4):
        nrR = p.rR + dr[k]
        ncR = p.cR + dc[k]
        nrB = p.rB + dr[k]
        ncB = p.cB + dc[k]
        
        if board[nrR][ncR]=='O':
            ans = p.cnt + 1

        if board[nrR][ncR]=='.' and visited[nrR][ncR][0]==False:
            visited[nrR][ncR][0] = True
            board[rR][cR] = '.'
            board[nrR][ncR] = 'R'

            if board[ncB][ncB]=='.' and visited[nrB][ncB][1]==False:
                visited[ncR][ncR][1] = True
                board[rB][cB] = '.'
                board[nrB][ncB] = 'B'
            elif board[ncB][ncB]=='#':
                nrB = p.rB
                ncB = p.cB
            elif board[ncB][ncB] == 'O':
                break

            q.appendleft(Pair(nrR, ncR, nrB, nrB, p.cnt+1))

for r in range(0, N):
    print(board[r])
print(ans)