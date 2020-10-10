def preOrder(parent):
    global cnt_leaf
    isLeaf = True
    for node in range(0, N):
        if info_parent[node]==parent:
            preOrder(node)
            isLeaf = False
    if isLeaf:
        cnt_leaf += 1        


N = int(input())

info_parent = list(map(int, input().split()))
K = int(input())
info_parent[K] = -2
cnt_leaf = 0
for node in range(0, N):
    if info_parent[node]==-1:
        preOrder(node)

print(cnt_leaf)

