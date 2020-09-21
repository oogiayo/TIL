import copy
from collections import deque

T = int(input())

def shot(r0, c0, mapp):
    global dr, dc, H

    power0 = mapp[r0][c0]
    q = deque()
    q.append((r0, c0, power0))
    while q:
        r, c, power = q.popleft()
        for k in range(0, 4):
            for i in range(0, power):
                r = r + dr[k] * power
                c = c + dc[k] * power
                if 0<=r<H and 0<=c<W and mapp[r][c]!=0:
                    n_power = mapp[r][c]
                    mapp[r][c] = 0
                    q.append(r, c, n_power)



dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

for tc in range(1, T+1):
    N, W, H = map(int, input().split())
    # N 깨는 횟수 W 가로 H 높이
    
    mapp = [[] for _ in range(0, W)]
    for r in range(1, H+1):   
        line = list(map(int, input().split()))
        for c in range(0, W):
            if line[c]!=0:
                mapp[c].append(line[c])
            # mapp[c][-r] = line[c]

    for r in range(0, W):
        print(mapp[r])
    print()


    # for c in range(0, W):
    #     shot(0, c, copy.deepcopy(mapp))


