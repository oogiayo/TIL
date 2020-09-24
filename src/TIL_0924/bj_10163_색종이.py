N = int(input())

mapp = [[0]*101 for _ in range(0, 101)]
ans = [0 for _ in range(0, N+1)]

for i in range(1, N+1):
    info = list(map(int, input().split()))
    c0 = info[0]
    r0 = info[1]
    W = info[2]
    H = info[3]
    
    for r in range(0, H):
        for c in range(0, W):
            if mapp[r0+r][c0+c] != 0:
                ans[mapp[r0+r][c0+c]] -= 1
            mapp[r0+r][c0+c] = i
            ans[i] += 1

for i in range(1, N+1):
    print(ans[i])
