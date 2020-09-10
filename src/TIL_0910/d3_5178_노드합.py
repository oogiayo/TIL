def fillNode(idx):
    if idx <= N:
        if not tree[idx]:
            value = 0
            value += fillNode(idx*2)
            value += fillNode(idx*2+1)
            tree[idx] = value
            return value
        else:
            return tree[idx]

    return 0

T = int(input())

for tc in range(1, T+1):
    N, M, L = map(int, input().split())
    tree = [0]*(N+1)
    for i in range(0, M):
        leaf = list(map(int, input().split()))
        tree[leaf[0]] = leaf[1]

    fillNode(1)
    print(f'#{tc} {tree[L]}')
