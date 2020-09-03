from collections import deque

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    pizza = list(map(int, input().split()))

    q = deque()

    for idx in range(0, N):
        q.append((idx+1, pizza.pop(0)))

    ans = 0
    add = 0
    while q:
        pn, cheese = q.popleft()
        cheese //= 2

        if cheese==0:
            ans = pn
            add += 1
            if len(pizza) > 0:
                q.append((N + add, pizza.pop(0)))

        else:
            q.append((pn, cheese))

    print(f'#{tc} {ans}')
