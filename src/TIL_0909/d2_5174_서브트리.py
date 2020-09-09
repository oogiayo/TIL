def preOrder(node):
    global sum_sub
    if node:
        sum_sub += 1        
        preOrder(tree[node][0])
        preOrder(tree[node][1])

T = int(input())

for tc in range(1, T+1):
    E, N = map(int, input().split())
    V = E+1
    tree = [[0]*2 for _ in range(0, V+1)]
    
    line = list(map(int, input().split()))
    for i in range(0, E):
        p, c = line[i*2], line[i*2+1]

        if tree[p][0]==0:
            tree[p][0] = c
        else:
            tree[p][1] = c

    sum_sub = 0
    preOrder(N)
    print(f'#{tc} {sum_sub}')
