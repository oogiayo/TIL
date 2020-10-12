import sys

def find_root(node):
    if parent[node]==node:
        return node
    parent[node] = find_root(parent[node])
    return parent[node]


def union(node1, node2):
    root1 = find_root(node1)
    root2 = find_root(node2)
    if root1 == root2:
        return
    parent[root1] = root2


n, m = map(int, sys.stdin.readline().split())

parent = [num for num in range(0, n+1)]
for i in range(0, m):
    cmd, a, b = map(int, sys.stdin.readline().split())
    if cmd==0:
        union(a, b)
    else:
        A = find_root(a)
        B = find_root(b)
        if A==B:
            sys.stdout.write('YES\n')
        else:
            sys.stdout.write('NO\n')

