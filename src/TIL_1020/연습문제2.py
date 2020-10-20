def dfs(node):
    for next in range(1,8):
        if arr[node][next]==1 and visited[next]==False:
            visited[next] = True
            print(-next, end='')
            dfs(next)
        
INPUT = [1, 2, 1, 3, 2, 4, 2, 5, 4, 6, 5, 6, 6, 7, 3, 7]

arr = [[0]*8 for _ in range(0, 8)]
visited = [False for _ in range(0, 8)]
for i in range(0, len(INPUT), 2):
    arr[INPUT[i]][INPUT[i+1]] = 1
    arr[INPUT[i+1]][INPUT[i]] = 1

visited[1] = True
print(1, end='')
dfs(1)

