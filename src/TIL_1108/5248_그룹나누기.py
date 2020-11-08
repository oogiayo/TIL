from collections import deque

def bfs():
    while q:
        me = q.popleft()
        for friend in range(0, N):
            if not visited[friend] and arr[me][friend]:
                visited[friend] = True
                q.append(friend)


T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [[0]*N for _ in range(0, N)]
    visited = [False] * N
    
    line = list(map(int, input().split()))
    for i in range(0, M):
        a = line[2*i]-1
        b = line[2*i+1]-1
        arr[a][b] = 1
        arr[b][a] = 1

    cnt = 0
    q = deque()
    for person in range(0, N):
        if not visited[person]:
            visited[person] = True
            q.append(person)
            bfs()
            cnt += 1
    
    print(f'#{tc} {cnt}')