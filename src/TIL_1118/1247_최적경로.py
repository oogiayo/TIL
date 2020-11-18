def permutation(idx, a, acc):
    global ans
    if acc > ans:
        return
    if idx==N:
        b = 1
        acc += abs(location[a][0]-location[b][0]) + abs(location[a][1]-location[b][1])
        if acc < ans:
            ans = acc
        return

    for b in range(2, N+2):
        if not visited[b]:
            visited[b] = True
            temp = acc + abs(location[a][0]-location[b][0]) + abs(location[a][1]-location[b][1])
            permutation(idx+1, b, temp)
            visited[b] = False


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    line = list(map(int, input().split()))
    visited = [False for _ in range(0, N+2)]
    location = []
    for i in range(0, N+2):
        x = line[2*i]
        y = line[2*i+1]
        location.append((x, y))
    ans = 200*11
    permutation(0, 0, 0)
    print(f'#{tc} {ans}')