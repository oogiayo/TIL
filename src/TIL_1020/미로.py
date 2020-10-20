def dfs(r, c):
    global ans

    visited[r][c] = True
    for k in range(0, 4):
        nr = r + dr[k]
        nc = c + dc[k]
        if 0<=nr<N and 0<=nc<N and maze[nr][nc]==3:
            ans = 1
            return
        if 0<=nr<N and 0<=nc<N and maze[nr][nc]==0 and visited[nr][nc]==False:
            dfs(nr, nc)


dr = [-1,1,0,0]
dc = [0,0,-1,1]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    maze = [[] for _ in range(0, N)]
    visited = [[False]* N for _ in range(0, N)]
    ans = 0
    for r in range(0, N):
        line = list(map(int, input()))
        for c in range(0, N):
            maze[r].append(line[c])
            if line[c]==2:
                r0 = r
                c0 = c

    dfs(r0, c0)
    print(f'#{tc} {ans}') 
