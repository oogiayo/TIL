from collections import deque

T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())
    grph = [[0 for c in range(0, N)] for r in range(0, N)]
    
    for i in range(0, M):
        x, y = map(int, input().split())
        grph[x-1][y-1] = 1
        grph[y-1][x-1] = 1

    cnt = 0
    q = deque()
    for r in range(0, N):
        # r < c
        for c in range(r+1, N):
            if grph[r][c]==1:
                q.appendleft((r, c))
                while len(q):
                    (i, j) = q.popleft()
                    # (i < j) < k
                    for k in range(c+1, N):
                        if grph[j][k]==1 and grph[k][i]==1:
                            cnt += 1

    print(f'#{tc} {cnt}')