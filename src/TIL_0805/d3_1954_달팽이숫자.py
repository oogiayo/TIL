dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

T = int(input())
for tc in range(1, T+1):
    N = int(input())

    arr_snail = [[0 for c in range(0, N)] for r in range(0, N)]
    r0, c0 = 0, 0
    cnt = 1
    arr_snail[r0][c0] = cnt
    while cnt<(N**2-1):
        for k in range(0, 4):
            nr = r0 + dr[k]
            nc = c0 + dc[k]
            while True:
                if 0<=nr<N and 0<=nc<N and arr_snail[nr][nc]==0:
                    cnt += 1
                    arr_snail[nr][nc] = cnt
                    nr += dr[k]
                    nc += dc[k]
                else:
                    r0 = nr - dr[k]
                    c0 = nc - dc[k]
                    break
    if N%2:
        arr_snail[N//2][N//2] = N**2

    print(f'#{tc}')
    for r in range(0, N):
        for c in range(0, N):
            print(arr_snail[r][c], end=' ')
        print()