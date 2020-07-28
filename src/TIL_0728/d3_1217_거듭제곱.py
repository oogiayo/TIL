def recursive(n, m):
    if m==1:
        return n
    return n*recursive(n, m-1)

T = 10
for tc in range(1, T+1):
    tc = int(input())
    N, M = map(int, input().split())
    
    print(f'#{tc} {recursive(N, M)}')