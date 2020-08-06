T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [[] for r in range(0, N)]
    for r in range(0, N):
        row = list(map(int, input().split()))
        arr[r] = row
    
    max_dead = 0
    dr = []
    dc = []
    for r in range(0, M):
        for c in range(0, M):
            dr += [r]
            dc += [c]

    for r in range(0, N-M+1):
        for c in range(0, N-M+1):
            sum_dead = 0
            for k in range(0, M**2):
                nr = r + dr[k]
                nc = c + dc[k]
                if 0<=nr<N and 0<=nc<N:
                    sum_dead += arr[nr][nc]
            if sum_dead > max_dead:
                max_dead = sum_dead           

    print(f'#{tc} {max_dead}')