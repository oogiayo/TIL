def check(r, c, k, idx):
    nr = r + dr[k]
    nc = c + dc[k]
    if idx==K-1:
        if 0<=nr<N and 0<=nc<N and pzl[nr][nc]==1:
            return False
        return True
    if 0<=nr<N and 0<=nc<N and pzl[nr][nc]==1:
        return check(nr, nc, k, idx+1)
    else:
        return False

dr = [1,0]
dc = [0,1]

T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())

    pzl = [list(map(int, input().split())) for r in range(0, N)]

    cnt = 0
    for r in range(0, N):
        for c in range(0, N):
            if pzl[r][c] == 1:
                for k in range(0, 2):
                    br = r - dr[k]
                    bc = c - dc[k]
                    if 0<=br<N and 0<=bc<N and pzl[br][bc]==1:
                        continue
                    else:
                        if check(r, c, k, 0)==True:
                            cnt += 1

    print(f'#{tc} {cnt}')
