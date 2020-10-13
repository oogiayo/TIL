N, M = map(int, input().split())

info = [[0]*N for _ in range(0, N)]
for i in range(0, M):
    x1, x2 = map(int, input().split())
    info[x1-1][x2-1] = 1
    info[x2-1][x1-1] = 1

cnt = 0
for i in range(0, N-2):
    for j in range(i+1, N-1):
        if info[i][j]==1:
            continue
        for k in range(j+1, N):
            if info[i][k]==1 or info[j][k]==1:
                continue
            else:
                cnt += 1

print(cnt)

