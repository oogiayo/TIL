
# ===== N극 ======
#
#            1 (N극)
#             ↓
#                       <= Table
#      ↑
#     2 (S극)
#             
# ===== S극 ======

from collections import deque

T = 10
for tc in range(1, T+1):
    length = int(input())

    table = [[] for r in range(0, length)]

    q = deque()
    for r in range(0, length):
        row = list(map(int, input().split()))
        for (c, magnet) in enumerate(row):
            table[r].append(magnet)
            if magnet==1 or magnet==2:
                q.appendleft((r, c))

    cnt = 0
    while len(q):
        (pr, pc) = q.popleft()
        if table[pr][pc]==1:
            nr = pr + 1
            if 0 <= nr < length and table[nr][pc]==0:
                q.appendleft((nr, pc))
                table[pr][pc] = 0
                table[nr][pc] = 1
            elif nr == length:
                table[pr][pc] = 0
            elif 0 <= nr < length and table[nr][pc]==2:
                table[nr][pc] = 3
                table[pr][pc] = 3
                cnt += 1 

        elif table[pr][pc]==2:
            nr = pr - 1
            if 0 <= nr < length and table[nr][pc]==0:
                q.appendleft((nr, pc))
                table[pr][pc] = 0
                table[nr][pc] = 2
            elif nr == 0:
                table[pr][pc] = 0
            elif 0 <= nr < length and table[nr][pc]==1:
                table[nr][pc] = 3
                table[pr][pc] = 3
                cnt += 1 

    print(f'#{tc} {cnt}')