from collections import deque

T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())

    rlsp = [[0]*N for _ in range(0, N)]
    for i in range(0, M):
        info = list(map(int, input().split()))
        if len(info)==1:
            continue
            # rlsp[info[0]-1][info[0]-1] = 1
        elif len(info)==2:
            rlsp[info[0]-1][info[1]-1] = 1
            rlsp[info[1]-1][info[0]-1] = 1

    q = deque()

    cnt = 1
    for r in range(0, N):
        isAlone = 0
        for c in range(0, N):
            if rlsp[r][c]==0:
                isAlone += 1
            elif rlsp[r][c]==1:

                cnt += 1
                rlsp[r][c] = cnt

                q.appendleft((r, c, cnt))
                while q:
                    pr, pc, cnt = q.popleft()

                    for nbor in range(0, N):
                        if rlsp[pc][nbor]==1:
                            rlsp[pc][nbor] = cnt
                            q.appendleft((pc, nbor, cnt))
        if isAlone==N:
            cnt += 1

    print(f'#{tc} {cnt-1}')

