from collections import deque

def bfs(node):
    invited[1] = True
    q = deque()
    q.append((node, 0))
    cnt = 0
    while q:
        me, depth = q.popleft()
        if depth > 1:
            continue
        for friend in rlsp[me]:
            if not invited[friend]:
                invited[friend] = True
                q.append((friend, depth+1))
                cnt += 1
                continue
    return cnt


T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    rlsp = [[] for _ in range(0, N+1)]
    invited = [False] * (N+1)
    for i in range(0, M):
        a, b = map(int, input().split())
        rlsp[a].append(b)
        rlsp[b].append(a)
        
    ans = bfs(1)
    print(f'#{tc} {ans}')
