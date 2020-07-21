T = int(input())
for tc in range(1, T+1):
    A, B, C = map(int, input().split())
    print(f'#{tc} {C//min(A,B)}')