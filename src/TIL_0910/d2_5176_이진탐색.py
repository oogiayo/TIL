def inOrder(idx):
    global N, count
    if  idx<=N:
        inOrder(idx*2)
        tree[idx] = count
        count += 1
        inOrder(idx*2+1)


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    tree = [idx for idx in range(0, N+1)]

    count = 1
    inOrder(1)
    print(f'#{tc} {tree[1]} {tree[N//2]}')
  
