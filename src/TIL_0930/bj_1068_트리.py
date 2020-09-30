def preOrder(node):
    global cnt_leaf
    if node < N:
        # 부모노드가 없을 경우 (잘린 가지 부분) => 없는걸로 취급
        if node > 0 and parents[node] == -1:
            return 0

        # 자식노드 개수의 합이 0일 경우 (leaf임) 
        cnt_childs = preOrder(node*2 + 1) + preOrder(node*2 + 2)
        if cnt_childs == 0:
            cnt_leaf += 1       
        return 1

    # 트리 밖의 노드번호일 경우 => 없는 노드임
    else:
        return 0


def deleteNode(node):
    # while True:
    for i in range(0, 2):
        if tree[node][i]!=0:
            deleteNode(tree[node][i])
            tree[node][i] = 0


N = int(input())

tree = [[0, 0] for _ in range(0, N+1)]
parents = [0] + list(map(int, input().split()))
node_del = int(input()) + 1
# parent_of_node_del = parents[node_del]

for i in range(1, N+1):
    if parents[i]==-1:
        continue
    else:
        if tree[parents[i]+1][0]==0:
            tree[parents[i]+1][0] = i
        else:
            tree[parents[i]+1][1] = i

# deleteNode(node_del)

# for i in range(1, N+1):
    

print(tree)

# parents[node_del] = -1
# cnt_leaf = 0

# if node_del==0:
#     pass
# else:   
#     # 0번 노드부터 순회
#     preOrder(0)

# print(cnt_leaf)?
