def postOrder(idx):
    if idx:
        postOrder(tree[int(idx)][1])
        print(tree[int(idx)][0], end='')
        postOrder(tree[int(idx)][2])


T = 10

for tc in range(1, T+1):
    N = int(input())
    
    visited = [False] * (N+1)
    tree = [[] for _ in range(0, N+1)]
    chars = [''] * (N+1)
    for i in range(1, N+1):
        line = input().split()
        tree[i].extend(line[1:])
        lack = 3-len(tree[i])
        for j in range(0, lack):
            tree[i].append(None)


    print(f'#{tc}', end=' ')
    postOrder(1)
    print()
