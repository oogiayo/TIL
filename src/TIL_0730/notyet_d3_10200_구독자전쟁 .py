T = int(input())

for tc in range(1, T+1):
    N, A, B = map(int, input().split())
    max_both = min(A, B)
    min_both = A + B - N
    if min_both < 0:
        min_both = 0

    print(f'#{tc} {max_both} {min_both}')