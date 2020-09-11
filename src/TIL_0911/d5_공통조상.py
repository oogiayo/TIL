def preOrder(n):
    global node1, node2

    if 0 < n <= V:
        if n==node1 or n==node2:
            return n

        a = preOrder(tree[n][0])
        b = preOrder(tree[n][1])
        ans[n] += a + b

        if ans[n]==node1+node2 and not found:
            found.append(n)
            return a+b

        return ans[n]
    return 0


def count(node):
    global cnt

    if 0 < node <= V:
        cnt += 1
        count(tree[node][0])
        count(tree[node][1])
    
    return


T = int(input())

for tc in range(1, T+1):
    V, E, node1, node2 = map(int, input().split())
    tree = [[0]*2 for _ in range(0, V+1)]

    line = list(map(int, input().split()))
    for i in range(0, E):
        a, b = line[2*i], line[2*i+1]
        if not tree[a][0]:
            tree[a][0] = b
        else:
            tree[a][1] = b
    
    ans = [0]*(V+1)
    cnt = 0
    

    found = []
    preOrder(1)
    count(found[0])   
    print(f'#{tc} {found[0]} {cnt}')
