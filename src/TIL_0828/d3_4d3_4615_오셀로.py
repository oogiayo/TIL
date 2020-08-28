def check(r, c, k, color, idx):
    if 0<=r<N and 0<=c<N and brd[r][c]==color:
        for i in range(1, idx+1):
            brd[r - dr[k]*i][c - dc[k]*i] = color
        return
    if 0<=r<N and 0<=c<N and brd[r][c]==3-color:
        check(r + dr[k], c + dc[k], k, color, idx+1)

dr = [-1,1,0,0, -1,-1,1,1]
dc = [0,0,-1,1, -1,1,-1,1]

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    brd = [[0]*N for _ in range(0, N)]

    brd[N//2-1][N//2-1] = 2
    brd[N//2][N//2] = 2
    brd[N//2-1][N//2] = 1
    brd[N//2][N//2-1] = 1

    for i in range(0, M):
        c, r, color = map(int, input().split())
        brd[r-1][c-1] = color
        for k in range(0, 8):
            nr = r-1 + dr[k]
            nc = c-1 + dc[k]
            if 0<=nr<N and 0<=nc<N and brd[nr][nc]==3-color:
                check(nr, nc, k, color, 0)

    cnt_B = 0
    cnt_W = 0
    for r in range(0, N):
        for c in range(0, N):
            if brd[r][c]==1:
                cnt_B += 1
            elif brd[r][c]==2:
                cnt_W += 1

    print(f'#{tc} {cnt_B} {cnt_W}')
