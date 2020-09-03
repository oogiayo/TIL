from collections import deque

dr = [-1,1,0,0]
dc = [0,0,-1,1]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    maze = [[0]*N for _ in range(0, N)]
    visited = [[False]*N for _ in range(0, N)]
    q = deque()

    for r in range(0, N):
        line = input()
        for c in range(0, N):
            maze[r][c] = int(line[c])
            if maze[r][c]==2:
                q.appendleft((r, c, 0))
                visited[r][c] = True

    ans = 0
    while q:
        pr, pc, cnt = q.popleft()
        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            if 0<=nr<N and 0<=nc<N and visited[nr][nc]==False:
                if maze[nr][nc]==0:
                    visited[nr][nc] = True
                    q.appendleft((nr, nc, cnt+1))
                elif maze[nr][nc]==3:
                    ans = cnt
                    break

    print(f'#{tc} {ans}')
