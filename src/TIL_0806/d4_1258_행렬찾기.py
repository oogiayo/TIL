T = int(input())

for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for r in range(0, N)]

    cnt = 0
    ans = []
    for r in range(0, N):
        for c in range(0, N):
            if arr[r][c]!=0:
                cnt += 1
                nr = r
                while True:
                    nr += 1
                    if nr<0 or nr>=N or arr[nr][c]==0:
                        break
                nc = c
                while True:
                    nc += 1
                    if nc<0 or nc>=N or arr[r][nc]==0:
                        break
                
                for x in range(r, nr):
                    for y in range(c, nc):
                        arr[x][y] = 0                   
                ans.append((nr-r, nc-c))

    for i in range(0, cnt):
        min_i = i
        for j in range(i+1, cnt):
            if ans[min_i][0]*ans[min_i][1] > ans[j][0]*ans[j][1]:
                min_i = j
        ans[min_i], ans[i] = ans[i], ans[min_i]

    print(f'#{tc} {cnt}', end=' ')
    for r, c in ans:
        print(f'{r} {c}', end=' ')
    print()